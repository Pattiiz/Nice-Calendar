package model;


import java.sql.Time;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author phatm
 */
public class Course {
    private String course_id;
    private String course_name;
    private String location;
    private String branch;
    private String department;
    private String faculty;
    private Date mid_exam_date;
    private Date final_exam_date;
    private Date school_day;
    private Time mid_exam_time;
    private Time final_exam_time;
    private Time study_time;
    private int section;
    private int year;

    /**
     * @return the course_id
     */
    public String getCourse_id() {
        return course_id;
    }

    /**
     * @param course_id the course_id to set
     */
    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

    /**
     * @return the course_name
     */
    public String getCourse_name() {
        return course_name;
    }

    /**
     * @param course_name the course_name to set
     */
    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    /**
     * @return the location
     */
    public String getLocation() {
        return location;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * @return the branch
     */
    public String getBranch() {
        return branch;
    }

    /**
     * @param branch the branch to set
     */
    public void setBranch(String branch) {
        this.branch = branch;
    }

    /**
     * @return the department
     */
    public String getDepartment() {
        return department;
    }

    /**
     * @param department the department to set
     */
    public void setDepartment(String department) {
        this.department = department;
    }

    /**
     * @return the faculty
     */
    public String getFaculty() {
        return faculty;
    }

    /**
     * @param faculty the faculty to set
     */
    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    /**
     * @return the mid_exam_date
     */
    public Date getMid_exam_date() {
        return mid_exam_date;
    }

    /**
     * @param mid_exam_date the mid_exam_date to set
     */
    public void setMid_exam_date(Date mid_exam_date) {
        this.mid_exam_date = mid_exam_date;
    }

    /**
     * @return the final_exam_date
     */
    public Date getFinal_exam_date() {
        return final_exam_date;
    }

    /**
     * @param final_exam_date the final_exam_date to set
     */
    public void setFinal_exam_date(Date final_exam_date) {
        this.final_exam_date = final_exam_date;
    }

    /**
     * @return the school_day
     */
    public Date getSchool_day() {
        return school_day;
    }

    /**
     * @param school_day the school_day to set
     */
    public void setSchool_day(Date school_day) {
        this.school_day = school_day;
    }

    /**
     * @return the mid_exam_time
     */
    public Time getMid_exam_time() {
        return mid_exam_time;
    }

    /**
     * @param mid_exam_time the mid_exam_time to set
     */
    public void setMid_exam_time(Time mid_exam_time) {
        this.mid_exam_time = mid_exam_time;
    }

    /**
     * @return the final_exam_time
     */
    public Time getFinal_exam_time() {
        return final_exam_time;
    }

    /**
     * @param final_exam_time the final_exam_time to set
     */
    public void setFinal_exam_time(Time final_exam_time) {
        this.final_exam_time = final_exam_time;
    }

    /**
     * @return the study_time
     */
    public Time getStudy_time() {
        return study_time;
    }

    /**
     * @param study_time the study_time to set
     */
    public void setStudy_time(Time study_time) {
        this.study_time = study_time;
    }

    /**
     * @return the section
     */
    public int getSection() {
        return section;
    }

    /**
     * @param section the section to set
     */
    public void setSection(int section) {
        this.section = section;
    }

    /**
     * @return the year
     */
    public int getYear() {
        return year;
    }

    /**
     * @param year the year to set
     */
    public void setYear(int year) {
        this.year = year;
    }
}
