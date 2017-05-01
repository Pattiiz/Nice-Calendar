package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
public class Student {

    private String student_id;
    private String password;
    private String fname;
    private String lname;
    private String email;
    private String branch;
    private String department;
    private String faculty;
    private int year;
    private final List<String> student_all = new ArrayList<>();

    /**
     * @return the student_id
     */
    public String getStudent_id() {
        return student_id;
    }

    /**
     * @param student_id the student_id to set
     */
    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the fname
     */
    public String getFname() {
        return fname;
    }

    /**
     * @param fname the fname to set
     */
    public void setFname(String fname) {
        this.fname = fname;
    }

    /**
     * @return the lname
     */
    public String getLname() {
        return lname;
    }

    /**
     * @param lname the lname to set
     */
    public void setLname(String lname) {
        this.lname = lname;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
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

    public List<String> getStudentId(Connection caldtb, String course) {
        student_all.clear();
        try {
            Statement stmt = caldtb.createStatement();
            String sql1 = "select DISTINCT student_id from student join branch "
                    + "on branch_branch_name = branch_name "
                    + "join department "
                    + "on department_department_name = department_name "
                    + "join faculty "
                    + "on faculty_faculty_name = faculty_name "
                    + "join enroll "
                    + "on student_id = student_student_id"
                    + "where ";
            if(!this.department.equals("all")){
                sql1 += "faculty_name='" + this.faculty + "' AND ";
            }
            if(!this.branch.equals("all")){
                sql1 += "branch_name ='" + this.branch + "' AND ";
            }
            if(this.year != 0){
                sql1 += "year_year =" + String.valueOf(this.year) + " AND ";
            }
            if(!course.equals("all")){
                sql1 += "course_course_id = '" + course + "' AND ";
            }
            sql1 += "fname like '%%' order by student_id";
            ResultSet rs = stmt.executeQuery(sql1);
            while(rs.next()){
                student_all.add(rs.getString("student_id"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }
        return student_all;
    }

}
