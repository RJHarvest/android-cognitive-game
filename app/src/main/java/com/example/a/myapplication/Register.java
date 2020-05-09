package com.example.a.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity implements View.OnClickListener{
    private Button btnRegister;
    private EditText name, email, username, password, password2;
    private String txtName, txtEmail, txtUsername, txtPassword, txtPassword2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        btnRegister = (Button) findViewById(R.id.registerBtn);
        name = (EditText) findViewById(R.id.etName);
        email = (EditText) findViewById(R.id.etEmail);
        username = (EditText) findViewById(R.id.etUsername);
        password = (EditText) findViewById(R.id.etPassword);
        password2 = (EditText) findViewById(R.id.etPassword2);
        btnRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        txtName = name.getText().toString();
        txtEmail = email.getText().toString();
        txtUsername = username.getText().toString();
        txtPassword = password.getText().toString();
        txtPassword2 = password2.getText().toString();

        Boolean check = txtName.matches("") || txtEmail.matches("") || txtUsername.matches("") ||
                        txtPassword.matches("") || txtPassword2.matches("");

        if (check){
            Toast.makeText(this, "Please complete the form!", Toast.LENGTH_SHORT).show();
        }else{
            if (!android.util.Patterns.EMAIL_ADDRESS.matcher(txtEmail).matches()){
                Toast.makeText(this, "Invalid email address!", Toast.LENGTH_SHORT).show();
            }else if (!txtPassword.matches(txtPassword2)){
                Toast.makeText(this, "Password does not match!", Toast.LENGTH_SHORT).show();
            }else{
                Intent register = new Intent(this, Login.class);
                startActivity(register);
            }
        }
    }
}
