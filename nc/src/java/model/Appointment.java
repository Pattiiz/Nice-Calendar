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
public class Appointment {
    private String appnt_no;
    private String title;
    private String description;
    private Date appnt_start_date;
    private Date appnt_end_date;
    private Time appnt_start_time;
    private Time appnt_end_time;
    private String appnt_type;
    private String appnt_owner;

    /**
     * @return the appnt_no
     */
    public String getAppnt_no() {
        return appnt_no;
    }

    /**
     * @param appnt_no the appnt_no to set
     */
    public void setAppnt_no(String appnt_no) {
        this.appnt_no = appnt_no;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the appnt_start_date
     */
    public Date getAppnt_start_date() {
        return appnt_start_date;
    }

    /**
     * @param appnt_start_date the appnt_start_date to set
     */
    public void setAppnt_start_date(Date appnt_start_date) {
        this.appnt_start_date = appnt_start_date;
    }

    /**
     * @return the appnt_end_date
     */
    public Date getAppnt_end_date() {
        return appnt_end_date;
    }

    /**
     * @param appnt_end_date the appnt_end_date to set
     */
    public void setAppnt_end_date(Date appnt_end_date) {
        this.appnt_end_date = appnt_end_date;
    }

    /**
     * @return the appnt_start_time
     */
    public Time getAppnt_start_time() {
        return appnt_start_time;
    }

    /**
     * @param appnt_start_time the appnt_start_time to set
     */
    public void setAppnt_start_time(Time appnt_start_time) {
        this.appnt_start_time = appnt_start_time;
    }

    /**
     * @return the appnt_end_time
     */
    public Time getAppnt_end_time() {
        return appnt_end_time;
    }

    /**
     * @param appnt_end_time the appnt_end_time to set
     */
    public void setAppnt_end_time(Time appnt_end_time) {
        this.appnt_end_time = appnt_end_time;
    }

    /**
     * @return the appnt_type
     */
    public String getAppnt_type() {
        return appnt_type;
    }

    /**
     * @param appnt_type the appnt_type to set
     */
    public void setAppnt_type(String appnt_type) {
        this.appnt_type = appnt_type;
    }

    /**
     * @return the appnt_owner
     */
    public String getAppnt_owner() {
        return appnt_owner;
    }

    /**
     * @param appnt_owner the appnt_owner to set
     */
    public void setAppnt_owner(String appnt_owner) {
        this.appnt_owner = appnt_owner;
    }
}
