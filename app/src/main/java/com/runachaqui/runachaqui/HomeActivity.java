package com.runachaqui.runachaqui;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.runachaqui.runachaqui.utils.UserData;

public class HomeActivity extends Activity implements View.OnClickListener{
    private ImageButton btnEmpezarJuego;
    private ImageButton btnRanking;
    private ImageButton btnGuardianQR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        btnEmpezarJuego = (ImageButton)findViewById(R.id.btnEmpezarJuego);
        btnRanking = (ImageButton)findViewById(R.id.btnRanking);
        btnGuardianQR = (ImageButton)findViewById(R.id.btnQR);
        btnEmpezarJuego.setOnClickListener(this);
        btnRanking.setOnClickListener(this);
        btnGuardianQR.setOnClickListener(this);
        UserData.setDataCore("0");

    }

    @Override
    public void onClick(View view) {
        int id_button = view.getId();
        Intent intent;
        switch(id_button){
            case R.id.btnEmpezarJuego:
                intent = new Intent(this, AnimalActivity.class);
                startActivity(intent);
                break;
            case R.id.btnRanking:
                intent = new Intent(this, RankingActivity.class);
                startActivity(intent);
                break;
            case R.id.btnQR:
                IntentIntegrator integrator = new IntentIntegrator(this);
                integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
                integrator.setPrompt("Coloque un código QR en el interior del rectángulo del visor para escanear.");
                integrator.setCameraId(0);  // Use a specific camera of the device
                integrator.setBeepEnabled(false);
                integrator.setBarcodeImageEnabled(true);
                integrator.initiateScan();
                break;
            default: return;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {
            if (result.getContents() == null) {
                //Toast.makeText(this, "Cancelled", Toast.LENGTH_LONG).show();
                Log.i("HomeActivity", "Cancelled QR");
            } else {
                //Toast.makeText(this, "Scanned: " + result.getContents(), Toast.LENGTH_LONG).show();
                //Comunicacion.getInstance(getApplicationContext()).abrirNavegador(result.getContents());
                UserData.setDataCore("1");
                Intent intent = new Intent(getApplicationContext(), AnimalActivity.class);
                startActivity(intent);
                Log.i("HomeActivity", "Scanned: " + result.getContents());
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

}
