package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import servlet.AppointmentServlet;

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

    private String appnt_no;
    private String title;
    private String description;
    private String appnt_open_date;
    private String appnt_close_date;
    private List<String> choice;

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
     * @return the appnt_open_date
     */
    public String getAppnt_open_date() {
        return appnt_open_date;
    }

    /**
     * @param appnt_open_date the appnt_open_date to set
     */
    public void setAppnt_open_date(String appnt_open_date) {
        this.appnt_open_date = appnt_open_date;
    }

    /**
     * @return the appnt_close_date
     */
    public String getAppnt_close_date() {
        return appnt_close_date;
    }

    /**
     * @param appnt_close_date the appnt_close_date to set
     */
    public void setAppnt_close_date(String appnt_close_date) {
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

    public void openVote(Connection caldtb, String user_id, List<String> all_student) {
        int last_id = 0;
        int last_choice = 0;
        try {
            Statement stmt = caldtb.createStatement();
            stmt = caldtb.createStatement();
            String sql = "SELECT poll_id from poll order by poll_id *1 DESC limit 1";
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                last_id = Integer.parseInt(rs.getString("poll_id")) + 1;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AppointmentServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Statement stmt = caldtb.createStatement();
            String sql1 = "INSERT INTO poll (poll_id, poll_title, description, open_vote, close_vote) VALUES ('"
                    + last_id + "', '" + this.title + "', '" + this.description + "', '"
                    + this.appnt_open_date + "', '" + this.appnt_close_date + "')";
            int numrow1 = stmt.executeUpdate(sql1);
            String sql2 = "INSERT INTO teacher_poll (poll_poll_id, teacher_username) VALUES ('"
                    + last_id + "', '" + user_id + "')";
            int numrow2 = stmt.executeUpdate(sql2);
            System.out.println(all_student.size());
            for (int i = 0; i < all_student.size(); i++) {
                String sql5s = "INSERT INTO student_poll (student_student_id, poll_poll_id)\n"
                        + "VALUES ('" + all_student.get(i) + "', '" + last_id + "')";
                int numrow5s = stmt.executeUpdate(sql5s);
            }
            for (int i = 0; i < this.choice.size(); i++) {
                String sql3 = "SELECT choice_id from poll_choice order by choice_id *1 DESC limit 1";
                ResultSet rs = stmt.executeQuery(sql3);
                if (rs.next()) {
                    last_choice = rs.getInt("choice_id");
                    last_choice++;
                }
                String sql4 = "INSERT INTO poll_choice (choice_id, point, poll_poll_id, choice_detail) VALUES ("
                        + last_choice + ", 0, '" + last_id + "', '" + this.choice.get(i) + "')";
                int numrow = stmt.executeUpdate(sql4);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Poll.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Poll> getPollStudent(Connection caldtb, String user_id) {
        List<Poll> all_poll = new ArrayList();
        
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        try {
            Statement stmt = caldtb.createStatement();
            String sql5 = "SELECT * from student_poll "
                    + "join poll on poll_poll_id = poll_id"
                    + " where student_student_id ='" + user_id + "'";
            ResultSet rs5 = stmt.executeQuery(sql5);
            while (rs5.next()) {
                Poll sub_poll = new Poll();
                sub_poll.setAppnt_no(rs5.getString("poll_id"));
                sub_poll.setTitle(rs5.getString("poll_title"));
                sub_poll.setDescription(rs5.getString("description"));
                sub_poll.setAppnt_open_date(df.format(rs5.getDate("open_vote")));
                sub_poll.setAppnt_close_date(df.format(rs5.getDate("close_vote")));
                all_poll.add(sub_poll);
            }
            for(int i=0; i<all_poll.size(); i++){
                List<String> all_choice = new ArrayList();
                String sql6 = "SELECT * from poll"
                        + " join poll_choice on poll_poll_id = poll_id"
                        + " where poll_id='" + all_poll.get(i).getAppnt_no() + "' order by choice_id";
                ResultSet rs6 = stmt.executeQuery(sql6);
                while (rs6.next()) {
                    all_choice.add(rs6.getString("choice_detail"));
                }
                all_poll.get(i).setChoice(all_choice);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Poll.class.getName()).log(Level.SEVERE, null, ex);
        }
        return all_poll;

    }

    public List<Poll> getPollTeacher(Connection caldtb, String user_id) {
        List<Poll> all_poll = new ArrayList();
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        
        try {
            Statement stmt = caldtb.createStatement();
            String sql7 = "SELECT * from teacher_poll "
                    + "join poll on poll_poll_id = poll_id"
                    + " where teacher_username ='" + user_id + "'";
            ResultSet rs7 = stmt.executeQuery(sql7);
            while (rs7.next()) {
                Poll sub_poll = new Poll();
                sub_poll.setAppnt_no(rs7.getString("poll_id"));
                sub_poll.setTitle(rs7.getString("poll_title"));
                sub_poll.setDescription(rs7.getString("description"));
                sub_poll.setAppnt_open_date(df.format(rs7.getDate("open_vote")));
                sub_poll.setAppnt_close_date(df.format(rs7.getDate("close_vote")));
                all_poll.add(sub_poll);
            }
            for(int i=0; i<all_poll.size(); i++){

                List<String> all_choice = new ArrayList();
                String sql8 = "SELECT * from poll"
                        + " join poll_choice on poll_poll_id = poll_id"
                        + " where poll_id='" + all_poll.get(i).getAppnt_no() + "' order by choice_id";
                ResultSet rs8 = stmt.executeQuery(sql8);
                while (rs8.next()) {
                    all_choice.add(rs8.getString("choice_detail") + " || SCORE: " + rs8.getString("point"));
                }
                all_poll.get(i).setChoice(all_choice);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Poll.class.getName()).log(Level.SEVERE, null, ex);
        }
        return all_poll;
    }
    public void votePoll(Connection caldtb, String user_id, String id, String choice){
        try {
            List<String> all_choice = new ArrayList();
            int last_point = 0;
            Statement stmt = caldtb.createStatement();
            String sql1 = "SELECT * from poll"
                    + " join poll_choice on poll_poll_id = poll_id"
                    + " where poll_id ='" + id + "' order by choice_id";
            ResultSet rs = stmt.executeQuery(sql1);
            while(rs.next()){
                all_choice.add(String.valueOf(rs.getInt("choice_id")));
            }
            String sql2 = "Select * from poll_choice"
                    + " where choice_id=" + all_choice.get(Integer.parseInt(choice));
            ResultSet rs2 = stmt.executeQuery(sql2);
            if(rs2.next()){
                last_point = rs2.getInt("point");
            }
            last_point ++;
            String sql3 = "UPDATE poll_choice SET point =" + last_point + " where choice_id=" + all_choice.get(Integer.parseInt(choice));
            int numrow = stmt.executeUpdate(sql3);

        } catch (SQLException ex) {
            Logger.getLogger(Poll.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
