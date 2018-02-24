package com.example.android.android_me.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;

/**
 * Created by mserge on 24.02.2018.
 *
 *
 // DONE (2) Create a new class called BodyPartFragment to display an image of an Android-Me body part
 // In this class, you'll need to implement an empty constructor and the onCreateView method


 */

public class BodyPartFragment extends Fragment {
    public BodyPartFragment() {
    }

    /**
     * INflates image view
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_body_part, container, false);
        final ImageView bodyPartImageView = (ImageView) rootView.findViewById(R.id.body_part_image_view);

         // DONE (3) Show the first image in the list of head images
         // Soon, you'll update this image display code to show any image you want
        bodyPartImageView.setImageResource(AndroidImageAssets.getHeads().get(0));
        return rootView;
    }
}
