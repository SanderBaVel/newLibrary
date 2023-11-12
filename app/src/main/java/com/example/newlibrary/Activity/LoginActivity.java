package com.example.newlibrary.Activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.newlibrary.R;

public class LoginActivity extends AppCompatActivity {
    EditText user, pass;
    String usernama="usuario1";
    String password ="12345";

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        user = findViewById(R.id.userName);
        pass = findViewById(R.id.TextPasswordLogin);
    }
    public void LogearOnClick(View view){
        String inputUsername = user.getText().toString();
        String inputPassword = pass.getText().toString();
        if (inputUsername.equals(usernama) && inputPassword.equals(password)){
            Intent intent = new Intent(this, BarraNav.class);
            startActivity(intent);
            finish();
        }else {
            Toast.makeText(this, "usuario y/o contraseñas incorrectas",Toast.LENGTH_SHORT).show();
        }
    }
}