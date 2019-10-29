package com.example.testnbalistview.Model;

import android.database.Cursor;

import com.example.testnbalistview.R;

public class PassGames {
    private int vimgResIdPass;
    private int himgResIdPass;
    private int sidPass;
    private String gamedatePass;
    private String vteamPass;
    private String hteamPass;
    private String vscorePass;
    private String hscorePass;
    private String vwinPass;
    private String hwinPass;
    private String vlossPass;
    private String hlossPass;

    public PassGames() {
    }
    public PassGames(int vimgResIdPass, int himgResIdPass, int sidPass, String gamedatePass, String vteamPass, String hteamPass, String vscorePass, String hscorePass, String vwinPass, String hwinPass, String vlossPass, String hlossPass) {
        this.vimgResIdPass = vimgResIdPass;
        this.himgResIdPass = himgResIdPass;
        this.sidPass = sidPass;
        this.gamedatePass = gamedatePass;
        this.vteamPass = vteamPass;
        this.hteamPass = hteamPass;
        this.vscorePass = vscorePass;
        this.hscorePass = hscorePass;
        this.vwinPass = vwinPass;
        this.hwinPass = hwinPass;
        this.vlossPass = vlossPass;
        this.hlossPass = hlossPass;
    }

    public int getVimgResIdPass() {
        return vimgResIdPass;
    }
    public void setVimgResIdPass(int vimgResIdPass) {
        this.vimgResIdPass = vimgResIdPass;
    }
    public int getHimgResIdPass() {
        return himgResIdPass;
    }
    public void setHimgResIdPass(int himgResIdPass) {
        this.himgResIdPass = himgResIdPass;
    }
    public int getSidPass() {
        return sidPass;
    }
    public void setSidPass(int sidPass) {
        this.sidPass = sidPass;
    }
    public String getGamedatePass() {
        return gamedatePass;
    }
    public void setGamedatePass(String gamedatePass) {
        this.gamedatePass = gamedatePass;
    }
    public String getVteamPass() {
        return vteamPass;
    }
    public void setVteamPass(String vteamPass) {
        this.vteamPass = vteamPass;
    }
    public String getHteamPass() {
        return hteamPass;
    }
    public void setHteamPass(String hteamPass) {
        this.hteamPass = hteamPass;
    }
    public String getVscorePass() {
        return vscorePass;
    }
    public void setVscorePass(String vscorePass) {
        this.vscorePass = vscorePass;
    }
    public String getHscorePass() {
        return hscorePass;
    }
    public void setHscorePass(String hscorePass) {
        this.hscorePass = hscorePass;
    }
    public String getVwinPass() {
        return vwinPass;
    }
    public void setVwinPass(String vwinPass) {
        this.vwinPass = vwinPass;
    }
    public String getHwinPass() {
        return hwinPass;
    }
    public void setHwinPass(String hwinPass) {
        this.hwinPass = hwinPass;
    }
    public String getVlossPass() {
        return vlossPass;
    }
    public void setVlossPass(String vlossPass) {
        this.vlossPass = vlossPass;
    }
    public String getHlossPass() {
        return hlossPass;
    }
    public void setHlossPass(String hlossPass) {
        this.hlossPass = hlossPass;
    }
    @Override
    public String toString() {
        return "PassGames{" +
                "vimgResIdPass=" + vimgResIdPass +
                ", himgResIdPass=" + himgResIdPass +
                ", sidPass=" + sidPass +
                ", gamedatePass='" + gamedatePass + '\'' +
                ", vteamPass='" + vteamPass + '\'' +
                ", hteamPass='" + hteamPass + '\'' +
                ", vscorePass='" + vscorePass + '\'' +
                ", hscorePass='" + hscorePass + '\'' +
                ", vwinPass='" + vwinPass + '\'' +
                ", hwinPass='" + hwinPass + '\'' +
                ", vlossPass='" + vlossPass + '\'' +
                ", hlossPass='" + hlossPass + '\'' +
                '}';
    }

    public void fromCursor(Cursor cursor) {
        sidPass = cursor.getInt(cursor.getColumnIndex("sid"));
        gamedatePass = cursor.getString(cursor.getColumnIndex("gamedate"));
        vteamPass = cursor.getString(cursor.getColumnIndex("vteam"));
        hteamPass = cursor.getString(cursor.getColumnIndex("hteam"));
        vscorePass = cursor.getString(cursor.getColumnIndex("vscore"));
        hscorePass = cursor.getString(cursor.getColumnIndex("hscore"));
        vwinPass = cursor.getString(cursor.getColumnIndex("vwin"));
        hwinPass = cursor.getString(cursor.getColumnIndex("hwin"));
        vlossPass = cursor.getString(cursor.getColumnIndex("vloss"));
        hlossPass = cursor.getString(cursor.getColumnIndex("hloss"));
        switch(vteamPass){
            case "TOR":
                vimgResIdPass = R.mipmap.tor;
                break;
            case "GSW":
                vimgResIdPass = R.mipmap.gsw;
                break;
            case "MIL":
                vimgResIdPass = R.mipmap.mil;
                break;
            case "POR":
                vimgResIdPass = R.mipmap.por;
                break;
            case "DEN":
                vimgResIdPass = R.mipmap.den;
                break;
            case "PHI":
                vimgResIdPass = R.mipmap.phi;
                break;
            case "HOU":
                vimgResIdPass = R.mipmap.hou;
                break;
            case "BOS":
                vimgResIdPass = R.mipmap.bos;
                break;
        }
        switch(hteamPass){
            case "TOR":
                himgResIdPass = R.mipmap.tor;
                break;
            case "GSW":
                himgResIdPass = R.mipmap.gsw;
                break;
            case "MIL":
                himgResIdPass = R.mipmap.mil;
                break;
            case "POR":
                himgResIdPass = R.mipmap.por;
                break;
            case "DEN":
                himgResIdPass = R.mipmap.den;
                break;
            case "PHI":
                himgResIdPass = R.mipmap.phi;
                break;
            case "HOU":
                himgResIdPass = R.mipmap.hou;
                break;
            case "BOS":
                himgResIdPass = R.mipmap.bos;
                break;
        }
    }
}
