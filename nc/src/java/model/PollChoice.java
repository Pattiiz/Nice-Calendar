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
public class PollChoice {
    private int choice_no;
    private int result;
    private Date start_date;
    private Date end_date;
    private Time start_time;
    private Time end_time;

    /**
     * @return the choice_no
     */
    public int getChoice_no() {
        return choice_no;
    }

    /**
     * @param choice_no the choice_no to set
     */
    public void setChoice_no(int choice_no) {
        this.choice_no = choice_no;
    }

    /**
     * @return the result
     */
    public int getResult() {
        return result;
    }

    /**
     * @param result the result to set
     */
    public void setResult(int result) {
        this.result = result;
    }

    /**
     * @return the start_date
     */
    public Date getStart_date() {
        return start_date;
    }

    /**
     * @param start_date the start_date to set
     */
    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    /**
     * @return the end_date
     */
    public Date getEnd_date() {
        return end_date;
    }

    /**
     * @param end_date the end_date to set
     */
    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    /**
     * @return the start_time
     */
    public Time getStart_time() {
        return start_time;
    }

    /**
     * @param start_time the start_time to set
     */
    public void setStart_time(Time start_time) {
        this.start_time = start_time;
    }

    /**
     * @return the end_time
     */
    public Time getEnd_time() {
        return end_time;
    }

    /**
     * @param end_time the end_time to set
     */
    public void setEnd_time(Time end_time) {
        this.end_time = end_time;
    }
}
