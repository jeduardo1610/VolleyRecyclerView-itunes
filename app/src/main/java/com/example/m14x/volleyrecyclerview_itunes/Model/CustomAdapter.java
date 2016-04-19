package com.example.m14x.volleyrecyclerview_itunes.Model;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.m14x.volleyrecyclerview_itunes.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by m14x on 04/18/2016.
 */
public class CustomAdapter extends RecyclerView.Adapter <ViewHolder> {

    private Context context;
    private List<Pojo> content = new ArrayList<Pojo>();

    public CustomAdapter(Context context, List<Pojo> content) {
        this.context = context;
        this.content = content;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater;
        layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.item,null);
        ViewHolder viewHolder = new ViewHolder(view,this.content);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Pojo pojo = content.get(position);
        holder.setItem(pojo);

    }

    @Override
    public int getItemCount() {
        return content.size();
    }
}
