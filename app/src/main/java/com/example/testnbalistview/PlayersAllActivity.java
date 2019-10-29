package com.example.testnbalistview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.testnbalistview.Model.Players;
import com.example.testnbalistview.Model.PlayersDAO;
import com.example.testnbalistview.adapter.PlayersAllAdapter;

import java.util.ArrayList;

public class PlayersAllActivity extends AppCompatActivity {
    private Button scoresPAA;
    private Button newsPAA;
    private Button standingsPAA;
    private Button videoPAA;
    //SelectedBar_up

    private ListView listView;
    private ArrayList<Players> playersArrayList;
    private PlayersDAO playersDAO;
    private EditText InputSearchPlayerPAA;
    private Button searchPlayersPAA;
    private Button searchFavoPlayersPAA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_players_all);
        //testDB();
        InitDB();
        initView();
        initHandler();
    }
    private void InitDB() {
        playersDAO = new PlayersDAO(this);
    }

    private void initHandler() {
        scoresPAA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent itscores = new Intent();
                itscores.setClass(PlayersAllActivity.this,MainActivity.class);
                startActivity(itscores);
            }
        });
        newsPAA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent itnews = new Intent();
                itnews.setClass(PlayersAllActivity.this,NewsActivity.class);
                startActivity(itnews);
            }
        });
        standingsPAA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent itstandings = new Intent();
                itstandings.setClass(PlayersAllActivity.this,StandingsActivity.class);
                startActivity(itstandings);
            }
        });
        videoPAA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent itvideo = new Intent();
                itvideo.setClass(PlayersAllActivity.this,VideoActivity.class);
                startActivity(itvideo);
            }
        });
        //SelectedBar_up

        searchPlayersPAA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userInput = InputSearchPlayerPAA.getText().toString();
                if(userInput.length() == 0){
                    playersArrayList = playersDAO.getAllPlayers();
                }else{
                    playersArrayList = playersDAO.getPlayersByName(userInput);
                }
                listView.setAdapter(new PlayersAllAdapter(PlayersAllActivity.this,playersArrayList));
            }
        });
        searchFavoPlayersPAA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playersArrayList = playersDAO.getPlayersByFavo();
                listView.setAdapter(new PlayersAllAdapter(PlayersAllActivity.this,playersArrayList));
            }
        });
    }

    private void initView() {
        getSupportActionBar().setTitle("球員");
        scoresPAA = findViewById(R.id.btn_scoresPAA);
        newsPAA = findViewById(R.id.btn_newsPAA);
        standingsPAA = findViewById(R.id.btn_standingsPAA);
        videoPAA = findViewById(R.id.btn_videoPAA);
        //SelectedBar_up

        listView = findViewById(R.id.lv_playersPAA);
        playersArrayList = playersDAO.getAllPlayers();
        listView.setAdapter(new PlayersAllAdapter(this,playersArrayList));

        InputSearchPlayerPAA = findViewById(R.id.et_InputSearchPlayerPAA);
        searchPlayersPAA = findViewById(R.id.btn_searchPlayersPAA);
        searchFavoPlayersPAA = findViewById(R.id.btn_searchFavoPlayersPAA);
    }

//    @Override
//    protected void onResume() {
//        super.onResume();
//        playersArrayList = playersDAO.getAllPlayers();
//        listView.setAdapter(new PlayersAllAdapter(this,playersArrayList));
//    }

    private void testDB() {
        PlayersDAO playersDAO = new PlayersDAO(this);
        Players players = playersDAO.getPlayerBySid(1);
        Log.i("SQULITE",""+players);
        players.setFavourite("yes");
        playersDAO.updateFavo(players);
        players = playersDAO.getPlayerBySid(1);
        Log.i("SQULITEUP",""+players);
    }
}
