package com.example.audioplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaMetadataRetriever;
import android.os.Bundle;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Playlist extends AppCompatActivity {
    ListView listView;
    SearchView searchView;
    File[] items;
    MyAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlist);
        listView = (ListView) findViewById(R.id.listView);
        searchView=(SearchView)findViewById(R.id.searchView);

        File root = Environment.getExternalStorageDirectory();
        ArrayList<File> songs = Audio.findSongs(root);

        items = new File[songs.size()];
        for (int i = 0; i < items.length; i++) {
            items[i] = songs.get(i);


        }

        adapter = new MyAdapter(this,items);
        listView.setAdapter(adapter);
        Toast.makeText(getApplicationContext(), "" + items.length, Toast.LENGTH_SHORT).show();


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("position", position);
                //intent.putExtra("songs",songs);
                //intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });


    }
}
