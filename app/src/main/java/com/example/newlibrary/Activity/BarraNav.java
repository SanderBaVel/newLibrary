package com.example.newlibrary.Activity;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.newlibrary.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class BarraNav extends AppCompatActivity{
    Download download = new Download();
    Foro foro = new Foro();
    Home home = new Home();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barra_nav);
        BottomNavigationView navigacion=findViewById(R.id.botom_navigacion);
        navigacion.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        loadFragment(home);
    }
    private final BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.downloal) {
                    loadFragment(download);
                    return true;
                } else if (item.getItemId() == R.id.foro) {
                    loadFragment(foro);
                    return true;
                } else if (item.getItemId() == R.id.homep) {
                    loadFragment(home);
                    return true;
            }
            return false;
        }
    };
    private void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_conteiner, fragment);
        transaction.commit();
    }
}