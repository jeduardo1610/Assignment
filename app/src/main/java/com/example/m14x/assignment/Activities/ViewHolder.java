package com.example.m14x.assignment.Activities;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.m14x.assignment.R;

import java.util.List;

/**
 * Created by m14x on 05/16/2016.
 */
public class ViewHolder extends RecyclerView.ViewHolder {

private TextView cont;

public ViewHolder(View itemView, List<String> content) {
        super(itemView);
    cont = (TextView) itemView.findViewById(R.id.text1);
        }

public void setItem(String msg) {
        cont.setText(msg);

        }

}
