package com.liuchq.moxy.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.liuchq.moxy.bean.Course;
import com.liuchq.moxy.service.SettingService;
import com.liuchq.moxy.service.StudyService;
import com.liuchq.moxy.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @program: Microsoft_Azure_Moxy_Study
 * @description: 控制层
 * @author: liuchq
 * @create: 2021-05-16
 **/
@RequestMapping(value = "/user")
@Controller
public class MyController {

    public static final Logger logger = LogManager.getLogger("MyController");

    @Autowired
    private UserService userService;
    @Autowired
    private SettingService settingService;
    @Autowired
    private StudyService studyService;

    @RequestMapping(value = "/userLogin.do",method = RequestMethod.POST)
    public ModelAndView userLogin(String userAccount, String userPsw, HttpServletRequest request){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("loginError");
        String log = "用户:"+userAccount+"登录，且登录失败";
        try {
            boolean login = userService.userLogin(userAccount, userPsw);
            if (login){
                mav.setViewName("courseDetail");
                request.getSession().setAttribute("userAccount",userAccount);
                log = log.replace("失败","成功");
            }
        }catch (Exception e){
            e.printStackTrace();
            logger.error(e.getMessage(),e);
        }
        logger.info(log);
        return mav;
    }

    @RequestMapping(value = "/studyDemo.do",method = RequestMethod.POST,produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String studyDemo(HttpSession session) {
        //登录的用户
        Object userAccount = session.getAttribute("userAccount");
        studyService.startStudy(String.valueOf(userAccount));
        return "后台已经开始刷课";
    }

    @RequestMapping(value = "/loginOut.do",method = RequestMethod.POST,produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String loginOut(HttpServletRequest request) {
        //注销登录
        HttpSession session = request.getSession();
        Object userAccount = session.getAttribute("userAccount");
        logger.info(userAccount + "注销操作;");
        session.setAttribute("userAccount","");
        return "success";
    }

    @RequestMapping(value = "/test2.do",method = RequestMethod.GET,produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String test2(HttpSession session) {
        //test2
        logger.info("请求 test2方法");
        return "test2";
    }

    @RequestMapping(value = "/test3.do",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
    @ResponseBody
    public String test3(HttpServletRequest request) throws Exception{
        //休眠1.5秒模拟网络环境慢
        Thread.sleep(1500);
        String value = request.getParameter("q");
        logger.info("请求 test3方法,接收到的参数值为："+value);
        JSONArray jsonArray = new JSONArray();
        for (int i = 0; i < 6; i++) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("img_url","https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=2823686447,1646334873&fm=26&gp=0.jpg");
            jsonObject.put("login_name","test"+i*111);
            jsonObject.put("login_url","https://www.baidu.com/");
            jsonObject.put("img_id",i);
            jsonArray.add(jsonObject);
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("item",jsonArray);
        jsonObject.put("memo","测试axios的请求");
        return jsonObject.toString();
    }

    @RequestMapping(value = "/getUserAllCourse.do",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
    @ResponseBody
    public List<Course> getUserAllCourse(HttpServletRequest request){
        Object userAccount = request.getSession().getAttribute("userAccount");
        List<Course> courses = studyService.getUserAllCourse(userAccount.toString());
        return courses;
    }


    @RequestMapping(value = "/uploadCourse.do",method = RequestMethod.POST,produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String uploadCourse(HttpServletRequest request) {
        String reMsg = "成功";
        logger.info("上传文件操作");
        List<String> stringList = new ArrayList<>();

        MultipartResolver resolver = new CommonsMultipartResolver(request.getSession().getServletContext());
        MultipartHttpServletRequest multipartRequest = resolver.resolveMultipart(request);
        Map<String, MultipartFile> files = multipartRequest.getFileMap();
        MultipartFile file = files.get("file");
        Reader reader = null;
        try {
            reader = new InputStreamReader(file.getInputStream(),"utf-8");
            BufferedReader bufferedReader = new BufferedReader(reader);
            String len = bufferedReader.readLine();
            while (len != null && StringUtils.isNotBlank(len)){
                String finalLen = len.trim();
                len = bufferedReader.readLine();
                stringList.add(finalLen);
            }
        } catch (IOException e) {
            logger.info("读取文件出错:"+e.getMessage(),e);
            reMsg = "读取文件出错:"+e.getMessage();
            e.printStackTrace();
        }

        //对课程内容处理,以及写入数据库
        String userAccount = String.valueOf(request.getSession().getAttribute("userAccount"));
        studyService.insertCourseForString(stringList,userAccount);

        return reMsg;
    }

}
