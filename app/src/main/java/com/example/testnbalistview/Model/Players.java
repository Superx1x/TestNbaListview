package com.example.testnbalistview.Model;

import android.content.ContentValues;
import android.database.Cursor;

import java.util.Arrays;

public class Players {
    private int sid;
    private String name;
    private String number;
    private String position;
    private String height;
    private String weight;
    private String team;
    private String pts;
    private String reb;
    private String ast;
    private String fg;
    private String threep;
    private String ft;
    private String born;
    private String age;
    private String years;
    private String more;
    private String favourite;//DB欄位建錯,屬性將錯就錯
    private byte[] logo;
    private byte[] photohead;
    private byte[] photobody;

    public Players() {
    }
    public Players(int sid, String name, String number, String position, String height, String weight, String team, String pts, String reb, String ast, String fg, String threep, String ft, String born, String age, String years, String more, String favourite, byte[] logo, byte[] photohead, byte[] photobody) {
        this.sid = sid;
        this.name = name;
        this.number = number;
        this.position = position;
        this.height = height;
        this.weight = weight;
        this.team = team;
        this.pts = pts;
        this.reb = reb;
        this.ast = ast;
        this.fg = fg;
        this.threep = threep;
        this.ft = ft;
        this.born = born;
        this.age = age;
        this.years = years;
        this.more = more;
        this.favourite = favourite;
        this.logo = logo;
        this.photohead = photohead;
        this.photobody = photobody;
    }
    public int getSid() {
        return sid;
    }
    public void setSid(int sid) {
        this.sid = sid;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getNumber() {
        return number;
    }
    public void setNumber(String number) {
        this.number = number;
    }
    public String getPosition() {
        return position;
    }
    public void setPosition(String position) {
        this.position = position;
    }
    public String getHeight() {
        return height;
    }
    public void setHeight(String hright) {
        this.height = hright;
    }
    public String getWeight() {
        return weight;
    }
    public void setWeight(String weight) {
        this.weight = weight;
    }
    public String getTeam() {
        return team;
    }
    public void setTeam(String team) {
        this.team = team;
    }
    public String getPts() {
        return pts;
    }
    public void setPts(String pts) {
        this.pts = pts;
    }
    public String getReb() {
        return reb;
    }
    public void setReb(String reb) {
        this.reb = reb;
    }
    public String getAst() {
        return ast;
    }
    public void setAst(String ast) {
        this.ast = ast;
    }
    public String getFg() {
        return fg;
    }
    public void setFg(String fg) {
        this.fg = fg;
    }
    public String getThreep() {
        return threep;
    }
    public void setThreep(String threep) {
        this.threep = threep;
    }
    public String getFt() {
        return ft;
    }
    public void setFt(String ft) {
        this.ft = ft;
    }
    public String getBorn() {
        return born;
    }
    public void setBorn(String born) {
        this.born = born;
    }
    public String getAge() {
        return age;
    }
    public void setAge(String age) {
        this.age = age;
    }
    public String getYears() {
        return years;
    }
    public void setYears(String years) {
        this.years = years;
    }
    public String getMore() {
        return more;
    }
    public void setMore(String more) {
        this.more = more;
    }
    public String getFavourite() {
        return favourite;
    }
    public void setFavourite(String favourite) {
        this.favourite = favourite;
    }
    public byte[] getLogo() {
        return logo;
    }
    public void setLogo(byte[] logo) {
        this.logo = logo;
    }
    public byte[] getPhotohead() {
        return photohead;
    }
    public void setPhotohead(byte[] photohead) {
        this.photohead = photohead;
    }
    public byte[] getPhotobody() {
        return photobody;
    }
    public void setPhotobody(byte[] photobody) {
        this.photobody = photobody;
    }

    @Override
    public String toString() {
        return "Players{" +
                "sid=" + sid +
                ", name='" + name + '\'' +
                ", number='" + number + '\'' +
                ", position='" + position + '\'' +
                ", height='" + height + '\'' +
                ", weight='" + weight + '\'' +
                ", team='" + team + '\'' +
                ", pts='" + pts + '\'' +
                ", reb='" + reb + '\'' +
                ", ast='" + ast + '\'' +
                ", fg='" + fg + '\'' +
                ", threep='" + threep + '\'' +
                ", ft='" + ft + '\'' +
                ", born='" + born + '\'' +
                ", age='" + age + '\'' +
                ", years='" + years + '\'' +
                ", more='" + more + '\'' +
                ", favourite='" + favourite + '\'' +
                ", logo=" + Arrays.toString(logo) +
                ", photohead=" + Arrays.toString(photohead) +
                ", photobody=" + Arrays.toString(photobody) +
                '}';
    }

    public void fromCursor(Cursor cursor) {
        sid = cursor.getInt(cursor.getColumnIndex("sid"));
        name = cursor.getString(cursor.getColumnIndex("name"));
        number = cursor.getString(cursor.getColumnIndex("number"));
        position = cursor.getString(cursor.getColumnIndex("position"));
        height = cursor.getString(cursor.getColumnIndex("height"));
        weight = cursor.getString(cursor.getColumnIndex("weight"));
        team = cursor.getString(cursor.getColumnIndex("team"));
        pts = cursor.getString(cursor.getColumnIndex("pts"));
        reb = cursor.getString(cursor.getColumnIndex("reb"));
        ast = cursor.getString(cursor.getColumnIndex("ast"));
        fg = cursor.getString(cursor.getColumnIndex("fg"));
        threep = cursor.getString(cursor.getColumnIndex("3p"));
        ft = cursor.getString(cursor.getColumnIndex("ft"));
        born = cursor.getString(cursor.getColumnIndex("born"));
        age = cursor.getString(cursor.getColumnIndex("age"));
        years = cursor.getString(cursor.getColumnIndex("years"));
        more = cursor.getString(cursor.getColumnIndex("more"));
        favourite = cursor.getString(cursor.getColumnIndex("favourite"));
        logo = cursor.getBlob(cursor.getColumnIndex("logo"));
        photohead = cursor.getBlob(cursor.getColumnIndex("photohead"));
        photobody = cursor.getBlob(cursor.getColumnIndex("photobody"));
    }

    public ContentValues toContentValuesOnlyFavo() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("favourite",this.favourite);
        return contentValues;
    }

    public ContentValues toContentValues() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("sid",this.sid);
        contentValues.put("name",this.name);
        contentValues.put("number",this.number);
        contentValues.put("position",this.position);
        contentValues.put("height",this.height);
        contentValues.put("weight",this.weight);
        contentValues.put("team",this.team);
        contentValues.put("pts",this.pts);
        contentValues.put("reb",this.reb);
        contentValues.put("ast",this.ast);
        contentValues.put("fg",this.fg);
        contentValues.put("3p",this.threep);//db欄位名稱3p,Java屬性資料不能數字
        contentValues.put("ft",this.ft);
        contentValues.put("born",this.born);
        contentValues.put("age",this.age);
        contentValues.put("years",this.years);
        contentValues.put("more",this.more);
        contentValues.put("favourite",this.favourite);
        contentValues.put("logo",this.logo);
        contentValues.put("photohead",this.photohead);
        contentValues.put("photobody",this.photobody);
        return contentValues;
    }
}
