package com.example.testnbalistview;

import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.testnbalistview.Model.DailyScoreboard;
import com.example.testnbalistview.Model.PassGames;
import com.example.testnbalistview.Model.PassGamesDAO;
import com.example.testnbalistview.adapter.DailyscoreboardAdapter;
import com.example.testnbalistview.adapter.PassGamesAdapter;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    private Button scores;
    private Button news;
    private Button standings;
    private Button players;
    private Button video;
    //SelectedBar_up

    private Button showDate;
    private CalendarView datepicker;
    private Calendar current;
    private SimpleDateFormat sdf;

    private ListView lvdailyscoreboard;
    private ArrayList<DailyScoreboard> dailyScoreboardArrayList;
    private DailyScoreboard dailyScoreboard;

    private PassGames passGames;
    private ArrayList<PassGames> passGamesArrayList;
    private PassGamesDAO passGamesDAO;
    private Button returnToday;
    private TextView showNoGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkNetworkState();
        initDB();
        initView();
        initHandler();
//        getHalfTimeGameFromSeverByThread();
        getGameFromSeverByThread();
//        readFileFromResRaw();
    }

    private boolean checkNetworkState(){
        boolean flag = false;
        ConnectivityManager manager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        if(manager.getActiveNetworkInfo() != null){//表示可連線
            flag = manager.getActiveNetworkInfo().isConnected();//flag會是true
        }
        if(!flag){
            setNetwork();
        }else{
            isNetworkAvailable();
        }
        return flag;
    }
    private void setNetwork() {
        Toast.makeText(this,"wifi is cloed!",Toast.LENGTH_SHORT).show();
        AlertDialog.Builder builder = new AlertDialog.Builder(this,android.R.style.Theme_Material_Dialog_Alert);
        builder.setTitle("網路提醒資訊");
        builder.setMessage("網路不可用，如要繼續，請先設定網路！");
        builder.setPositiveButton("設定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = null;
                if(android.os.Build.VERSION.SDK_INT  > 10){//參考老師版本設定android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M
                    intent = new Intent(Settings.ACTION_WIFI_SETTINGS);
                }else{
                    intent = new Intent();
                    ComponentName component = new ComponentName("com.android.setting","com.android.setting.WirelessSettings");
                    intent.setComponent(component);
                    intent.setAction("android.inetnt.action.VIEW");
                }
                startActivity(intent);
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
        builder.create();
        builder.setCancelable(false);
        builder.show();
    }
    private void isNetworkAvailable() {
    }
    //checkNet_up

    private void initDB() {
        passGamesDAO = new PassGamesDAO(this);
    }

//    private String getHalfTimeGameJSONFromNet(){
//        String gameJSON = "";
//        HttpClient httpClient = new DefaultHttpClient();
//        String url = "https://www.dropbox.com/s/6s6dgu607iyp720/gamefromwebhalftime.json?dl=1";
//        try {
//            HttpResponse response = httpClient.execute(new HttpGet(url));
//            gameJSON = EntityUtils.toString(response.getEntity(),"utf-8");
//        } catch (Exception e) {
//            Log.e("GET", e.getMessage());
//        }
//        return gameJSON;
//    }
//    private void getHalfTimeGameFromSeverByThread(){
//        Thread halfTimeGame = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                String text = getHalfTimeGameJSONFromNet();
//                try {
//                    JSONObject jsonObject01 = new JSONObject(text);
//                    JSONArray jsonArray02 = jsonObject01.getJSONArray("games");
//                    for(int i =0;i<jsonArray02.length();i++){
//                        JSONObject jsonObjectGame = jsonArray02.getJSONObject(i);
//                        dailyScoreboard = new DailyScoreboard();
//                        dailyScoreboard.fromJSONObject(jsonObjectGame);
//                        dailyScoreboardArrayList = new ArrayList<>();
//                        dailyScoreboardArrayList.add(dailyScoreboard);
//                        Log.i("JSON",dailyScoreboard.toString());
//                    }
//                    UpdateUI(dailyScoreboardArrayList);
//                } catch (JSONException e) {
//                    Log.e("JSON2",e.getMessage());
//                }
//            }
//        });
//        halfTimeGame.start();
//    }

    private String getGameJSONFromNet(){
        String gameJSON = "";
        HttpClient httpClient = new DefaultHttpClient();
        String url = "https://www.dropbox.com/s/n3i00hlcwlzrhk3/gamefromweb.json?dl=1";
        try {
            HttpResponse response = httpClient.execute(new HttpGet(url));
            gameJSON = EntityUtils.toString(response.getEntity(),"utf-8");
        } catch (Exception e) {
            Log.e("GET", e.getMessage());
        }
        return gameJSON;
    }
    private void getGameFromSeverByThread() {
        new Thread(){
            @Override
            public void run() {
                super.run();
                String text = getGameJSONFromNet();
                try {
                    JSONObject jsonObject01 = new JSONObject(text);
                    JSONArray jsonArray02 = jsonObject01.getJSONArray("games");
                    for(int i =0;i<jsonArray02.length();i++){
                        JSONObject jsonObjectGame = jsonArray02.getJSONObject(i);
                        dailyScoreboard = new DailyScoreboard();
                        dailyScoreboard.fromJSONObject(jsonObjectGame);
                        dailyScoreboardArrayList = new ArrayList<>();
                        dailyScoreboardArrayList.add(dailyScoreboard);
                        Log.i("JSON",dailyScoreboard.toString());
                    }
//                    try {
//                        Thread.sleep(5000);
//                    } catch (InterruptedException e) {
//                        Log.e("SLEEP",e.getMessage());
//                    }
                    UpdateUI(dailyScoreboardArrayList);
                } catch (JSONException e) {
                    Log.e("JSON2",e.getMessage());
                }
            }
        }.start();
    }
    private void UpdateUI(final ArrayList<DailyScoreboard> dailyScoreboardArrayList) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                lvdailyscoreboard.setAdapter(new DailyscoreboardAdapter(MainActivity.this,dailyScoreboardArrayList));
            }
        });
    }
    //FromDropbox_up

    private void initHandler() {
        news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent itnews = new Intent();
                itnews.setClass(MainActivity.this,NewsActivity.class);
                startActivity(itnews);
            }
        });
        standings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent itstandings = new Intent();
                itstandings.setClass(MainActivity.this,StandingsActivity.class);
                startActivity(itstandings);
            }
        });
        players.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent itplayers = new Intent();
                itplayers.setClass(MainActivity.this,PlayersAllActivity.class);
                startActivity(itplayers);
            }
        });
        video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent itvideo = new Intent();
                itvideo.setClass(MainActivity.this,VideoActivity.class);
                startActivity(itvideo);
            }
        });
        //SelectedBar_up

        showDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(datepicker.getVisibility() != View.VISIBLE){
                    datepicker.setVisibility(View.VISIBLE);
                }else{
                    datepicker.setVisibility(View.GONE);
                }
            }
        });
        datepicker.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                if(returnToday.getVisibility() != View.VISIBLE){
                    returnToday.setVisibility(View.VISIBLE);
                }
                String selectedDate = String.format("%d年-%d月%d日",year,month+1,dayOfMonth);
                showDate.setText(selectedDate);
                datepicker.setVisibility(View.GONE);
                passGamesArrayList = new ArrayList<>();
                passGamesArrayList = passGamesDAO.getGamesByGameDate(selectedDate);
                lvdailyscoreboard.setAdapter(new PassGamesAdapter(MainActivity.this,passGamesArrayList));
                if(passGamesArrayList.size() == 0){
                    if(showNoGame.getVisibility() != View.VISIBLE){
                        showNoGame.setVisibility(View.VISIBLE);
                    }
                }else{
                    showNoGame.setVisibility(View.GONE);
                }
            }
        });
        returnToday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                returnToday.setVisibility(View.GONE);
                onResume();
            }
        });
    }

    private void initView() {
        getSupportActionBar().setTitle("比賽");
        scores = findViewById(R.id.btn_scores);
        news = findViewById(R.id.btn_news);
        standings = findViewById(R.id.btn_standings);
        players = findViewById(R.id.btn_players);
        video = findViewById(R.id.btn_video);
        //SelectedBar_up

        showDate = findViewById(R.id.btn_showDate);
        datepicker = findViewById(R.id.ca_datepicker);
        datepicker.setVisibility(View.GONE);
        current = Calendar.getInstance();
        showDateToday();
        returnToday = findViewById(R.id.btn_returnToday);
        returnToday.setVisibility(View.GONE);
        showNoGame = findViewById(R.id.tv_showNoGame);
        showNoGame.setVisibility(View.GONE);

        //listView
        lvdailyscoreboard = findViewById(R.id.lv_dailyscoreboard);
//        dailyScoreboardArrayList = new ArrayList<>();
    }

    private void showDateToday() {
        Date today = new Date();
        sdf = new SimpleDateFormat();
        sdf.applyPattern("YYYY年");
        String year = sdf.format(today);
        sdf.applyPattern("MM月dd日");
        String monthDay = sdf.format(today);
        String dateStr = String.format("     <     %s-%s     >     ",year,monthDay);
        showDate.setText(dateStr);
    }

    @Override
    protected void onResume() {
        super.onResume();
        initDB();
        initView();
        initHandler();
        getGameFromSeverByThread();
    }

    //    private void parseJSON(String data){
//        try {
//            JSONObject jsonObject01 = new JSONObject(data);
//            JSONArray jsonArray02 = jsonObject01.getJSONArray("games");
//            for(int i =0;i<jsonArray02.length();i++){
//                JSONObject jsonObjectGame = jsonArray02.getJSONObject(i);
//                dailyScoreboard = new DailyScoreboard();
//                dailyScoreboard.fromJSONObject(jsonObjectGame);
//                dailyScoreboardArrayList.add(dailyScoreboard);
//                Log.i("JSON",dailyScoreboard.toString());
//            }
//        } catch (JSONException e) {
//            Log.e("JSON2",e.getMessage());
//        }
//    }

//    private void readFileFromResRaw() {
//        BufferedReader br = null;
//        StringBuilder sb = new StringBuilder();
//        try{
//            br = new BufferedReader(new InputStreamReader(getResources().openRawResource(R.raw.gamefromweb)));
//            String text = br.readLine();
//            while (text != null){
//                sb.append(text);
//                sb.append("\n");
//                text = br.readLine();
//            }
//            parseJSON(sb.toString());
//        }catch(Exception e){
//            Log.e("JSON",e.getMessage());
//        }finally {
//            if(br != null){
//                try {
//                    br.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }

//    private class MyAsyncTask extends AsyncTask<String,Void,String> {
//        @Override
//        protected String doInBackground(String... strings) {
//            return getGameJSONFromNet();
//        }
//        @Override
//        protected void onPostExecute(String s) {
//            super.onPostExecute(s);
//            try {
//                JSONObject jsonObject01 = new JSONObject(s);
//                JSONArray jsonArray02 = jsonObject01.getJSONArray("games");
//                for(int i =0;i<jsonArray02.length();i++){
//                    JSONObject jsonObjectGame = jsonArray02.getJSONObject(i);
//                    dailyScoreboard = new DailyScoreboard();
//                    dailyScoreboard.fromJSONObject(jsonObjectGame);
//                    dailyScoreboardArrayList.add(dailyScoreboard);
//                    Log.i("JSON",dailyScoreboard.toString());
//                }
//            } catch (JSONException e) {
//                Log.e("JSON2",e.getMessage());
//            }
//            lvdailyscoreboard.setAdapter(new DailyscoreboardAdapter(MainActivity.this,dailyScoreboardArrayList));
//        }
//    }
}


