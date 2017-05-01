package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author phatm
 */
public class Calendarmodel {

    private int day;
    private int month;
    private int year;
    private final List<Appointment> app = new ArrayList<>();
    private final List<String> calendar = new ArrayList<>();
    Connection caldtb;
    private String debug;

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
     * @param caldtb
     * @return the appointment
     */
    public List<Appointment> getAppointment(Connection caldtb, String person_who, String user) {
        app.clear();
        this.caldtb = caldtb;
        if (person_who.equals("student")) {
            try {
                Statement stmt = caldtb.createStatement();
                String sql = "SELECT appointment_id, appointment_title, description, appointment_date, appointment_end_date, appointment_time, appointment_end_time, appointment_type, teacher_username, officer_username, fname, lname from manage "
                        + "join appointment on appointment_id = appointment_appointment_id "
                        + "left outer join teacher on teacher_username = username "
                        + "where (appointment_date = '" + year + "-" + month + "-" + day + "' "
                        + "or appointment_end_date ='" + year + "-" + month + "-" + day + "' ) and student_student_id ='" + user + "'"
                        + "union all "
                        + "SELECT  appointment_id, appointment_title, description, appointment_date, appointment_end_date, appointment_time, appointment_end_time, appointment_type, teacher_username, officer_username, Null as fname, Null as lname "
                        + "from appointment where appointment_type = 'university'"
                        + " and (appointment_date = '" + year + "-" + month + "-" + day + "' "
                        + "or appointment_end_date ='" + year + "-" + month + "-" + day + "')";

                ResultSet rs = stmt.executeQuery(sql);

                while (rs.next()) {
                    Appointment ap = new Appointment();
                    ap.setAppnt_no(rs.getString("appointment_id"));
                    ap.setTitle(rs.getString("appointment_title"));
                    ap.setDescription(rs.getString("description"));
                    ap.setAppnt_start_date(rs.getDate("appointment_date"));
                    ap.setAppnt_end_date(rs.getDate("appointment_end_date"));
                    ap.setAppnt_start_time(rs.getTime("appointment_time"));
                    ap.setAppnt_end_time(rs.getTime("appointment_end_time"));
                    ap.setAppnt_type(rs.getString("appointment_type"));
                    ap.setAppnt_owner(rs.getString("fname")+" "+rs.getString("lname"));
                    app.add(ap);
                }
            } catch (SQLException ex) {
                Logger.getLogger(Calendarmodel.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (person_who.equals("teacher")) {
            try {
                Statement stmt = caldtb.createStatement();
                String sql2 = "SELECT * from appointment "
                        + "join teacher on teacher_username = username "
                        + "where (appointment_date = '" + year + "-" + month + "-" + day + "' "
                        + "or appointment_end_date ='" + year + "-" + month + "-" + day + "' )and teacher_username ='" + user + "'";
                ResultSet rs = stmt.executeQuery(sql2);
                while (rs.next()) {
                    Appointment ap = new Appointment();
                    ap.setAppnt_no(rs.getString("appointment_id"));
                    ap.setTitle(rs.getString("appointment_title"));
                    ap.setDescription(rs.getString("description"));
                    ap.setAppnt_start_date(rs.getDate("appointment_date"));
                    ap.setAppnt_end_date(rs.getDate("appointment_end_date"));
                    ap.setAppnt_start_time(rs.getTime("appointment_time"));
                    ap.setAppnt_end_time(rs.getTime("appointment_end_time"));
                    ap.setAppnt_type(rs.getString("appointment_type"));
                    ap.setAppnt_owner(rs.getString("fname")+" "+rs.getString("lname"));
                    app.add(ap);
                }
            } catch (SQLException ex) {
                Logger.getLogger(Calendarmodel.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (person_who.equals("staff")) {
            try {
                Statement stmt = caldtb.createStatement();
                String sql3 = "SELECT * from appointment "
                        + "join officer on officer_username = username "
                        + "where appointment_date = '" + year + "-" + month + "-" + day + "' "
                        + "or appointment_end_date ='" + year + "-" + month + "-" + day + "' and officer_username ='" + user + "'";
                ResultSet rs = stmt.executeQuery(sql3);
                while (rs.next()) {
                    Appointment ap = new Appointment();
                    ap.setAppnt_no(rs.getString("appointment_id"));
                    ap.setTitle(rs.getString("appointment_title"));
                    ap.setDescription(rs.getString("description"));
                    ap.setAppnt_start_date(rs.getDate("appointment_date"));
                    ap.setAppnt_end_date(rs.getDate("appointment_end_date"));
                    ap.setAppnt_start_time(rs.getTime("appointment_time"));
                    ap.setAppnt_end_time(rs.getTime("appointment_end_time"));
                    ap.setAppnt_type(rs.getString("appointment_type"));
                    ap.setAppnt_owner(rs.getString("fname")+" "+rs.getString("lname"));
                    app.add(ap);
                }
            } catch (SQLException ex) {
                Logger.getLogger(Calendarmodel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return app;
    }

    public List<String> getMonthcalendar() {
        int leapyear_flag = 0;
        int prev_month_flag = 0;
        int this_month_flag = 0;
        List<Integer> odd_month = Arrays.asList(1, 3, 5, 7, 8, 10, 12);
        List<Integer> even_month = Arrays.asList(4, 6, 9, 11);
        int cal_month = this.month;
        int cal_year = this.year;
        int start_day = 0;
        calendar.clear();
        /* check this year leapyear or not */
        if (this.year % 4 == 0) {
            leapyear_flag = 1;
            if (this.year % 100 == 0) {
                leapyear_flag = 0;
                if (this.year % 400 == 0) {
                    leapyear_flag = 1;
                }
            }
        }
        /* check prev and now month how many day in the month */
        if (odd_month.contains(this.month)) {
            this_month_flag = 31;
        } else if (even_month.contains(this.month)) {
            this_month_flag = 30;
        } else {
            if (leapyear_flag == 0) {
                this_month_flag = 28;
            } else {
                this_month_flag = 29;
            }
        }
        if (odd_month.contains((this.month) - 1)) {
            prev_month_flag = 31;
        } else if (even_month.contains((this.month) - 1)) {
            prev_month_flag = 30;
        } else {
            if (leapyear_flag == 0) {
                prev_month_flag = 28;
            } else {
                prev_month_flag = 29;
            }
        }
        if (this.month == 1) {
            prev_month_flag = 31;
        }
        /* change some month to properly for calculate*/
        if (cal_month == 1) {
            cal_month = 13;
            cal_year -= 1;
        }
        if (cal_month == 2) {
            cal_month = 14;
            cal_year -= 1;
        }
        /* calculate what the days in the week*/
        start_day = (1 + (2 * cal_month) + ((3 * (cal_month + 1)) / 5) + cal_year + (cal_year / 4)
                - (cal_year / 100) + (cal_year / 400) + 2) % 7;
        if (start_day == 0 || start_day == 1) {
            start_day += 6;
        } else {
            start_day -= 1;
        }
        /* Create all date list in calendar */
        if (start_day - 1 != 0) {
            for (int i = (prev_month_flag - (start_day - 1)) + 1; i <= prev_month_flag; i++) {
                calendar.add(String.valueOf(i));
            }
        }
        for (int i = 1; i <= this_month_flag; i++) {
            calendar.add(String.valueOf(i));
        }
        for (int i = 1; i <= 42 - ((start_day - 1) + this_month_flag); i++) {
            calendar.add(String.valueOf(i));
        }
        return calendar;
    }

    /**
     * @return the debug
     */
    public String getDebug() {
        return debug;
    }

}
