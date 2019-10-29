package com.example.testnbalistview.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.testnbalistview.Model.Video;
import com.example.testnbalistview.R;

import java.util.ArrayList;

public class VideoAdapter extends MyBaseAdapter<Video> {

    public VideoAdapter(Context context, ArrayList<Video> dataList) {
        super(context, dataList);
    }

    @Override
    protected void rowSelected(Video song, int index) {
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = inflater.inflate(R.layout.ada_video,null);
        }
        final Video video = dataList.get(position);
        ImageView videoPhotoAVA = convertView.findViewById(R.id.img_videoPhotoAVA);
        byte[] bavideoPhotoAVA = video.getVideoPhoto();
        if(bavideoPhotoAVA != null){
            Bitmap bitmap = BitmapFactory.decodeByteArray(bavideoPhotoAVA,0,bavideoPhotoAVA.length);
            videoPhotoAVA.setImageBitmap(bitmap);
        }
        TextView titleAVA = convertView.findViewById(R.id.tv_titleAVA);
        titleAVA.setText(video.getTitle());
        TextView nameAVA = convertView.findViewById(R.id.tv_nameAVA);
        nameAVA.setText(video.getName());
//        TextView videoLine = convertView.findViewById(R.id.tv_videoLine);
        return convertView;
    }
}
