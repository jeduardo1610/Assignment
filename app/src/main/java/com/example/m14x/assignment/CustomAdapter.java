package com.example.m14x.assignment;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.m14x.assignment.Activities.ViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by m14x on 05/16/2016.
 */
public class CustomAdapter extends RecyclerView.Adapter <ViewHolder> {

    private Context context;
    private List<String> content = new ArrayList<String>();

    public CustomAdapter(Context context,List<String> content) {
        this.content = content;
        this.context = context;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater;
        layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.list_item,null);
        ViewHolder viewHolder = new ViewHolder(view,this.content);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        String msg = content.get(position);
        holder.setItem(msg);

    }

    @Override
    public int getItemCount() {
        return content.size();
    }
}
