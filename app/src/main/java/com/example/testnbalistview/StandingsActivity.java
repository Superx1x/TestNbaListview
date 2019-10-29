package com.example.testnbalistview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.testnbalistview.Model.Standings;
import com.example.testnbalistview.Model.StandingsDAO;
import com.example.testnbalistview.adapter.StandingsAdapter;

import java.util.ArrayList;

public class StandingsActivity extends AppCompatActivity {
    private Button scoresSA;
    private Button newsSA;
    private Button playersSA;
    private Button videoSA;
    //SelectedBar_up

//    private ListView listViewEast;
//    private ListView listViewWest;
    private ListView listViewEastWestOne;
    private ArrayList<Standings> standingsArrayList;
    private StandingsDAO standingsDAO;
    private int[] test = {1,3,5,7,9};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_standings);
        //testDB();
        initDB();
        initView();
        initHandler();
    }

    private void initDB() {
        standingsDAO = new StandingsDAO(this);
    }

    private void initHandler() {
        scoresSA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent itscores = new Intent();
                itscores.setClass(StandingsActivity.this,MainActivity.class);
                startActivity(itscores);
            }
        });
        newsSA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent itnews = new Intent();
                itnews.setClass(StandingsActivity.this,NewsActivity.class);
                startActivity(itnews);
            }
        });
        playersSA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent itplayers = new Intent();
                itplayers.setClass(StandingsActivity.this,PlayersAllActivity.class);
                startActivity(itplayers);
            }
        });
        videoSA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent itvideo = new Intent();
                itvideo.setClass(StandingsActivity.this,VideoActivity.class);
                startActivity(itvideo);
            }
        });
        //SelectedBar_up
    }

    private void initView() {
        getSupportActionBar().setTitle("戰績");
        scoresSA = findViewById(R.id.btn_scoresSA);
        newsSA = findViewById(R.id.btn_newsSA);
        playersSA = findViewById(R.id.btn_playersSA);
        videoSA =findViewById(R.id.btn_videoSA);
//        listViewEast = findViewById(R.id.lv_standingsEast);
//        standingsArrayList = standingsDAO.getEastStandings();
//        listViewEast.setAdapter(new StandingsAdapter(this,standingsArrayList));
//        listViewWest = findViewById(R.id.lv_standingsWest);
//        standingsArrayList = standingsDAO.getWestStandings();
//        listViewWest.setAdapter(new StandingsAdapter(this,standingsArrayList));
        listViewEastWestOne = findViewById(R.id.lv_standingsEastWestOne);
        standingsArrayList = standingsDAO.getEastWestStandings();
        listViewEastWestOne.setAdapter(new StandingsAdapter(this,standingsArrayList));
    }
    private void testDB() {
        StandingsDAO standingsDAO = new StandingsDAO(this);
        standingsArrayList = standingsDAO.getEastStandings();
        Log.i(StandingsDAO.TAG,""+standingsArrayList.size());
    }
}
