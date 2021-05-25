package com.liuchq.Moxy.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.liuchq.Moxy.bean.Course;
import com.liuchq.Moxy.constant.MyConstants;
import com.liuchq.Moxy.dao.CourseMapper;
import com.liuchq.Moxy.service.StudyService;
import com.liuchq.Moxy.utils.MyUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: liuchq
 * @date: 2021/5/21 15:41
 * @description: 实现类
 */
@Service
public class StudyServiceImpl implements StudyService {

    private static final Logger logger = LogManager.getLogger("StudyServiceImpl");

    @Autowired
    private CourseMapper courseMapper;

    @Override
    public List<Map<String, String>> getCourse(String userAccount) {
        List<Map<String,String>> courseList = new ArrayList<>();

        List<Course> courses = courseMapper.selectNotFinishCourseByUserAccount(userAccount);

        courses.forEach(item -> courseList.add(new HashMap<String,String>(2){
            {
                put(MyConstants.COURSE_ID_NAME,item.getCourseNumber());
                put(MyConstants.CHAPTER_ID_NAME,item.getCourseSectionNumber());
            }
        }));
        return courseList;
    }


    @Override
    public void courseStudyMethod(String courseid, String chapterid,String userAccount) {
        //参数集合
        Map<String,String> map = MyUtils.setParam(
                MyConstants.USER_ID,
                MyConstants.TOKEN,
                MyConstants.EID,
                MyConstants.VERSION,
                courseid,chapterid);
        //url拼接
        String requestUrl = MyUtils.urlMakeUp(MyConstants.URL_START,map);
        //发起请求
        String returnMsg = MyUtils.requestMoHttp(requestUrl);
        //处理返回值
        this.readMsg(returnMsg,chapterid,userAccount);
    }

    @Override
    public void setStudyFinishSign(String courseID, String message,String needSeconds, String userAccount) {
        try {
            //记录课程学习状态
            HashMap<String, String> map = new HashMap<>();
            map.put("courseID",courseID);
            map.put("message",message);
            map.put("needSeconds",needSeconds);
            map.put("userAccount",userAccount);
            courseMapper.updateByUserAndCourseNumber(map);
        }catch (Exception e){
            logger.error("setStudyFinishSign方法出错",e);
        }
    }

    @Override
    public void startStudy(String userAccount) {
        logger.info("开始学习---本次学习设定的运行时间为"+MyConstants.RUN_TIME+"秒");
        //结束学习时间
        LocalDateTime endTime = LocalDateTime.now().plusSeconds(Long.valueOf(MyConstants.RUN_TIME));
        //标志是否学习完毕
        Boolean isStudyFinish = false;
        do{
            try{
                //获取全部课程组合信息
                List<Map<String, String>> mapList = this.getCourse(userAccount);
                isStudyFinish = mapList.size()>0? false:true;
                //todo 此处可以使用线程，去并行跑每个课程
                //开始学习
                mapList.forEach(map -> {
                    logger.info("---本次学习课程ID："+map.get(MyConstants.COURSE_ID_NAME)+","+map.get(MyConstants.CHAPTER_ID_NAME));
                    this.courseStudyMethod(map.get(MyConstants.COURSE_ID_NAME),
                            map.get(MyConstants.CHAPTER_ID_NAME),userAccount);
                });
                //执行间隔，设置1分钟即可
                Thread.sleep(60000);
            }catch (Exception e){
                logger.error(e.getMessage(),e);
            }
        }while (LocalDateTime.now().isBefore(endTime) || !isStudyFinish);
        logger.info("学习结束---");
        if (isStudyFinish){
            logger.info("课程已经全部学习结束");
        }
    }

    public void readMsg(String returnMsg, String chapterid,String userAccount) {
        try{
            JSONObject jsonObject = (JSONObject)JSONObject.parse(returnMsg);
            if (!jsonObject.containsKey(MyConstants.COMPLETED)){
                String msg = jsonObject.get(MyConstants.RETURN_MSG).toString();
                if (StringUtils.isNotBlank(msg)){
                    logger.info(userAccount+"账户下课程chapterid="+chapterid+MyConstants.STUDY_ERROR+msg);
                    //标记 课程ID 学习失败
                    this.setStudyFinishSign(chapterid,
                            MyConstants.STUDY_ERROR+msg,"0",
                            userAccount);
                }else {
                    logger.info("解析返回值出错啦：未能识别返回MSG,请看输出得返回值是否正确");
                }
            }
            //课程学习是否完成
            String courseCompleted = jsonObject.get(MyConstants.COURSE_COMPLETED).toString();
            //学习这个课程需要得时间  单位秒
            String needTime = jsonObject.get(MyConstants.NEET_TIME).toString();
            //已经学习得时间  单位秒
            String cumtime = jsonObject.get(MyConstants.CUM_TIME).toString();

            if ("Y".equals(courseCompleted) || needTime.equals(cumtime)){
                logger.info("####"+MyConstants.CHAPTER_ID_NAME+"="+jsonObject.get(MyConstants.CHAPTER_ID_NAME).toString()+"的课程已经学习完毕");
                //标记 课程ID 已经学习完成
                this.setStudyFinishSign(jsonObject.get(MyConstants.CHAPTER_ID_NAME).toString(),
                        MyConstants.STUDY_FINISHED,"0",
                        userAccount);
            }else {
                int i = Integer.valueOf(needTime) - Integer.valueOf(cumtime);
                logger.info("####"+MyConstants.CHAPTER_ID_NAME+"="+jsonObject.get(MyConstants.CHAPTER_ID_NAME).toString()+"的课程已学习"+jsonObject.get(MyConstants.VALITD_TIME)+"；还需要学习"+i+"秒");
                //标记 课程ID 还需要多长时间去学习
                this.setStudyFinishSign(jsonObject.get(MyConstants.CHAPTER_ID_NAME).toString(),
                        MyConstants.STUDY_FINISHED,String.valueOf(i),
                        userAccount);
            }
        }catch (Exception e){
            logger.error("解析返回值出错啦："+e.getMessage(),e);
        }
    }

    @Override
    public List<Course> getUserAllCourse(String userAccount) {
        return courseMapper.selectUserAllCourse(userAccount);
    }
}
