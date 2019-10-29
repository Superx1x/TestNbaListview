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

public class PlayersDAO {
    private static final String DB_Name = "nbaPlayersaddfav.db";
    public static final String TAG = "SQULITE";
    private static final String GETALLPLAYERS = "SELECT * FROM nbaPlayers ORDER BY name";
//    private static final String GETPLAYERBYSID = "SELECT * FROM nbaPlayers WHERE sid = sid";
    private Context ctx;

    public PlayersDAO(Context ctx) {
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
                if(is != null){
                    try {
                        is.close();
                    } catch (IOException e) {
                        Log.e(TAG,e.getMessage());
                    }
                }
                if(os != null){
                    try {
                        os.close();
                    } catch (IOException e) {
                        Log.e(TAG,e.getMessage());
                    }
                }
            }
        }
    }
    private SQLiteDatabase getReadableDataBase(){
        File dbFile = ctx.getDatabasePath(DB_Name);
        return SQLiteDatabase.openDatabase(dbFile.getPath(),null,SQLiteDatabase.OPEN_READONLY);
    }
    private SQLiteDatabase getWriteableDatabase(){
        File dbFile = ctx.getDatabasePath(DB_Name);
        return SQLiteDatabase.openDatabase(dbFile.getPath(),null,SQLiteDatabase.OPEN_READWRITE);
    }

    public ArrayList<Players> getAllPlayers(){
        ArrayList<Players> playersArrayList = new ArrayList<>();
        SQLiteDatabase db = getReadableDataBase();
        Cursor cursor = db.rawQuery(GETALLPLAYERS,null);
        if(cursor.moveToFirst()){
            do{
                Players players = new Players();
                players.fromCursor(cursor);
                playersArrayList.add(players);
            }while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return playersArrayList;
    }

    public Players getPlayerBySid(int sid) {
        Players players = null;
        SQLiteDatabase db = getReadableDataBase();
        String sql = String.format("SELECT * FROM nbaPlayers WHERE sid = %d",sid);
        Cursor cursor = db.rawQuery(sql,null);
        if(cursor.moveToFirst()){
            players = new Players();
            players.fromCursor(cursor);
        }
        cursor.close();
        db.close();
        return players;
    }

    public ArrayList<Players> getPlayersByName(String name){
        ArrayList<Players> playersArrayList = new ArrayList<>();
        SQLiteDatabase db = getReadableDataBase();
        String sql = String.format("SELECT * FROM nbaPlayers WHERE name like '%%%s%%'",name);
        Cursor cursor = db.rawQuery(sql,null);
        if(cursor.moveToFirst()){
            do{
               Players players = new Players();
               players.fromCursor(cursor);
               playersArrayList.add(players);
            }while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return playersArrayList;
    }

    public ArrayList<Players> getPlayersByFavo(){
        ArrayList<Players> playersArrayList = new ArrayList<>();
        SQLiteDatabase db = getReadableDataBase();
        String sql = "SELECT * FROM nbaPlayers WHERE favourite = 'yes'";
        Cursor cursor = db.rawQuery(sql,null);
        if(cursor.moveToFirst()){
            do{
                Players players = new Players();
                players.fromCursor(cursor);
                playersArrayList.add(players);
            }while(cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return playersArrayList;
    }

    public void updateFavo(Players data){
        SQLiteDatabase db = getWriteableDatabase();
        try {
            db.update("nbaPlayers", data.toContentValuesOnlyFavo(), "sid = ?", new String[]{"" + data.getSid()});
        }catch(Exception ex){
            Log.e(TAG,ex.getMessage());
        }
        db.close();
    }
}
