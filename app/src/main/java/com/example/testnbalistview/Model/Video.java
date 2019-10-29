package com.example.testnbalistview.Model;

import android.database.Cursor;

import java.util.Arrays;

public class Video {
    private int sid;
    private String teamSim;
    private String teamCom;
    private String name;
    private String title;
    private String youtubeHttp;
    private String favourite;
    private byte[] videoPhoto;

    public Video() {
    }
    public Video(int sid, String teamSim, String teamCom, String name, String title, String youtubeHttp, String favourite, byte[] videoPhoto) {
        this.sid = sid;
        this.teamSim = teamSim;
        this.teamCom = teamCom;
        this.name = name;
        this.title = title;
        this.youtubeHttp = youtubeHttp;
        this.favourite = favourite;
        this.videoPhoto = videoPhoto;
    }
    public int getSid() {
        return sid;
    }
    public void setSid(int sid) {
        this.sid = sid;
    }
    public String getTeamSim() {
        return teamSim;
    }
    public void setTeamSim(String teamSim) {
        this.teamSim = teamSim;
    }
    public String getTeamCom() {
        return teamCom;
    }
    public void setTeamCom(String teamCom) {
        this.teamCom = teamCom;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getYoutubeHttp() {
        return youtubeHttp;
    }
    public void setYoutubeHttp(String youtubeHttp) {
        this.youtubeHttp = youtubeHttp;
    }
    public String getFavourite() {
        return favourite;
    }
    public void setFavourite(String favourite) {
        this.favourite = favourite;
    }
    public byte[] getVideoPhoto() {
        return videoPhoto;
    }
    public void setVideoPhoto(byte[] videoPhoto) {
        this.videoPhoto = videoPhoto;
    }
    @Override
    public String toString() {
        return "Video{" +
                "sid=" + sid +
                ", teamSim='" + teamSim + '\'' +
                ", teamCom='" + teamCom + '\'' +
                ", name='" + name + '\'' +
                ", title='" + title + '\'' +
                ", youtubeHttp='" + youtubeHttp + '\'' +
                ", favourite='" + favourite + '\'' +
                ", videoPhoto=" + Arrays.toString(videoPhoto) +
                '}';
    }

    public void fromCursor(Cursor cursor) {
        sid = cursor.getInt(cursor.getColumnIndex("sid"));
        teamSim = cursor.getString(cursor.getColumnIndex("teamsim"));
        teamCom = cursor.getString(cursor.getColumnIndex("teamcom"));
        name = cursor.getString(cursor.getColumnIndex("name"));
        title = cursor.getString(cursor.getColumnIndex("title"));
        youtubeHttp = cursor.getString(cursor.getColumnIndex("youtubehttp"));
        favourite = cursor.getString(cursor.getColumnIndex("favourite"));
        videoPhoto = cursor.getBlob(cursor.getColumnIndex("vodiophoto"));//欄位名稱有錯
    }
}
