package com.example.newlibrary.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.newlibrary.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class FragmentNav extends Fragment {
    Foro foro=new Foro();
    Download download = new Download();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_barra_nav, container, false);
        BottomNavigationView navigation = view.findViewById(R.id.botom_navigacion);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        return view;
    }
    private final BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            if (item.getItemId() == R.id.downloal) {
                LoadFragments(download);
                return true;
            } else if (item.getItemId() == R.id.foro) {
                LoadFragments(foro);
                return true;
            } else if (item.getItemId() == R.id.homep) {
                startActivity(new Intent(getContext(), MainActivity.class));
                onDestroy();
                return true;
            }
            return false;
        }
    };
    public void LoadFragments(Fragment fragment) {
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_conteiner, fragment);
        transaction.commit();
    }
}

