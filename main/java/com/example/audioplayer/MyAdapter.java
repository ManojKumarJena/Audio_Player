package com.example.audioplayer;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ColorSpace;
import android.media.MediaMetadataRetriever;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.util.Locale;



public class MyAdapter extends BaseAdapter {
    Context context;
    File[] songs;

    public MyAdapter(Context context, File[] songs) {
        this.context = context;
        this.songs = songs;
    }

    @Override
    public int getCount() {
        return songs.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = View.inflate(context,R.layout.list_row,null);
        TextView songName = (TextView) row.findViewById(R.id.songName);
        TextView songPath=(TextView)row.findViewById(R.id.songPath);
        ImageView imageView=(ImageView)row.findViewById(R.id.imageView);

        songName.setText(songs[position].getName());
        songPath.setText(songs[position].getParent());


        MediaMetadataRetriever mmr = new MediaMetadataRetriever();
        mmr.setDataSource(songs[position].getPath());
        byte[] artBytes =  mmr.getEmbeddedPicture();
        if(artBytes != null)
        {
            InputStream is = new ByteArrayInputStream(mmr.getEmbeddedPicture());
            Bitmap bm = BitmapFactory.decodeStream(is);
            imageView.setImageBitmap(bm);
        }

        return row;
    }



}
