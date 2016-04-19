package com.example.m14x.volleyrecyclerview_itunes.Model;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.m14x.volleyrecyclerview_itunes.R;

import java.util.List;

/**
 * Created by m14x on 04/18/2016.
 */
public class ViewHolder extends RecyclerView.ViewHolder {

    private TextView artistName;
    private TextView trackName;
    private TextView collectionName;

    public ViewHolder(View itemView, List<Pojo> content) {
        super(itemView);
        artistName = (TextView) itemView.findViewById(R.id.artisTextView);
        trackName = (TextView) itemView.findViewById(R.id.trackTextView);
        collectionName = (TextView) itemView.findViewById(R.id.collectionTextView);
    }

    public void setItem(Pojo pojo) {
        artistName.setText(pojo.getArtistName());
        trackName.setText(pojo.getTrackName());
        collectionName.setText(pojo.getCollectionName());

    }

}
