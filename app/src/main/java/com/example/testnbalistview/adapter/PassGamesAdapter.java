package com.example.testnbalistview.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.testnbalistview.Model.PassGames;
import com.example.testnbalistview.R;

import java.util.ArrayList;

public class PassGamesAdapter extends MyBaseAdapter<PassGames> {
    public PassGamesAdapter(Context context, ArrayList<PassGames> dataList) {
        super(context, dataList);
    }

    @Override
    protected void rowSelected(PassGames song, int index) {
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = inflater.inflate(R.layout.ada_dailyscoreboard,null);
        }
        PassGames passGames = dataList.get(position);
        ImageView vimgResId =convertView.findViewById(R.id.img_vimgResId);
        vimgResId.setImageResource(passGames.getVimgResIdPass());
        ImageView himgResId = convertView.findViewById(R.id.img_himgResId);
        himgResId.setImageResource(passGames.getHimgResIdPass());
        TextView vteam = convertView.findViewById(R.id.tv_vteam);
        vteam.setText(passGames.getVteamPass());
        TextView hteam = convertView.findViewById(R.id.tv_hteam);
        hteam.setText(passGames.getHteamPass());
        TextView vscore = convertView.findViewById(R.id.tv_vscore);
        vscore.setText(passGames.getVscorePass());
        TextView hscore = convertView.findViewById(R.id.tv_hscore);
        hscore.setText(passGames.getHscorePass());
        TextView vwin = convertView.findViewById(R.id.tv_vwin);
        vwin.setText(passGames.getVwinPass());
        TextView hwin = convertView.findViewById(R.id.tv_hwin);
        hwin.setText(passGames.getHwinPass());
        TextView vloss = convertView.findViewById(R.id.tv_vloss);
        vloss.setText(passGames.getVlossPass());
        TextView hloss = convertView.findViewById(R.id.tv_hloss);
        hloss.setText(passGames.getHlossPass());
        return convertView;
    }
}
