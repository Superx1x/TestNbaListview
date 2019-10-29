package com.example.testnbalistview.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.testnbalistview.Model.Players;
import com.example.testnbalistview.Model.PlayersDAO;
import com.example.testnbalistview.PlayerSingleActivity;
import com.example.testnbalistview.R;

import java.util.ArrayList;

public class PlayersAllAdapter extends MyBaseAdapter<Players> {


    public PlayersAllAdapter(Context context, ArrayList<Players> dataList) {
        super(context, dataList);
    }

    @Override
    protected void rowSelected(Players song, int index) {
        //Toast.makeText(context,song.getName(),Toast.LENGTH_SHORT).show();
        Intent it = new Intent(context, PlayerSingleActivity.class);
        it.putExtra("SID",song.getSid());
        context.startActivity(it);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = inflater.inflate(R.layout.ada_playersall,null);
        }
        final Players players = dataList.get(position);
        TextView nameApaa = convertView.findViewById(R.id.tv_nameApaa);
        nameApaa.setText(players.getName());
        TextView numberApaa = convertView.findViewById(R.id.tv_numberApaa);
        numberApaa.setText(players.getNumber());
        TextView positionApaa = convertView.findViewById(R.id.tv_positionApaa);
        positionApaa.setText(players.getPosition());
        TextView heightApaa = convertView.findViewById(R.id.tv_heightApaa);
        heightApaa.setText(players.getHeight());
        TextView weightApaa = convertView.findViewById(R.id.tv_weightApaa);
        weightApaa.setText(players.getWeight());
        ImageView photoHeadApaa = convertView.findViewById(R.id.img_photoHeadApaa);
        byte[] baphotoHeadApaa = players.getPhotohead();
        if(baphotoHeadApaa != null){
            Bitmap bitmap = BitmapFactory.decodeByteArray(baphotoHeadApaa,0,baphotoHeadApaa.length);
            photoHeadApaa.setImageBitmap(bitmap);
        }
        ImageView logoApaa = convertView.findViewById(R.id.img_logoApaa);
        byte[] balogoApaa = players.getLogo();
        if(balogoApaa != null){
            Bitmap bitmap = BitmapFactory.decodeByteArray(balogoApaa,0,balogoApaa.length);
            logoApaa.setImageBitmap(bitmap);
        }
        LinearLayout playersLayoutApaa = convertView.findViewById(R.id.PlayersLayoutApaa);
        playersLayoutApaa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rowSelected(players,position);
            }
        });
        final ImageView favouriteApaa = convertView.findViewById(R.id.img_favouriteApaa);
//        final String favouriteStr = players.getFavourite();
        if(players.getFavourite().equals("no")){
            favouriteApaa.setImageResource(R.mipmap.playersnotfavorite);
        }else{
            favouriteApaa.setImageResource(R.mipmap.playersisfavorite);
        }
        favouriteApaa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PlayersDAO playersDAO = new PlayersDAO(context);
                if(players.getFavourite().equals("no")){//favouriteStr.equals("no")不要用另外接資料的字串判斷
                    players.setFavourite("yes");
                    favouriteApaa.setImageResource(R.mipmap.playersisfavorite);
                    Toast.makeText(context,"加入我的最愛",Toast.LENGTH_SHORT).show();
                    playersDAO.updateFavo(players);
                }else{
                    players.setFavourite("no");
                    favouriteApaa.setImageResource(R.mipmap.playersnotfavorite);
                    Toast.makeText(context,"移除我的最愛",Toast.LENGTH_SHORT).show();
                    playersDAO.updateFavo(players);
                }
            }
        });
//        favouriteApaa.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                PlayersDAO playersDAO = new PlayersDAO(context);
//                if(favouriteStr.equals("no")){
//                    players.setFavourite("yes");
//                    Toast.makeText(context,"加入我的最愛",Toast.LENGTH_LONG).show();
//                }else if(favouriteStr.equals("yes")){
//                    players.setFavourite("no");
//                    Toast.makeText(context,"移除我的最愛",Toast.LENGTH_LONG).show();
//                }
//                playersDAO.updateFavo(players);
//            }
//        });
        return convertView;
    }
}

