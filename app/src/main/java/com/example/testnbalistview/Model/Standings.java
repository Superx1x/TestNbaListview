package com.example.testnbalistview.Model;

import android.database.Cursor;

import java.util.Arrays;

public class Standings {
    private int sid;
    private String division;
    private String conference;
    private String ranking;
    private String team;
    private String win;
    private String loss;
    private String per;
    private String gb;
    private String conf;
    private String div;
    private String home;
    private String road;
    private String lastten;
    private String streak;
    private byte[] logo;

    public Standings() {
    }
    public Standings(int sid, String division, String conference, String ranking, String team, String win, String loss, String per, String gb, String conf, String div, String home, String road, String lastten, String streak, byte[] logo) {
        this.sid = sid;
        this.division = division;
        this.conference = conference;
        this.ranking = ranking;
        this.team = team;
        this.win = win;
        this.loss = loss;
        this.per = per;
        this.gb = gb;
        this.conf = conf;
        this.div = div;
        this.home = home;
        this.road = road;
        this.lastten = lastten;
        this.streak = streak;
        this.logo = logo;
    }
    public int getSid() {
        return sid;
    }
    public void setSid(int sid) {
        this.sid = sid;
    }
    public String getDivision() {
        return division;
    }
    public void setDivision(String division) {
        this.division = division;
    }
    public String getConference() {
        return conference;
    }
    public void setConference(String conference) {
        this.conference = conference;
    }
    public String getRanking() {
        return ranking;
    }
    public void setRanking(String ranking) {
        this.ranking = ranking;
    }
    public String getTeam() {
        return team;
    }
    public void setTeam(String team) {
        this.team = team;
    }
    public String getWin() {
        return win;
    }
    public void setWin(String win) {
        this.win = win;
    }
    public String getLoss() {
        return loss;
    }
    public void setLoss(String loss) {
        this.loss = loss;
    }
    public String getPer() {
        return per;
    }
    public void setPer(String per) {
        this.per = per;
    }
    public String getGb() {
        return gb;
    }
    public void setGb(String gb) {
        this.gb = gb;
    }
    public String getConf() {
        return conf;
    }
    public void setConf(String conf) {
        this.conf = conf;
    }
    public String getDiv() {
        return div;
    }
    public void setDiv(String div) {
        this.div = div;
    }
    public String getHome() {
        return home;
    }
    public void setHome(String home) {
        this.home = home;
    }
    public String getRoad() {
        return road;
    }
    public void setRoad(String road) {
        this.road = road;
    }
    public String getLastten() {
        return lastten;
    }
    public void setLastten(String lastten) {
        this.lastten = lastten;
    }
    public String getStreak() {
        return streak;
    }
    public void setStreak(String streak) {
        this.streak = streak;
    }
    public byte[] getLogo() {
        return logo;
    }
    public void setLogo(byte[] logo) {
        this.logo = logo;
    }
    @Override
    public String toString() {
        return "Standings{" +
                "sid=" + sid +
                ", division='" + division + '\'' +
                ", conference='" + conference + '\'' +
                ", ranking='" + ranking + '\'' +
                ", team='" + team + '\'' +
                ", win='" + win + '\'' +
                ", loss='" + loss + '\'' +
                ", per='" + per + '\'' +
                ", gb='" + gb + '\'' +
                ", conf='" + conf + '\'' +
                ", div='" + div + '\'' +
                ", home='" + home + '\'' +
                ", road='" + road + '\'' +
                ", lastten='" + lastten + '\'' +
                ", streak='" + streak + '\'' +
                ", logo=" + Arrays.toString(logo) +
                '}';
    }


    public void fromCursor(Cursor cursor) {
        sid = cursor.getInt(cursor.getColumnIndex("sid"));
        division = cursor.getString(cursor.getColumnIndex("division"));
        conference = cursor.getString(cursor.getColumnIndex("conference"));
//        ranking = cursor.getString(cursor.getColumnIndex("ranking"));
        team = cursor.getString(cursor.getColumnIndex("team"));
        win = cursor.getString(cursor.getColumnIndex("win"));
        loss = cursor.getString(cursor.getColumnIndex("loss"));
        per = cursor.getString(cursor.getColumnIndex("per"));
        gb = cursor.getString(cursor.getColumnIndex("gb"));
        conf = cursor.getString(cursor.getColumnIndex("conf"));
        div = cursor.getString(cursor.getColumnIndex("div"));
        home = cursor.getString(cursor.getColumnIndex("home"));
        road = cursor.getString(cursor.getColumnIndex("road"));
        lastten = cursor.getString(cursor.getColumnIndex("lastten"));
        streak = cursor.getString(cursor.getColumnIndex("streak"));
        logo = cursor.getBlob(cursor.getColumnIndex("logo"));
    }
}
