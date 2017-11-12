package com.runachaqui.runachaqui;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.pixplicity.easyprefs.library.Prefs;
import com.runachaqui.runachaqui.utils.UserData;

public class AnimalActivity extends Activity implements View.OnClickListener {

    private ImageButton btnMonoArdilla;
    private ImageButton btnPiwicho;
    private ImageButton btnMotelo;
    private ImageButton btnRanaFlechaPunteada;
    private String animal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal);
        btnMonoArdilla = (ImageButton) findViewById(R.id.btnMonoArdilla);
        btnPiwicho = (ImageButton) findViewById(R.id.btnPiwicho);
        btnMotelo = (ImageButton) findViewById(R.id.btnMotelo);
        btnRanaFlechaPunteada = (ImageButton) findViewById(R.id.btnRanaFlechaPunteada);

        animal = Prefs.getString(UserData.ANIMAL,"");
        if(animal.compareTo("1")==0){
            btnRanaFlechaPunteada.setVisibility(View.VISIBLE);
        }else{
            btnRanaFlechaPunteada.setVisibility(View.GONE);
        }

        btnMonoArdilla.setOnClickListener(this);
        btnPiwicho.setOnClickListener(this);
        btnMotelo.setOnClickListener(this);
        btnRanaFlechaPunteada.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        int id_button = view.getId();
        Intent intent = new Intent(this, HistoryActivity.class);
        switch (id_button) {
            case R.id.btnMonoArdilla:
                intent.putExtra("id_animal", "1");
                break;
            case R.id.btnMotelo:
                intent.putExtra("id_animal", "2");
                break;
            case R.id.btnPiwicho:
                intent.putExtra("id_animal", "3");
                break;
            case R.id.btnRanaFlechaPunteada:
                intent.putExtra("id_animal", "4");
                break;
            default:
                return;
        }
        startActivity(intent);
    }
}
