package com.runachaqui.runachaqui;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class LoginActivity extends Activity implements View.OnClickListener{
    private EditText etUsername;
    private EditText etPassword;
    private ImageButton btnLoginActivity;
    private String username, password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etUsername = (EditText)findViewById(R.id.etUsername);
        etPassword = (EditText)findViewById(R.id.etPassword);
        btnLoginActivity = (ImageButton)findViewById(R.id.btnLoginActivity);
        btnLoginActivity.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        int id_button = view.getId();
        switch(id_button){
            case R.id.btnLoginActivity:
                username = etUsername.getText().toString();
                password = etPassword.getText().toString();

                if(username.compareTo("juancito")==0 && password.compareTo("1234") == 0){
                    Intent intent = new Intent(this, HomeActivity.class);
                    startActivity(intent);
                }
                break;
            default: return;
        }
    }
}
