package com.runachaqui.runachaqui;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends Activity implements View.OnClickListener {
    private ImageButton btnRegister;
    private ImageButton btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnRegister = (ImageButton) findViewById(R.id.btnRegister);
        btnLogin = (ImageButton) findViewById(R.id.btnLogin);
        btnRegister.setOnClickListener(this);
        btnLogin.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        int id_button = view.getId();
        Intent intent;
        switch (id_button) {
            case R.id.btnRegister:
                intent = new Intent(this, RegisterActivity.class);
                startActivity(intent);
                break;
            case R.id.btnLogin:
                intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
                break;
            default:
                return;
        }
    }
}