package com.example.testnbalistview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.testnbalistview.Model.Nbanews;
import com.example.testnbalistview.Model.NbanewsDAO;
import com.example.testnbalistview.adapter.NbanewsAdapter;

import java.util.ArrayList;

public class NewsActivity extends AppCompatActivity {
    private Button scoresNA;
    private Button standingsNA;
    private Button playersNA;
    private Button videoNA;
    private ListView listView;
    private ArrayList<Nbanews> nbanewsArrayList;
    private NbanewsDAO nbanewsDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        //testDB();
        initDB();
        initView();
        initHandler();
    }

    private void initHandler() {
        scoresNA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent itscores = new Intent();
                itscores.setClass(NewsActivity.this,MainActivity.class);
                startActivity(itscores);
            }
        });
        standingsNA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent itstandings = new Intent();
                itstandings.setClass(NewsActivity.this,StandingsActivity.class);
                startActivity(itstandings);
            }
        });
        playersNA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent itplayers = new Intent();
                itplayers.setClass(NewsActivity.this,PlayersAllActivity.class);
                startActivity(itplayers);
            }
        });
        videoNA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent itvideo = new Intent();
                itvideo.setClass(NewsActivity.this,VideoActivity.class);
                startActivity(itvideo);
            }
        });
    }

    private void initDB() {
        nbanewsDAO = new NbanewsDAO(this);
    }

    private void testDB() {
        NbanewsDAO nbanewsDAO = new NbanewsDAO(this);
        ArrayList<Nbanews> nbanewsArrayList = nbanewsDAO.getAllNbanews();
        Log.e(nbanewsDAO.TAG,""+nbanewsArrayList.size());
    }

    private void initView() {
        getSupportActionBar().setTitle("新聞");
        scoresNA = findViewById(R.id.btn_scoresNA);
        standingsNA = findViewById(R.id.btn_standingsNA);
        playersNA = findViewById(R.id.btn_playersNA);
        videoNA = findViewById(R.id.btn_videoNA);
        listView = findViewById(R.id.lv_news);
        nbanewsArrayList = nbanewsDAO.getAllNbanews();
        listView.setAdapter(new NbanewsAdapter(this,nbanewsArrayList));
    }
}
