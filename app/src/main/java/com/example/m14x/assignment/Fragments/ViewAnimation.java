package com.example.m14x.assignment.Fragments;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationSet;
import android.view.animation.BounceInterpolator;
import android.widget.Button;
import android.widget.ImageView;

import com.example.m14x.assignment.R;

/**
 * Created by m14x on 05/15/2016.
 */
public class ViewAnimation extends Fragment implements View.OnClickListener{

    private Button anim;
    private Button translation;
    private Button rotation;
    private Button setAnimation;
    private ImageView image;
    private ObjectAnimator fadeAnimator;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.view_animations_fragment,container,false);
        anim = (Button) v.findViewById(R.id.fadeAnimBtn);
        translation = (Button) v.findViewById(R.id.transBtn);
        rotation = (Button) v.findViewById(R.id.rotationBtn);
        setAnimation = (Button) v.findViewById(R.id.setBtn);
        image = (ImageView) v.findViewById(R.id.imageView);
        anim.setOnClickListener(this);
        translation.setOnClickListener(this);
        rotation.setOnClickListener(this);
        setAnimation.setOnClickListener(this);

        return v;
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.fadeAnimBtn:
                fadeAnimator = ObjectAnimator.ofFloat(image, View.ALPHA, 1, 0.2f);
                fadeAnimator.setDuration(1000);
                fadeAnimator.setRepeatCount(ValueAnimator.INFINITE);
                fadeAnimator.setRepeatMode(ValueAnimator.REVERSE);
                fadeAnimator.start();
                break;
            case R.id.transBtn:
                image.refreshDrawableState();
                ObjectAnimator translation = ObjectAnimator.ofFloat(image, View.TRANSLATION_X, 300).setDuration(1000);
                translation.setInterpolator(new BounceInterpolator());
                translation.start();
                break;
            case R.id.rotationBtn:
                ObjectAnimator rotation = ObjectAnimator.ofFloat(image,View.ROTATION_X,180);
                rotation.setDuration(1000);
                rotation.start();
                break;
            case R.id.setBtn:
                ObjectAnimator scaleX = ObjectAnimator.ofFloat(image, "scaleX", 2.0f);
                ObjectAnimator scaleY = ObjectAnimator.ofFloat(image, "scaleY", 2.0f);
                AnimatorSet set1 = new AnimatorSet();
                set1.playTogether(scaleX,scaleY);

                ObjectAnimator x = ObjectAnimator.ofFloat(image, "X", 300);
                ObjectAnimator y = ObjectAnimator.ofFloat(image, "Y", 300);
                AnimatorSet set2 = new AnimatorSet();
                set2.playTogether(x,y);
                AnimatorSet set3 = new AnimatorSet();
                set3.playSequentially(set1,set2);
                set3.start();
                break;
            default:
                break;

        }
    }
}
