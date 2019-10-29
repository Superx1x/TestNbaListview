package com.example.testnbalistview.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.testnbalistview.Model.DailyScoreboard;
import com.example.testnbalistview.R;

import java.util.ArrayList;

public class DailyscoreboardAdapter extends MyBaseAdapter<DailyScoreboard> {
    public DailyscoreboardAdapter(Context context, ArrayList<DailyScoreboard> dataList) {
        super(context, dataList);
    }

    @Override
    protected void rowSelected(DailyScoreboard song, int index) {
        Toast.makeText(context,song.getHteam()+" V.S "+song.getVteam(),Toast.LENGTH_SHORT).show();
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = inflater.inflate(R.layout.ada_dailyscoreboard,null);
        }
        final DailyScoreboard dailyScoreboard = dataList.get(position);
        ImageView vimgResId =convertView.findViewById(R.id.img_vimgResId);
        vimgResId.setImageResource(dailyScoreboard.getVimgResId());
        ImageView himgResId = convertView.findViewById(R.id.img_himgResId);
        himgResId.setImageResource(dailyScoreboard.getHimgResId());
        TextView vteam = convertView.findViewById(R.id.tv_vteam);
        vteam.setText(dailyScoreboard.getVteam());
        TextView hteam = convertView.findViewById(R.id.tv_hteam);
        hteam.setText(dailyScoreboard.getHteam());
        TextView vscore = convertView.findViewById(R.id.tv_vscore);
        vscore.setText(dailyScoreboard.getVscore());
        TextView hscore = convertView.findViewById(R.id.tv_hscore);
        hscore.setText(dailyScoreboard.getHscore());
        TextView vwin = convertView.findViewById(R.id.tv_vwin);
        vwin.setText(dailyScoreboard.getVwin());
        TextView hwin = convertView.findViewById(R.id.tv_hwin);
        hwin.setText(dailyScoreboard.getHwin());
        TextView vloss = convertView.findViewById(R.id.tv_vloss);
        vloss.setText(dailyScoreboard.getVloss());
        TextView hloss = convertView.findViewById(R.id.tv_hloss);
        hloss.setText(dailyScoreboard.getHloss());
        LinearLayout dailyscoreboardLayout = convertView.findViewById(R.id.dailyscoreboardLayout);
        dailyscoreboardLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rowSelected(dailyScoreboard,position);
            }
        });
        return convertView;
    }
}
