package com.example.audioplayer;

import android.os.Environment;

import java.io.File;
import java.util.ArrayList;

public class Audio {


    public static ArrayList<File> findSongs(File directory)
    {

        ArrayList<File> mp3_list=new ArrayList<>();
        File[] files=directory.listFiles();
        for(File singleFile:files)
        {
            if (singleFile.isDirectory() && !singleFile.isHidden() && !singleFile.getName().equalsIgnoreCase("android"))
            {
                mp3_list.addAll(findSongs(singleFile));

            }
            else
            {
                if (singleFile.getName().endsWith(".mp3")  && !singleFile.getName().contains("Call@") || singleFile.getName().endsWith(".MP3"))
                {
                    mp3_list.add(singleFile);
                }
            }
        }
        return mp3_list;

    }

}
