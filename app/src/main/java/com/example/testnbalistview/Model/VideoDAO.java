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

public class VideoDAO {
    private final String DB_NAME = "nbaVideo.db";
    private final String GETALLVIDEO = "SELECT * FROM nbaVideo";
    private final String TAG = "SQULITE";
    private Context ctx;
    public VideoDAO(Context ctx) {
        this.ctx = ctx;
        checkDB(ctx);
    }

    private void checkDB(Context ctx) {
        File dbFile = ctx.getDatabasePath(DB_NAME);
        if(!dbFile.exists()){
            File parentDir = new File(dbFile.getParent());
            if(!parentDir.exists()){
                parentDir.mkdir();
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
            }finally{
                if(is != null){
                    try {
                        is.close();
                    } catch (IOException ei) {
                        Log.e(TAG,ei.getMessage());
                    }
                }
                if(os != null){
                    try {
                        os.close();
                    } catch (IOException eo) {
                        Log.e(TAG,eo.getMessage());
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

    public ArrayList<Video> getAllVideo(){
        ArrayList<Video> videoArrayList = new ArrayList<>();
        SQLiteDatabase db = getReadableDataBase();
        Cursor cursor = db.rawQuery(GETALLVIDEO,null);
        if(cursor.moveToFirst()){
            do{
                Video video = new Video();
                video.fromCursor(cursor);
                videoArrayList.add(video);
            }while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return videoArrayList;
    }
}
