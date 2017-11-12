package com.runachaqui.runachaqui.custom_fragment;

import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rubengees.introduction.Slide;
import com.runachaqui.runachaqui.R;

/**
 * Created by Ivan Aliaga on 12/11/2017.
 */

public class S1Fragment implements Slide.CustomViewBuilder {
    @NonNull
    @Override
    public View buildView(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        //Find media player
        return inflater.inflate(R.layout.fragment_s1, parent, false);
    }
}
