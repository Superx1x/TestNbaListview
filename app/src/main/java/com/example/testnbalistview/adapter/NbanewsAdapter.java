package com.example.testnbalistview.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.testnbalistview.Model.Nbanews;
import com.example.testnbalistview.R;

import java.util.ArrayList;

public class NbanewsAdapter extends MyBaseAdapter<Nbanews> {

    public NbanewsAdapter(Context context, ArrayList<Nbanews> dataList) {
        super(context, dataList);
    }

    @Override
    protected void rowSelected(Nbanews song, int index) {
        Toast.makeText(context,"News",Toast.LENGTH_SHORT).show();
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = inflater.inflate(R.layout.ada_news,null);
        }
        final Nbanews nbanews = dataList.get(position);

        ImageView newsLeftT = convertView.findViewById(R.id.img_newsLeftT);
        byte[] baLT = nbanews.getLtphoto();
        if(baLT != null){
            Bitmap bmLT = BitmapFactory.decodeByteArray(baLT,0,baLT.length);
            newsLeftT.setImageBitmap(bmLT);
        }
        newsLeftT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent();
                it.setAction(Intent.ACTION_VIEW);
                String LThttp = nbanews.getLthttp();
                it.setData(Uri.parse(LThttp));
                context.startActivity(it);
            }
        });

        ImageView newsLeftB = convertView.findViewById(R.id.img_newsLeftB);
        byte[] baLB = nbanews.getLbphoto();
        if(baLB != null){
            Bitmap bmLB = BitmapFactory.decodeByteArray(baLB,0,baLB.length);
            newsLeftB.setImageBitmap(bmLB);
        }
        newsLeftB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent();
                it.setAction(Intent.ACTION_VIEW);
                String LBhttp = nbanews.getLbhttp();
                it.setData(Uri.parse(LBhttp));
                context.startActivity(it);
            }
        });

        ImageView newsRightT = convertView.findViewById(R.id.img_newsRightT);
        byte[] baRT = nbanews.getRtphoto();
        if(baRT != null){
            Bitmap bmRT = BitmapFactory.decodeByteArray(baRT,0,baRT.length);
            newsRightT.setImageBitmap(bmRT);
        }
        newsRightT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent();
                it.setAction(Intent.ACTION_VIEW);
                String Rthttp = nbanews.getRthttp();
                it.setData(Uri.parse(Rthttp));
                context.startActivity(it);
            }
        });

        ImageView newsRightB = convertView.findViewById(R.id.img_newsRightB);
        byte[] baRB = nbanews.getRbphoto();
        if(baRB != null){
            Bitmap bmRB = BitmapFactory.decodeByteArray(baRB,0,baRB.length);
            newsRightB.setImageBitmap(bmRB);
        }
        newsRightB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent();
                it.setAction(Intent.ACTION_VIEW);
                //String Rbhttp = nbanews.getRbhttp();
                it.setData(Uri.parse(nbanews.getRbhttp()));
                context.startActivity(it);
            }
        });

        TextView tvnewsLeftT = convertView.findViewById(R.id.tv_newsLeftT);
        tvnewsLeftT.setText(nbanews.getLttitle());
        TextView tvnewsLeftB = convertView.findViewById(R.id.tv_newsLeftB);
        tvnewsLeftB.setText(nbanews.getLbtitle());
        TextView tvnewsRightT = convertView.findViewById(R.id.tv_newsRightT);
        tvnewsRightT.setText(nbanews.getRttitle());
        TextView tvnewsRightB = convertView.findViewById(R.id.tv_newsRightB);
        tvnewsRightB.setText(nbanews.getRbtitle());
        TextView tvreportTime = convertView.findViewById(R.id.tv_reportTime);
        String reportTime = nbanews.getReportTime();
        String month = reportTime.substring(5,6);
        String day = reportTime.substring(6,8);
        String date = String.format("   %s月%s日   ",month,day);
        tvreportTime.setText(date);

        return convertView;
    }
}
