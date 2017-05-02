package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author phatm
 */
public class Time {

    private String username;
    private String course_id;
    private String branch;
    private String department;
    private String faculty;
    private int day;
    private int month;
    private int year;
    private int study_year;

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

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
     * @return the day
     */
    public int getDay() {
        return day;
    }

    /**
     * @param day the day to set
     */
    public void setDay(int day) {
        this.day = day;
    }

    /**
     * @return the month
     */
    public int getMonth() {
        return month;
    }

    /**
     * @param month the month to set
     */
    public void setMonth(int month) {
        this.month = month;
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

    /**
     * @return the study_year
     */
    public int getStudy_year() {
        return study_year;
    }

    /**
     * @param study_year the study_year to set
     */
    public void setStudy_year(int study_year) {
        this.study_year = study_year;
    }

    public String getFreeTimeStudent(Connection caldtb) {
        String status = "low";
        try {
            Student std = new Student();
            std.setFaculty(this.faculty);
            std.setDepartment(this.department);
            std.setBranch(this.branch);
            std.setYear(this.year);
            List<String> all_s_id = std.getStudentId(caldtb, this.course_id);
            Statement stmt = caldtb.createStatement();
            int count = 0;
            for (int i = 0; i < all_s_id.size(); i++) {
                String sql1 = "select * from manage "
                        + "join appointment "
                        + "on appointment_appointment_id = appointment_id "
                        + "where student_student_id ='" + all_s_id.get(i) + "' and "
                        + "appointment_type = 'class' and appointment_date='" + this.year + "-" + this.month + "-" + this.day + "'";
                ResultSet rs = stmt.executeQuery(sql1);
                while(rs.next()){
                    count++;
                }
                
            }
            if(count>(all_s_id.size()*0.65)){
                status = "high";
            }else if(count>(all_s_id.size()*0.4)){
                status = "mid";
            }
        } catch (SQLException ex) {
            Logger.getLogger(Time.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return status;

    }
    
    public List <String> getFreeTimeTecher(Connection caldtb){
        List <String> status_li = new ArrayList();
        DateFormat df = new SimpleDateFormat("HH");
        for(int i=0; i < 11; i++){
            status_li.add("0");
        }
        try {
            Statement stmt = caldtb.createStatement();
            String sql2="Select * from appointment "
                    + "where teacher_username ='" + this.username + "' and appointment_date='" + this.year + "-" + this.month + "-" + this.day + "'";
            ResultSet rs2 = stmt.executeQuery(sql2);
            while(rs2.next()){
                int start_time = Integer.parseInt(df.format(rs2.getTime("appointment_time")));
                int end_time = Integer.parseInt(df.format(rs2.getTime("appointment_end_time")));
                for(int j=0; j < status_li.size(); j++){
                    if(j+8 >= start_time && j+8 < end_time){
                        status_li.set(j, "1");
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Time.class.getName()).log(Level.SEVERE, null, ex);
        }
        return status_li;
        
    }

}
