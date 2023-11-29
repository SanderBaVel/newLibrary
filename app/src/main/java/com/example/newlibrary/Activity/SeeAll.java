package com.example.newlibrary.Activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newlibrary.Adapter.SeeAllAdapter;
import com.example.newlibrary.Domain.BookAllDomain;
import com.example.newlibrary.R;
import com.example.newlibrary.db.DbLibros;

import java.util.ArrayList;

public class SeeAll extends AppCompatActivity {
    RecyclerView verTodoLibros;
    ArrayList<BookAllDomain> listBook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_all);

        verTodoLibros=findViewById(R.id.verTodoLibros);
        verTodoLibros.setLayoutManager(new LinearLayoutManager(this));
        DbLibros dbLibros = new DbLibros(SeeAll.this);
        listBook = new ArrayList<>();
        SeeAllAdapter adapter = new SeeAllAdapter(dbLibros.mostrarLibros());
        verTodoLibros.setAdapter(adapter);

    }
}