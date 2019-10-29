package com.example.testnbalistview;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.testnbalistview.Model.Players;
import com.example.testnbalistview.Model.PlayersDAO;

public class PlayerSingleActivity extends AppCompatActivity {
    private ScrollView scrollView;
    private TextView namePASin;
    private TextView heightPASin; private TextView weightPASin;
    private TextView forPtsPASin; private TextView forRebPASin; private TextView forAstPASin;
    private TextView ptsPASin; private TextView rebPASin; private TextView astPASin;
    private TextView forFgPASin; private TextView forThreepPASin; private TextView forFtPASin;
    private TextView fgPASin; private TextView threepPASin; private TextView ftPASin;
    private TextView forBornPASin; private TextView bornPASin;
    private TextView forAgePASin;  private TextView agePASin;
    private TextView forYearsPASin; private TextView yearsPASin;
    private ImageView photoBodyPASin;
    private Button morePASin;
    private WebView webViewMorePASin;
    private LinearLayout playerSinLayout;
    //Data
    private Players players;
    private PlayersDAO playersDAO;
    public int sid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_single);
        initDB();
        initView();
        initHandler();
    }

    private void initHandler() {
        morePASin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(webViewMorePASin.getVisibility() != View.VISIBLE){
                    webViewMorePASin.setVisibility(View.VISIBLE);
                    playerSinLayout.setVisibility(View.GONE);
                    morePASin.setText("返回單年度");
                }else{
                    webViewMorePASin.setVisibility(View.GONE);
                    playerSinLayout.setVisibility(View.VISIBLE);
                    morePASin.setText("更多歷年數據");
                }
            }
        });
    }

    private void initDB() {
        playersDAO = new PlayersDAO(this);
        sid = getIntent().getIntExtra("SID",-1);
    }

    private void initView() {
        getSupportActionBar().setTitle("球員資料");
        playerSinLayout = findViewById(R.id.playerSinLayout);
        scrollView = findViewById(R.id.sv_PASin);
        namePASin = findViewById(R.id.tv_namePASin);
        heightPASin = findViewById(R.id.tv_heightPASin);
        weightPASin = findViewById(R.id.tv_weightPASin);
        forPtsPASin = findViewById(R.id.tv_forPtsPASin);
        forRebPASin = findViewById(R.id.tv_forRebPASin);
        forAstPASin = findViewById(R.id.tv_forAstPASin);
        ptsPASin = findViewById(R.id.tv_ptsPASin);
        rebPASin = findViewById(R.id.tv_rebPASin);
        astPASin = findViewById(R.id.tv_astPASin);
        forFgPASin = findViewById(R.id.tv_forFgPASin);
        forThreepPASin = findViewById(R.id.tv_forThreepPASin);
        forFtPASin = findViewById(R.id.tv_forFtPASin);
        fgPASin = findViewById(R.id.tv_fgPASin);
        threepPASin = findViewById(R.id.tv_threepPASin);
        ftPASin = findViewById(R.id.tv_ftPASin);
        forBornPASin = findViewById(R.id.tv_forBornPASin);
        bornPASin = findViewById(R.id.tv_bornPASin);
        forAgePASin = findViewById(R.id.tv_forAgePASin);
        agePASin = findViewById(R.id.tv_agePASin);
        forYearsPASin = findViewById(R.id.tv_forYearsPASin);
        yearsPASin = findViewById(R.id.tv_yearsPASin);
        photoBodyPASin = findViewById(R.id.img_photoBodyPASin);
        morePASin = findViewById(R.id.btn_morePASin);
        webViewMorePASin = findViewById(R.id.webView_morePASin);//webView
        if (sid == -1) {
            players = new Players();
        }else{
            players = playersDAO.getPlayerBySid(sid);
            namePASin.setText(players.getName());
            heightPASin.setText(players.getHeight());
            weightPASin.setText(players.getWeight());
            ptsPASin.setText(players.getPts());
            rebPASin.setText(players.getReb());
            astPASin.setText(players.getAst());
            fgPASin.setText(players.getFg());
            threepPASin.setText(players.getThreep());
            ftPASin.setText(players.getFt());
            bornPASin.setText(players.getBorn());
            agePASin.setText(players.getAge());
            yearsPASin.setText(players.getYears());
            byte[] ba = players.getPhotobody();
            if(ba!=null){
                Bitmap bitmap = BitmapFactory.decodeByteArray(ba,0,ba.length);
                photoBodyPASin.setImageBitmap(bitmap);
            }
            //WebView接值
            webViewMorePASin.getSettings().setJavaScriptEnabled(true);
            webViewMorePASin.getSettings().setSupportZoom(true);
//            webViewMorePASin.getSettings().setBuiltInZoomControls(true);
            webViewMorePASin.loadUrl(players.getMore());
            webViewMorePASin.setFocusable(false);
        }
        webViewMorePASin.setVisibility(View.GONE);
    }
}
