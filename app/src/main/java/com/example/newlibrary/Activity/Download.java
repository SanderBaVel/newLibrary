package com.example.newlibrary.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.newlibrary.R;

public class Download extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download);
    }
    public void Home(View view){
        Intent home = new Intent(this, MainActivity.class);
        startActivity(home);
    }
}