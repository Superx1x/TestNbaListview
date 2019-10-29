package com.example.testnbalistview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.testnbalistview.Model.Video;
import com.example.testnbalistview.Model.VideoDAO;
import com.example.testnbalistview.adapter.VideoAdapter;

import java.util.ArrayList;

public class VideoActivity extends AppCompatActivity {
    private Button scoresVA;
    private Button newsVA;
    private Button standingsVA;
    private Button playersVA;
    //SelectedBar_up
    //UI
    private TextView tvVideoVA;
    private WebView webViewVideoVA;
    private ListView lvVideoVA;
    //Data
    private Video video;
    private VideoDAO videoDAO;
    private ArrayList<Video> videoArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        //testDB();
        initDB();
        initView();
        initHandler();
    }

    private void initDB() {
        videoDAO = new VideoDAO(this);
    }

    private void initHandler() {
        scoresVA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent itscores = new Intent();
                itscores.setClass(VideoActivity.this,MainActivity.class);
                startActivity(itscores);
            }
        });
        newsVA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent itnews = new Intent();
                itnews.setClass(VideoActivity.this,NewsActivity.class);
                startActivity(itnews);
            }
        });
        standingsVA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent itstandings = new Intent();
                itstandings.setClass(VideoActivity.this,StandingsActivity.class);
                startActivity(itstandings);
            }
        });
        playersVA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent itplayers = new Intent();
                itplayers.setClass(VideoActivity.this,PlayersAllActivity.class);
                startActivity(itplayers);
            }
        });
        lvVideoVA.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(VideoActivity.this,"測試反應"+position,Toast.LENGTH_SHORT).show();//videoArrayList.get(position).getYoutubeHttp()
                video = videoArrayList.get(position);
                String http = video.getYoutubeHttp();
                webViewVideoVA.loadData(http,"text/html","utf-8");
                String title = video.getTitle();
                tvVideoVA.setText(title);
            }
        });
    }

    private void initView() {
        getSupportActionBar().setTitle("影片");
        scoresVA = findViewById(R.id.btn_scoresVA);
        newsVA = findViewById(R.id.btn_newsVA);
        standingsVA = findViewById(R.id.btn_standingsVA);
        playersVA = findViewById(R.id.btn_playersVA);
        //SelectedBar_up

        lvVideoVA = findViewById(R.id.lv_videoVA);
        videoArrayList = videoDAO.getAllVideo();
        lvVideoVA.setAdapter(new VideoAdapter(this,videoArrayList));

        tvVideoVA = findViewById(R.id.tv_videoVA);
        tvVideoVA.setText(videoArrayList.get(0).getTitle());

        webViewVideoVA = findViewById(R.id.webView_videoVA);
        WebSettings webSettings = webViewVideoVA.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
        webSettings.setSupportZoom(true);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setAppCacheEnabled(true);
        webViewVideoVA.setWebViewClient(new WebViewClient());
        webViewVideoVA.loadData(videoArrayList.get(0).getYoutubeHttp(),"text/html","utf-8");
    }

    private void testDB() {
        videoDAO = new VideoDAO(this);
    }
}
