package com.liuchq.moxy.bean;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    private String courseId;

    private String courseNumber;

    private String courseSectionNumber;

    private Date courseCreatetime;

    private String courseOwner;

    private String courseNeedSeconds;

    private String courseVersion;

    private String courseMemo;

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId == null ? null : courseId.trim();
    }

    public String getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(String courseNumber) {
        this.courseNumber = courseNumber == null ? null : courseNumber.trim();
    }

    public String getCourseSectionNumber() {
        return courseSectionNumber;
    }

    public void setCourseSectionNumber(String courseSectionNumber) {
        this.courseSectionNumber = courseSectionNumber == null ? null : courseSectionNumber.trim();
    }

    public Date getCourseCreatetime() {
        return courseCreatetime;
    }

    public void setCourseCreatetime(Date courseCreatetime) {
        this.courseCreatetime = courseCreatetime;
    }

    public String getCourseOwner() {
        return courseOwner;
    }

    public void setCourseOwner(String courseOwner) {
        this.courseOwner = courseOwner == null ? null : courseOwner.trim();
    }

    public String getCourseNeedSeconds() {
        return courseNeedSeconds;
    }

    public void setCourseNeedSeconds(String courseNeedSeconds) {
        this.courseNeedSeconds = courseNeedSeconds == null ? null : courseNeedSeconds.trim();
    }

    public String getCourseVersion() {
        return courseVersion;
    }

    public void setCourseVersion(String courseVersion) {
        this.courseVersion = courseVersion == null ? null : courseVersion.trim();
    }

    public String getCourseMemo(){
        return courseMemo;
    }

    public void setCourseMemo(String courseMemo){
        this.courseMemo = courseMemo == null ? null : courseMemo.trim();
    }
}