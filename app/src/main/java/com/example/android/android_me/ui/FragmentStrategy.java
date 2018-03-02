package com.example.android.android_me.ui;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;

/**
 * Created by mserge on 02.03.2018.
 */
class FragmentStrategy {
    private AppCompatActivity activity;
    protected FragmentManager fragmentManager;
    private int headIndex;

    public void setHeadIndex(int headIndex) {
        this.headIndex = headIndex;
    }

    public void setLegIndex(int legIndex) {
        this.legIndex = legIndex;
    }

    public void setBodyIndex(int bodyIndex) {
        this.bodyIndex = bodyIndex;
    }

    private int legIndex;
    private int bodyIndex;

    public FragmentStrategy(AppCompatActivity activity) {
        this.activity = activity;
    }

    public FragmentStrategy extractIntent() {
        final Intent intent = activity.getIntent();
        bodyIndex = intent.getIntExtra("bodyIndex", 0);
        headIndex = intent.getIntExtra("headIndex", 0);
        legIndex = intent.getIntExtra("legIndex", 0);
        return this;
    }

    public void invoke() {
        // Retrieve list index values that were sent through an intent; use them to display the desired Android-Me body part image
        // Use setListindex(int index) to set the list index for all BodyPartFragments
        setHead();

        // Create and display the body and leg BodyPartFragments
        setBody();
        setLegs();
    }

    protected void changePart(int container, BodyPartFragment fragment) {
        fragmentManager.beginTransaction()
                .add(container, fragment)
                .commit();
    }
    private void setHead() {
        // Create a new head BodyPartFragment
        BodyPartFragment headFragment = new BodyPartFragment();

        // Set the list of image id's for the head fragment and set the position to the second image in the list
        headFragment.setImageIds(AndroidImageAssets.getHeads());

        // Get the correct index to access in the array of head images from the intent
        // Set the default value to 0
        headFragment.setListIndex(headIndex);

        // Add the fragment to its container using a FragmentManager and a Transaction
        fragmentManager = activity.getSupportFragmentManager();

        changePart(R.id.head_container, headFragment);
    }

    private void setLegs() {
        BodyPartFragment legFragment = new BodyPartFragment();
        legFragment.setImageIds(AndroidImageAssets.getLegs());
        legFragment.setListIndex(legIndex);

        final int container = R.id.leg_container;
        final BodyPartFragment fragment = legFragment;
        changePart(container, fragment);
    }


    private void setBody() {
        BodyPartFragment bodyFragment = new BodyPartFragment();
        bodyFragment.setImageIds(AndroidImageAssets.getBodies());
        bodyFragment.setListIndex(bodyIndex);

        changePart(R.id.body_container, bodyFragment);
    }
}
