package com.example.android.android_me.ui;

import android.support.v7.app.AppCompatActivity;

/**
 * Created by mserge on 02.03.2018.
 */

public class ReplaceFragmentStrategy extends FragmentStrategy {
    public ReplaceFragmentStrategy(AppCompatActivity activity) {
        super(activity);
    }

    @Override
    protected void changePart(int container, BodyPartFragment fragment) {
        fragmentManager.beginTransaction()
                .replace(container, fragment)
                .commit();
    }
}
