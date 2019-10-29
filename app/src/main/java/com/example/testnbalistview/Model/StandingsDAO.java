package com.example.testnbalistview.Model;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public class StandingsDAO {
    private static final String DB_Name = "nbaStandings0629.db";
    public static final String TAG = "SQLITESTA";
    private static final String GETEASTWESTSTANDINGS = "SELECT * FROM NbaStandings0629 ORDER BY conference, per DESC";
    private static final String GETEASTSTANDINGS = "SELECT * FROM NbaStandings0629 WHERE conference like 'East' ORDER BY per DESC";
    private static final String GETWESTSTANDINGS = "SELECT * FROM NbaStandings0629 WHERE conference like 'West' ORDER BY per DESC";
    private Context ctx;

    public StandingsDAO(Context ctx) {
        this.ctx = ctx;
        checkDBFile(ctx);
    }

    private void checkDBFile(Context ctx) {
        File dbFile = ctx.getDatabasePath(DB_Name);
        if(!dbFile.exists()){
            File parentDir = new File(dbFile.getParent());
            if(!parentDir.exists()){
                parentDir.mkdir();
            }
            InputStream is = null;
            OutputStream os = null;
            try{
                is = ctx.getAssets().open(DB_Name);
                os = new FileOutputStream(dbFile);
                byte[] buffer = new byte[1024];
                int read = is.read(buffer);
                while(read>0){
                    os.write(buffer,0,read);
                    read = is.read(buffer);
                }
            }catch(Exception ex){
                Log.e(TAG,ex.getMessage());
            }finally {
                if(is!=null){
                    try {
                        is.close();
                    } catch (IOException e) {
                        Log.e(TAG,e.getMessage());
                    }
                }
                if(os!=null){
                    try {
                        os.close();
                    } catch (IOException e) {
                        Log.e(TAG,e.getMessage());
                    }
                }
            }
        }
    }
    private SQLiteDatabase getReadableDatabase(){
        File dbFile = ctx.getDatabasePath(DB_Name);
        return SQLiteDatabase.openDatabase(dbFile.getPath(),null,SQLiteDatabase.OPEN_READONLY);
    }
    private SQLiteDatabase getWritableDatabase(){
        File dbFile = ctx.getDatabasePath(DB_Name);
        return SQLiteDatabase.openDatabase(dbFile.getPath(),null,SQLiteDatabase.OPEN_READWRITE);
    }

    public ArrayList<Standings> getEastStandings(){
        ArrayList<Standings> standingsArrayList = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(GETEASTSTANDINGS,null);
        if(cursor.moveToFirst()){
            do{
                Standings standings =new Standings();
                standings.fromCursor(cursor);
                standingsArrayList.add(standings);
            }while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return standingsArrayList;
    }

    public ArrayList<Standings> getWestStandings(){
        ArrayList<Standings> standingsArrayList = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(GETWESTSTANDINGS,null);
        if(cursor.moveToFirst()){
            do{
                Standings standings = new Standings();
                standings.fromCursor(cursor);
                standingsArrayList.add(standings);
            }while(cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return standingsArrayList;
    }

    public ArrayList<Standings> getEastWestStandings(){
        ArrayList<Standings> standingsArrayList = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(GETEASTWESTSTANDINGS,null);
        if(cursor.moveToFirst()){
            do{
                Standings standings = new Standings();
                standings.fromCursor(cursor);
                standingsArrayList.add(standings);
            }while(cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return standingsArrayList;
    }
}
