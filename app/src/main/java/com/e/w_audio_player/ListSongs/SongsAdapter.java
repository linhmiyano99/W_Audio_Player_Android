package com.e.w_audio_player.ListSongs;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.e.w_audio_player.R;

import java.util.ArrayList;
import java.util.HashMap;

public class SongsAdapter extends RecyclerView.Adapter<SongsAdapter.ViewHolder> {
    ArrayList<HashMap<String, String>> dataSong;

    public SongsAdapter(ArrayList<HashMap<String, String>> playList) {
        SongsManager songsManager = new SongsManager();
        dataSong = songsManager.getPlayList();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.playlist_item, parent,false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtName.setText(dataSong.get(position).get("songTitle"));
    }

    @Override
    public int getItemCount() {
        return dataSong.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView txtName;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.songTitle);
        }
    }
}
