package com.example.testnbalistview.Model;

import android.database.Cursor;

import java.util.Arrays;

public class Nbanews {
    private int sid;
    private String reportTime;
    private String lttitle;
    private String lbtitle;
    private String rttitle;
    private String rbtitle;
    private byte[] ltphoto;
    private byte[] lbphoto;
    private byte[] rtphoto;
    private byte[] rbphoto;
    private String lthttp;
    private String lbhttp;
    private String rthttp;
    private String rbhttp;

    public Nbanews() {
    }

    public Nbanews(int sid, String reportTime, String lttitle, String lbtitle, String rttitle, String rbtitle, byte[] ltphoto, byte[] lbphoto, byte[] rtphoto, byte[] rbphoto, String lthttp, String lbhttp, String rthttp, String rbhttp) {
        this.sid = sid;
        this.reportTime = reportTime;
        this.lttitle = lttitle;
        this.lbtitle = lbtitle;
        this.rttitle = rttitle;
        this.rbtitle = rbtitle;
        this.ltphoto = ltphoto;
        this.lbphoto = lbphoto;
        this.rtphoto = rtphoto;
        this.rbphoto = rbphoto;
        this.lthttp = lthttp;
        this.lbhttp = lbhttp;
        this.rthttp = rthttp;
        this.rbhttp = rbhttp;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getReportTime() {
        return reportTime;
    }

    public void setReportTime(String reportTime) {
        this.reportTime = reportTime;
    }

    public String getLttitle() {
        return lttitle;
    }

    public void setLttitle(String lttitle) {
        this.lttitle = lttitle;
    }

    public String getLbtitle() {
        return lbtitle;
    }

    public void setLbtitle(String lbtitle) {
        this.lbtitle = lbtitle;
    }

    public String getRttitle() {
        return rttitle;
    }

    public void setRttitle(String rttitle) {
        this.rttitle = rttitle;
    }

    public String getRbtitle() {
        return rbtitle;
    }

    public void setRbtitle(String rbtitle) {
        this.rbtitle = rbtitle;
    }

    public byte[] getLtphoto() {
        return ltphoto;
    }

    public void setLtphoto(byte[] ltphoto) {
        this.ltphoto = ltphoto;
    }

    public byte[] getLbphoto() {
        return lbphoto;
    }

    public void setLbphoto(byte[] lbphoto) {
        this.lbphoto = lbphoto;
    }

    public byte[] getRtphoto() {
        return rtphoto;
    }

    public void setRtphoto(byte[] rtphoto) {
        this.rtphoto = rtphoto;
    }

    public byte[] getRbphoto() {
        return rbphoto;
    }

    public void setRbphoto(byte[] rbphoto) {
        this.rbphoto = rbphoto;
    }

    public String getLthttp() {
        return lthttp;
    }

    public void setLthttp(String lthttp) {
        this.lthttp = lthttp;
    }

    public String getLbhttp() {
        return lbhttp;
    }

    public void setLbhttp(String lbhttp) {
        this.lbhttp = lbhttp;
    }

    public String getRthttp() {
        return rthttp;
    }

    public void setRthttp(String rthttp) {
        this.rthttp = rthttp;
    }

    public String getRbhttp() {
        return rbhttp;
    }

    public void setRbhttp(String rbhttp) {
        this.rbhttp = rbhttp;
    }

    @Override
    public String toString() {
        return "Nbanews{" +
                "sid=" + sid +
                ", reportTime='" + reportTime + '\'' +
                ", lttitle='" + lttitle + '\'' +
                ", lbtitle='" + lbtitle + '\'' +
                ", rttitle='" + rttitle + '\'' +
                ", rbtitle='" + rbtitle + '\'' +
                ", ltphoto=" + Arrays.toString(ltphoto) +
                ", lbphoto=" + Arrays.toString(lbphoto) +
                ", rtphoto=" + Arrays.toString(rtphoto) +
                ", rbphoto=" + Arrays.toString(rbphoto) +
                ", lthttp='" + lthttp + '\'' +
                ", lbhttp='" + lbhttp + '\'' +
                ", rthttp='" + rthttp + '\'' +
                ", rbhttp='" + rbhttp + '\'' +
                '}';
    }


    public void fromCursor(Cursor cursor) {
        sid = cursor.getInt(cursor.getColumnIndex("sid"));
        reportTime = cursor.getString(cursor.getColumnIndex("dreporttime"));
        lttitle = cursor.getString(cursor.getColumnIndex("ltdtitle"));
        lbtitle = cursor.getString(cursor.getColumnIndex("lbdtitle"));
        rttitle = cursor.getString(cursor.getColumnIndex("rtdtitle"));
        rbtitle = cursor.getString(cursor.getColumnIndex("rbdtitle"));
        ltphoto = cursor.getBlob(cursor.getColumnIndex("ltdphoto"));
        lbphoto = cursor.getBlob(cursor.getColumnIndex("lbdphoto"));
        rtphoto = cursor.getBlob(cursor.getColumnIndex("rtdphoto"));
        rbphoto = cursor.getBlob(cursor.getColumnIndex("rbdphoto"));
        lthttp = cursor.getString(cursor.getColumnIndex("ltdhttp"));
        lbhttp = cursor.getString(cursor.getColumnIndex("lbdhttp"));
        rthttp = cursor.getString(cursor.getColumnIndex("rtdhttp"));
        rbhttp = cursor.getString(cursor.getColumnIndex("rbdhttp"));
    }
}
