package com.liuchq.Moxy.constant;

/**
 * @author: liuchq
 * @date: 2021/5/21 15:29
 * @description: 静态变量
 */
public class MyConstants {
    /**
     *登陆人ID
     */
    public static final String USER_ID = "806224b4_b6b6_890e_4363_9c1639140f05";

    /**
     *token
     */
    public static final String TOKEN = "e420249d6430cf4ee268e15779c764ee";

    /**
     *EID
     */
    public static final String EID = "22906";

    /**
     *VERSION  版本
     */
    public static final String VERSION = "3.7.1.1";


    /**
     *设定程序运行时间  单位 秒  （一般可以设置你学习的课程中，时间最长的那个）
     */
    public static final int RUN_TIME = 10;


    //=================start======解析课程用到的静态变量====================================
    /**
     * 公共得URL
     */
    public static final String URL_START = "https://api.moxueyuan.com/appapi.php/index?r=apiCourse/setCourseCompleted&test=pc";

    /**
     * 课程ID  key（键）
     */
    public static final String COURSE_ID_NAME = "courseid";
    public static final String CHAPTER_ID_NAME = "chapterid";

    /**
     * 学习完毕标识
     */
    public static final String STUDY_FINISHED = "本次请求学习完毕";

    /**
     * 学习出错标识
     */
    public static final String STUDY_ERROR = "学习出错";


    /**
     * 判断返回参数合法的随便选的一个字段
     */
    public static final String COMPLETED = "completed";

    /**
     * 请求状态
     */
    public static final String REQUEST_STATUS = "status";

    /**
     * 返回值
     */
    public static final String RETURN_MSG = "msg";

    /**
     * 课程是否学习完成
     */
    public static final String COURSE_COMPLETED = "courseCompleted";

    /**
     * 学习课程需要得时间  单位 秒   例如 20
     */
    public static final String NEET_TIME = "needTime";

    /**
     * 课程已经学过得时间  单位 秒   例如  20
     */
    public static final String CUM_TIME = "cumtime";

    /**
     * 已经学过得时间   单位  分秒   例如  1分21秒
     */
    public static final String VALITD_TIME = "validtime";

    //==================end=======解析课程用到的静态变量====================================
}
