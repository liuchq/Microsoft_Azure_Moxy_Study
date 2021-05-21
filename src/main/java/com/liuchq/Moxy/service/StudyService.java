package com.liuchq.Moxy.service;

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
     * @return: java.util.List<java.util.Map < java.lang.String, java.lang.String>> todo
     */
    List<Map<String,String>>getCourse(String userName) throws IOException;


    /**
     * 开始学习的方法 （学习中）
     *
     * @author: liuchq
     * @date: 2021/5/21 15:12
     * @param courseid
     * @param chapterid
     * @return: void todo
     */
    void courseStudyMethod(String courseid,String chapterid,String userAccount);



    /**
     * 记录学习标记 （学习后）
     *
     * @author: liuchq
     * @date: 2021/5/21 15:14
     * @param courseID
     * @param finishSign
     * @param userID
     * @return: void
     */
    void setStudyFinishSign(String courseID, String finishSign,String userID);


    /**
     *
     * @author: liuchq
     * @date: 2021/5/21 16:52
     * @param userAccount
     * @return: void
     */
    void startStudy(String userAccount);

}
