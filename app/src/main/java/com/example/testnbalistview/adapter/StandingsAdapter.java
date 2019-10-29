package com.example.testnbalistview.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.testnbalistview.Model.Standings;
import com.example.testnbalistview.R;

import java.util.ArrayList;

public class StandingsAdapter extends MyBaseAdapter<Standings> {
    public StandingsAdapter(Context context, ArrayList<Standings> dataList) {
        super(context, dataList);
    }

    @Override
    protected void rowSelected(Standings song, int index) {

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(position==15){
            convertView = inflater.inflate(R.layout.ada_standings_showbar,null);
            Standings standings = dataList.get(15);
            TextView showBarRankingAsaRe = convertView.findViewById(R.id.tv_showBarRankingAsaRe);
            showBarRankingAsaRe.setText("1");
            TextView showBarTeamAsaRe = convertView.findViewById(R.id.tv_showBarTeamAsaRe);
            showBarTeamAsaRe.setText(standings.getTeam());
            TextView showBarWinAsaRe = convertView.findViewById(R.id.tv_showBarWinAsaRe);
            showBarWinAsaRe.setText(standings.getWin());
            TextView showBarLossAsaRe = convertView.findViewById(R.id.tv_showBarLossAsaRe);
            showBarLossAsaRe.setText(standings.getLoss());
            TextView showBarPerAsaRe = convertView.findViewById(R.id.tv_showBarPerAsaRe);
            showBarPerAsaRe.setText(standings.getPer());
            TextView showBarGbAsaRe = convertView.findViewById(R.id.tv_showBarGbAsaRe);
            showBarGbAsaRe.setText(standings.getGb());
            ImageView showBarLogoAsaRe = convertView.findViewById(R.id.img_showBarLogoAsaRe);
            byte[] bashowBarLogoAsaRe = standings.getLogo();
            if(bashowBarLogoAsaRe != null){
                Bitmap bm = BitmapFactory.decodeByteArray(bashowBarLogoAsaRe,0,bashowBarLogoAsaRe.length);
                showBarLogoAsaRe.setImageBitmap(bm);
            }
        }else{
            convertView = inflater.inflate(R.layout.ada_stangings, null);
            Standings standings = dataList.get(position);
            TextView rankingAsa = convertView.findViewById(R.id.tv_rankingAsa);
            if(position>-1 && position<15){
                rankingAsa.setText(position+1+"");
            }else{
                rankingAsa.setText(position-14+"");
            }
            TextView teamAsa = convertView.findViewById(R.id.tv_teamAsa);
            teamAsa.setText(standings.getTeam());
            TextView winAsa = convertView.findViewById(R.id.tv_winAsa);
            winAsa.setText(standings.getWin());
            TextView lossAsa = convertView.findViewById(R.id.tv_lossAsa);
            lossAsa.setText(standings.getLoss());
            TextView perAsa = convertView.findViewById(R.id.tv_perAsa);
            perAsa.setText(standings.getPer());
            TextView gbAsa = convertView.findViewById(R.id.tv_gbAsa);
            gbAsa.setText(standings.getGb());
            ImageView logoAsa = convertView.findViewById(R.id.img_logoAsa);
            byte[] baLogoAsa = standings.getLogo();
            if (baLogoAsa != null) {
                Bitmap bm = BitmapFactory.decodeByteArray(baLogoAsa, 0, baLogoAsa.length);
                logoAsa.setImageBitmap(bm);
            }
        }
        return convertView;
    }
}


//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        if(convertView == null){
//            convertView = inflater.inflate(R.layout.ada_stangings,null);
//        }
//        Standings standings = dataList.get(position);
//
//        TextView rankingAsa = convertView.findViewById(R.id.tv_rankingAsa);
//        rankingAsa.setText(position+1+"");
////        rankingAsa.setText(standings.getRanking());
//        TextView teamAsa = convertView.findViewById(R.id.tv_teamAsa);
//        teamAsa.setText(standings.getTeam());
//        TextView winAsa = convertView.findViewById(R.id.tv_winAsa);
//        winAsa.setText(standings.getWin());
//        TextView lossAsa = convertView.findViewById(R.id.tv_lossAsa);
//        lossAsa.setText(standings.getLoss());
//        TextView perAsa = convertView.findViewById(R.id.tv_perAsa);
//        perAsa.setText(standings.getPer());
//        TextView gbAsa = convertView.findViewById(R.id.tv_gbAsa);
//        gbAsa.setText(standings.getGb());
////        TextView confAsa = convertView.findViewById(R.id.tv_confAsa);
////        confAsa.setText(standings.getConf());
////        TextView divAsa = convertView.findViewById(R.id.tv_divAsa);
////        divAsa.setText(standings.getDiv());
////        TextView homeAsa = convertView.findViewById(R.id.tv_homeAsa);
////        homeAsa.setText(standings.getHome());
////        TextView roadAsa = convertView.findViewById(R.id.tv_roadAsa);
////        roadAsa.setText(standings.getRoad());
////        TextView streakAsa = convertView.findViewById(R.id.tv_streakAsa);
//        ImageView logoAsa = convertView.findViewById(R.id.img_logoAsa);
//        byte[] baLogoAsa = standings.getLogo();
//        if(baLogoAsa != null){
//            Bitmap bm = BitmapFactory.decodeByteArray(baLogoAsa,0,baLogoAsa.length);
//            logoAsa.setImageBitmap(bm);
//        }
//        return convertView;
//    }
