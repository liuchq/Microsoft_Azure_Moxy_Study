package com.liuchq.Moxy.dao;

import com.liuchq.Moxy.bean.Course;
import com.liuchq.Moxy.bean.CourseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseMapper {
    long countByExample(CourseExample example);

    int deleteByExample(CourseExample example);

    int deleteByPrimaryKey(String courseId);

    int insert(Course record);

    int insertSelective(Course record);

    List<Course> selectByExample(CourseExample example);

    Course selectByPrimaryKey(String courseId);

    int updateByExampleSelective(@Param("record") Course record, @Param("example") CourseExample example);

    int updateByExample(@Param("record") Course record, @Param("example") CourseExample example);

    int updateByPrimaryKeySelective(Course record);

    int updateByPrimaryKey(Course record);

    /**
     * 根据用户账户去查找关联的未学习完成的课程
     *
     * @author: liuchq
     * @date: 2021/5/21 17:13
     * @param userAccount
     * @return: java.util.List<com.liuchq.Moxy.bean.Course>
     */
    List<Course> selectNotFinishCourseByUserAccount(String userAccount);
}