package com.example.m14x.assignment.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.m14x.assignment.Activities.SecondActivity;
import com.example.m14x.assignment.MainActivity;
import com.example.m14x.assignment.R;

/**
 * Created by m14x on 05/15/2016.
 */
public class ActivityAnimation extends Fragment implements View.OnClickListener{

    private Button goActivity;
    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_animations_fragment,container,false);
        goActivity = (Button) view.findViewById(R.id.activity1Btn);
        goActivity.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.activity1Btn:
                Intent intent = new Intent(view.getContext(), SecondActivity.class);
                startActivity(intent);
                getActivity().overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                break;
            default:
                break;
        }

    }
}
