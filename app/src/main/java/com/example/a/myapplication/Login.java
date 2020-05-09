package com.example.a.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity implements View.OnClickListener {
    TextView btnRegister;
    EditText username, password;
    Button btnLogin;
    String txtUsername, txtPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnRegister = (TextView) findViewById(R.id.registerBtn);
        username = (EditText) findViewById(R.id.etUsername);
        password = (EditText) findViewById(R.id.etPassword);
        btnLogin = (Button) findViewById(R.id.login);
        btnLogin.setOnClickListener(this);
        btnRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.login:
                txtUsername = username.getText().toString();
                txtPassword = password.getText().toString();

                if (txtUsername.equals("admin") && txtPassword.equals("admin")) {
                    Intent login = new Intent(this, GameMenu.class);
                    startActivity(login);
                } else {
                    Toast.makeText(this, "Invalid Username or Password", Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.registerBtn:
                Intent register = new Intent(this, Register.class);
                startActivity(register);
                break;
        }
    }
}
