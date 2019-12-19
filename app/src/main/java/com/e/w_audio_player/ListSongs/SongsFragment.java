package com.e.w_audio_player.ListSongs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.e.w_audio_player.R;

import java.util.ArrayList;
import java.util.HashMap;

public class SongsFragment extends Fragment {

    public ArrayList<HashMap<String, String>> songsList = new ArrayList<HashMap<String, String>>();
    private RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.playlist, container, false);
        recyclerView = view.findViewById(R.id.recycler_view);

        ArrayList<HashMap<String, String>> songsListData = new ArrayList<>();
        SongsManager plm = new SongsManager();
        // get all songs from sdcard
        this.songsList = plm.getPlayList();

        // looping through playlist
        for (int i = 0; i < songsList.size(); i++) {
            // creating new HashMap
            HashMap<String, String> song = songsList.get(i);

            // adding HashList to ArrayList
            songsListData.add(song);
        }
        initView();
        return view;
    }

    public void initView(){

        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        SongsManager songsManager = new SongsManager();
        SongsAdapter songAdapter = new SongsAdapter(songsManager.getPlayList());
        recyclerView.setAdapter(songAdapter);
    }
}