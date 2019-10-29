package com.example.testnbalistview.Model;

import com.example.testnbalistview.R;

import org.json.JSONException;
import org.json.JSONObject;

public class DailyScoreboard {
    private int vimgResId;
    private int himgResId;
    private String vteam;
    private String hteam;
    private String vscore;
    private String hscore;
    private String vwin;
    private String hwin;
    private String vloss;
    private String hloss;

    public DailyScoreboard() {
    }

    public DailyScoreboard(int vimgResId, int himgResId, String vteam, String hteam, String vscore, String hscore, String vwin, String hwin, String vloss, String hloss) {
        this.vimgResId = vimgResId;
        this.himgResId = himgResId;
        this.vteam = vteam;
        this.hteam = hteam;
        this.vscore = vscore;
        this.hscore = hscore;
        this.vwin = vwin;
        this.hwin = hwin;
        this.vloss = vloss;
        this.hloss = hloss;
    }

    public int getVimgResId() {
        return vimgResId;
    }

    public void setVimgResId(int vimgResId) {
        this.vimgResId = vimgResId;
    }

    public int getHimgResId() {
        return himgResId;
    }

    public void setHimgResId(int himgResId) {
        this.himgResId = himgResId;
    }

    public String getVteam() {
        return vteam;
    }

    public void setVteam(String vteam) {
        this.vteam = vteam;
    }

    public String getHteam() {
        return hteam;
    }

    public void setHteam(String hteam) {
        this.hteam = hteam;
    }

    public String getVscore() {
        return vscore;
    }

    public void setVscore(String vscore) {
        this.vscore = vscore;
    }

    public String getHscore() {
        return hscore;
    }

    public void setHscore(String hscore) {
        this.hscore = hscore;
    }

    public String getVwin() {
        return vwin;
    }

    public void setVwin(String vwin) {
        this.vwin = vwin;
    }

    public String getHwin() {
        return hwin;
    }

    public void setHwin(String hwin) {
        this.hwin = hwin;
    }

    public String getVloss() {
        return vloss;
    }

    public void setVloss(String vloss) {
        this.vloss = vloss;
    }

    public String getHloss() {
        return hloss;
    }

    public void setHloss(String hloss) {
        this.hloss = hloss;
    }

    @Override
    public String toString() {
        return "DailyScoreboard{" +
                "vimgResId=" + vimgResId +
                ", himgResId=" + himgResId +
                ", vteam='" + vteam + '\'' +
                ", hteam='" + hteam + '\'' +
                ", vscore='" + vscore + '\'' +
                ", hscore='" + hscore + '\'' +
                ", vwin='" + vwin + '\'' +
                ", hwin='" + hwin + '\'' +
                ", vloss='" + vloss + '\'' +
                ", hloss='" + hloss + '\'' +
                '}';
    }

    public void fromJSONObject(JSONObject jsonObjectGame) {
        try{
            JSONObject jsonObjectvTeam = jsonObjectGame.getJSONObject("vTeam");
            vteam = jsonObjectvTeam.getString("triCode");
            vscore = jsonObjectvTeam.getString("score");
            vwin = jsonObjectvTeam.getString("win");
            vloss = jsonObjectvTeam.getString("loss");
            switch(vteam){
                case "TOR":
                    vimgResId = R.mipmap.tor;
            }
            JSONObject jsonObjecthTeam = jsonObjectGame.getJSONObject("hTeam");
            hteam = jsonObjecthTeam.getString("triCode");
            hscore = jsonObjecthTeam.getString("score");
            hwin = jsonObjecthTeam.getString("win");
            hloss = jsonObjecthTeam.getString("loss");
            switch(hteam){
                case "GSW":
                    himgResId = R.mipmap.gsw;
            }
        }catch(JSONException e){
            e.printStackTrace();
        }
    }
}
