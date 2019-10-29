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

public class PassGamesDAO {
    private static final String DB_NAME = "passGames.db";
    public static final String TAG = "SQLITE";
    private Context ctx;

    public PassGamesDAO(Context ctx) {
        this.ctx = ctx;
        checkDBFiles(ctx);
    }

    private void checkDBFiles(Context ctx) {
        File dbFile = ctx.getDatabasePath(DB_NAME);
        if(!dbFile.exists()){
            File parentDir = new File(dbFile.getParent());
            if(!parentDir.exists()){
                dbFile.mkdir();
            }
            InputStream is = null;
            OutputStream os = null;
            try{
                is = ctx.getAssets().open(DB_NAME);
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
        File dbFile = ctx.getDatabasePath(DB_NAME);
        return SQLiteDatabase.openDatabase(dbFile.getPath(),null,SQLiteDatabase.OPEN_READONLY);
    }
    private SQLiteDatabase getWriteableDataBase(){
        File dbFile = ctx.getDatabasePath(DB_NAME);
        return SQLiteDatabase.openDatabase(dbFile.getPath(),null,SQLiteDatabase.OPEN_READWRITE);
    }

    public ArrayList<PassGames> getGamesByGameDate(String date){
        ArrayList<PassGames> passGamesArrayList = new ArrayList<>();
        SQLiteDatabase db = getReadableDataBase();
        String sql = String.format("SELECT * FROM DailyScoreboard WHERE gamedate like '%%%s%%'",date);
        Cursor cursor = db.rawQuery(sql,null);
        if(cursor.moveToFirst()){
            do{
                PassGames passGames = new PassGames();
                passGames.fromCursor(cursor);
                passGamesArrayList.add(passGames);
            }while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return passGamesArrayList;
    }
}
