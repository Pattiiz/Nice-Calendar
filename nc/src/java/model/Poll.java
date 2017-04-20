package model;


import java.util.Date;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author phatm
 */
public class Poll {
    private int appnt_no;
    private String title;
    private String description;
    private Date appnt_open_date;
    private Date appnt_close_date;
    private List<String> choice;

    /**
     * @return the appnt_no
     */
    public int getAppnt_no() {
        return appnt_no;
    }

    /**
     * @param appnt_no the appnt_no to set
     */
    public void setAppnt_no(int appnt_no) {
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
     * @return the appnt_open_date
     */
    public Date getAppnt_open_date() {
        return appnt_open_date;
    }

    /**
     * @param appnt_open_date the appnt_open_date to set
     */
    public void setAppnt_open_date(Date appnt_open_date) {
        this.appnt_open_date = appnt_open_date;
    }

    /**
     * @return the appnt_close_date
     */
    public Date getAppnt_close_date() {
        return appnt_close_date;
    }

    /**
     * @param appnt_close_date the appnt_close_date to set
     */
    public void setAppnt_close_date(Date appnt_close_date) {
        this.appnt_close_date = appnt_close_date;
    }

    /**
     * @return the choice
     */
    public List<String> getChoice() {
        return choice;
    }

    /**
     * @param choice the choice to set
     */
    public void setChoice(List<String> choice) {
        this.choice = choice;
    }
}
