package com.runachaqui.runachaqui;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.rubengees.introduction.IntroductionBuilder;

public class HistoryActivity extends Activity {
    private String id_animal = "";
    private ImageView historyAnimal;
    MediaPlayer mp;
    String id = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        Intent intent = getIntent();
        historyAnimal = (ImageView)findViewById(R.id.historyAnimal);
        String id_animal = intent.getStringExtra("id_animal");
        if(id_animal.compareTo("1") == 0){
            historyAnimal.setImageResource(R.drawable.pp);
            mp = MediaPlayer.create (getApplicationContext(), R.raw.monofinito);
            mp.start();
            id = "1";
        }else if(id_animal.compareTo("2") == 0){
            historyAnimal.setImageResource(R.drawable.htortuga);
            mp = MediaPlayer.create (getApplicationContext(), R.raw.motelo_au);
            mp.start();
            id = "2";
        }else if(id_animal.compareTo("3") == 0){
            id = "3";
            historyAnimal.setImageResource(R.drawable.piwi);
            mp = MediaPlayer.create (getApplicationContext(), R.raw.pihuicho);
            mp.start();
        }else if(id_animal.compareTo("4") == 0){
            historyAnimal.setImageResource(R.drawable.hsapo);
            id = "4";
        }

        historyAnimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), TriviaActivity.class);
                intent.putExtra("id_animal", id);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == IntroductionBuilder.INTRODUCTION_REQUEST_CODE && resultCode == RESULT_OK) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }
}
