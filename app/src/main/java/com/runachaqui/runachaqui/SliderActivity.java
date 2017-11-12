package com.runachaqui.runachaqui;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;

import com.rubengees.introduction.IntroductionBuilder;
import com.rubengees.introduction.Slide;
import com.runachaqui.runachaqui.custom_fragment.S0Fragment;
import com.runachaqui.runachaqui.custom_fragment.S1Fragment;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class SliderActivity extends Activity {
    private static final long SPLASH_SCREEN_DELAY = 20000;
    MediaPlayer mp;
    ImageButton btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_slider);
        setContentView(R.layout.fragment_s0);
        mp = MediaPlayer.create (getApplicationContext(), R.raw.history);
        mp.start();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {

                // Start the next activity
                Intent mainIntent = new Intent().setClass(
                        SliderActivity.this, MainActivity.class);
                startActivity(mainIntent);

                // Close the activity so the user won't able to go back this
                // activity pressing Back button
                finish();
            }
        };

        // Simulate a long loading process on application startup.
        Timer timer = new Timer();
        timer.schedule(task, SPLASH_SCREEN_DELAY);
    }

    private List<Slide> generateSlides(){
        List<Slide> result = new ArrayList<>();
        result.add(new Slide()
                .withCustomViewBuilder(new S0Fragment())
                .withColorResource(R.color.colorPrimary));

        result.add(new Slide()
                .withCustomViewBuilder(new S1Fragment())
                .withColorResource(R.color.colorPrimaryDark));
        return result;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //if (requestCode == IntroductionBuilder.INTRODUCTION_REQUEST_CODE && resultCode == RESULT_OK) {
        //    Intent intent = new Intent(this, MainActivity.class);
        //    startActivity(intent);
        //}
    }


}
