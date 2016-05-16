package com.example.m14x.assignment.Fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.m14x.assignment.CustomAdapter;
import com.example.m14x.assignment.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by m14x on 05/15/2016.
 */
public class CoordinatorFragment extends Fragment {
    private RecyclerView recyclerView;
    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.coordinator, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerview);
        LinearLayoutManager llm = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(llm);
        recyclerView.setHasFixedSize(true);
        fill();
        return view;
    }

    private List<String> fill() {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add("Item" + i);
            CustomAdapter adapter = new CustomAdapter(view.getContext(),list);
            recyclerView.setAdapter(adapter);
        }

        return list;
    }


}
