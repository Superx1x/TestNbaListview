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

public class NbanewsDAO {
    private static final String DB_Name = "nbanews062401.db";
    public static final String TAG = "SQLITE";
    private static final String GETALLNBANEWS = "SELECT * FROM Nbanews";
    private Context ctx;

    public NbanewsDAO(Context ctx) {
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
    private SQLiteDatabase getReadableDatabase(){
        File dbFile = ctx.getDatabasePath(DB_Name);//到dbFile.getPath()這絕對路徑(沙箱裡的路徑),去找檔案,如沒有就要去複製,就是checkDBFile方法
        return SQLiteDatabase.openDatabase(dbFile.getPath(),null,SQLiteDatabase.OPEN_READONLY);
    }
    private SQLiteDatabase getWritableDatabase(){
        File dbFike = ctx.getDatabasePath(DB_Name);
        return SQLiteDatabase.openDatabase(dbFike.getPath(),null,SQLiteDatabase.OPEN_READWRITE);
    }

    public ArrayList<Nbanews> getAllNbanews(){
        ArrayList<Nbanews> nbanewsArrayList = new ArrayList<Nbanews>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(GETALLNBANEWS,null);
        if(cursor.moveToFirst()){
            do{
                Nbanews nbanews = new Nbanews();
                nbanews.fromCursor(cursor);
                nbanewsArrayList.add(nbanews);
            }while(cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return nbanewsArrayList;
    }
}
