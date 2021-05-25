package com.liuchq.Moxy.service;

import com.liuchq.Moxy.bean.Course;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author: liuchq
 * @date: 2021/5/21 15:09
 * @description: 学习
 */
public interface StudyService {

    /**
     * 从后台获取某个人的课程ID（学习前）
     *
     * @author: liuchq
     * @date: 2021/5/21 15:11
     * @param
     * @return: java.util.List<java.util.Map < java.lang.String, java.lang.String>>
     */
    List<Map<String,String>>getCourse(String userName) throws IOException;


    /**
     * 开始学习的方法 （学习中）
     *
     * @author: liuchq
     * @date: 2021/5/21 15:12
     * @param courseid
     * @param chapterid
     * @return: void
     */
    void courseStudyMethod(String courseid,String chapterid,String userAccount);


    /**
     * 记录学习标记 （学习后）
     * @author: liuchq
     * @date: 2021/5/21 15:14
     * @param courseID
     * @param message
     * @param needSeconds
     * @param userAccount
     * @return: void
     */
    void setStudyFinishSign(String courseID, String message,String needSeconds, String userAccount);


    /**
     *
     * @author: liuchq
     * @date: 2021/5/21 16:52
     * @param userAccount
     * @return: void
     */
    void startStudy(String userAccount);


    /**
     * 根据账户获取所有的要学习的课程
     *
     * @author: liuchq
     * @date: 2021/5/25 16:07
     * @param userAccount
     * @return: java.util.List<com.liuchq.Moxy.bean.Course>
     */
    List<Course> getUserAllCourse(String userAccount);

}
