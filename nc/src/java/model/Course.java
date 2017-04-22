package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
public class Course {

    private String course_id;
    private String course_name;
    private String location;
    private String branch;
    private String department;
    private String faculty;
    private Date mid_exam_date;
    private Date final_exam_date;
    private String school_day;
    private String mid_exam_time;
    private String final_exam_time;
    private String study_time;
    private int section;
    private int year;
    private String teacher;
    private final List<Course> cou = new ArrayList<>();
    private final List<Course> s_cou = new ArrayList<>();
    private final List<Course> b_cou = new ArrayList<>();
    private final List<Course> d_cou = new ArrayList<>();

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
    public String getSchool_day() {
        return school_day;
    }

    /**
     * @param school_day the school_day to set
     */
    public void setSchool_day(String school_day) {
        this.school_day = school_day;
    }

    /**
     * @return the mid_exam_time
     */
    public String getMid_exam_time() {
        return mid_exam_time;
    }

    /**
     * @param mid_exam_time the mid_exam_time to set
     */
    public void setMid_exam_time(String mid_exam_time) {
        this.mid_exam_time = mid_exam_time;
    }

    /**
     * @return the final_exam_time
     */
    public String getFinal_exam_time() {
        return final_exam_time;
    }

    /**
     * @param final_exam_time the final_exam_time to set
     */
    public void setFinal_exam_time(String final_exam_time) {
        this.final_exam_time = final_exam_time;
    }

    /**
     * @return the study_time
     */
    public String getStudy_time() {
        return study_time;
    }

    /**
     * @param study_time the study_time to set
     */
    public void setStudy_time(String study_time) {
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

    public List<Course> getSchedule(Connection caldtb) {
        try {
            Statement stmt = caldtb.createStatement();
            String sql1 = "select c.course_id, c.course_name, c.course_term,  s.location, b.branch_name, d.department_name,\n"
                    + "f.faculty_name, s.school_day, c.exam_date, c.exam_time, c.final_exam_date, c.final_exam_time,\n"
                    + "s.study_time, s.study_end_time, s.section_no, cy.year_year, tt.username, tt.fname, tt.lname\n"
                    + "from course c\n"
                    + "join section s\n"
                    + "on c.course_id = s.course_course_id\n"
                    + "join teach t\n"
                    + "on s.section_no = t.section_section_no and s.course_course_id = t.course_course_id\n"
                    + "join teacher tt\n"
                    + "on t.teacher_username = tt.username\n"
                    + "join course_year cy\n"
                    + "on c.course_id = cy.course_course_id\n"
                    + "join course_branch cb\n"
                    + "on c.course_id = cb.course_course_id\n"
                    + "join branch b\n"
                    + "on cb.branch_branch_name = b.branch_name\n"
                    + "join department d\n"
                    + "on b.department_department_name = d.department_name\n"
                    + "join faculty f\n"
                    + "on d.faculty_faculty_name = f.faculty_name\n"
                    + "where ";
            if (this.department.equals("all")) {
                sql1 += "faculty_name='" + this.faculty + "' AND ";
            }
            if (!this.branch.equals("all")) {
                sql1 += "branch_name ='" + this.branch + "' AND ";
            }
            if (this.year != 0) {
                sql1 += "year_year =" + String.valueOf(this.year) + " AND ";
            }
            if (this.course_id != null) {
                sql1 += "course_id = '" + course_id + "' AND ";
            }
            sql1 += "course_name like '%%' order by course_name, section_no";
            ResultSet rs = stmt.executeQuery(sql1);
            DateFormat df = new SimpleDateFormat("HH:mm");
            int sec_check = 0;
            Course cou_buf = new Course();
            List<String> teacher_list = new ArrayList<>();
            while (rs.next()) {
                Course cou2 = new Course();
                cou2.setCourse_id(rs.getString("course_id"));
                cou2.setCourse_name(rs.getString("course_name"));
                cou2.setLocation(rs.getString("location"));
                cou2.setBranch(rs.getString("branch_name"));
                cou2.setDepartment(rs.getString("department_name"));
                cou2.setFaculty(rs.getString("faculty_name"));
                cou2.setMid_exam_date(rs.getDate("exam_date"));
                cou2.setFinal_exam_date(rs.getDate("final_exam_date"));
                cou2.setMid_exam_time(rs.getString("exam_time"));
                cou2.setFinal_exam_time(rs.getString("final_exam_time"));
                cou2.setStudy_time(df.format(rs.getTime("study_time")) + "-" + df.format(rs.getTime("study_end_time")));
                cou2.setSchool_day(rs.getString("school_day"));
                cou2.setSection(Integer.parseInt(rs.getString("section_no")));
                cou2.setYear(Integer.parseInt(rs.getString("year_year")));
                cou2.setTeacher(rs.getString("fname") + " " + rs.getString("lname"));
                if(sec_check != cou2.getSection() || sec_check == 0){
                    String all_t_name = "";
                    for(int i=0; i < teacher_list.size(); i++){
                        all_t_name += "อาจารย์" + teacher_list.get(i) + " ";
                    }
                    cou_buf.setTeacher(all_t_name);
                    cou.add(cou_buf);
                }
                sec_check = cou2.getSection();
                teacher_list.add(cou2.getTeacher());
                cou_buf = cou2;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Course.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cou;
    }

    public List<Course> getNameAllCourse(Connection caldtb) {
        try {
            Statement stmt = caldtb.createStatement();
            String sql1 = "Select course_id, course_name from course";
            ResultSet rs = stmt.executeQuery(sql1);
            while(rs.next()){
                Course cou3 = new Course();
                cou3.setCourse_id(rs.getString("course_id"));
                cou3.setCourse_name(rs.getString("course_name"));
                s_cou.add(cou3);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Course.class.getName()).log(Level.SEVERE, null, ex);
        }
        return s_cou;
    }
    
    public List<Course> getNameAllBranch(Connection caldtb){
        try {
            Statement stmt = caldtb.createStatement();
            String sql1 = "Select branch_name from branch";
            ResultSet rs = stmt.executeQuery(sql1);
            while(rs.next()){
                Course cou4 = new Course();
                cou4.setBranch(rs.getString("branch_name"));
                b_cou.add(cou4);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Course.class.getName()).log(Level.SEVERE, null, ex);
        }
        return b_cou;
    }
    
    public List<Course> getNameAllDepartment(Connection caldtb){
        try {
            Statement stmt = caldtb.createStatement();
            String sql1 = "Select department_name from department";
            ResultSet rs = stmt.executeQuery(sql1);
            while(rs.next()){
                Course cou5 = new Course();
                cou5.setDepartment(rs.getString("department_name"));
                d_cou.add(cou5);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Course.class.getName()).log(Level.SEVERE, null, ex);
        }
        return d_cou;
    }

    /**
     * @return the teacher
     */
    public String getTeacher() {
        return teacher;
    }

    /**
     * @param teacher the teacher to set
     */
    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

}
