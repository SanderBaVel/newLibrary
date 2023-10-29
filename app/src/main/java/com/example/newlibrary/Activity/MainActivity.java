package com.example.newlibrary.Activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newlibrary.Adapter.BookListAdapter;
import com.example.newlibrary.Adapter.FiltroListAdapter;
import com.example.newlibrary.Domain.BookDomain;
import com.example.newlibrary.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
private RecyclerView.Adapter adapterBookList;
private RecyclerView.Adapter adapterFiltroList;
private RecyclerView recyclerViewBook;
private RecyclerView recyclerViewFilter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initRecycleView();
    }
    private void initRecycleView() {
        ArrayList<BookDomain> items = new ArrayList<>();
        items.add(new BookDomain("smoke and mirrors","albun","imagine","desconocido","portada1",0));
        items.add(new BookDomain("ejemplo 2","ejemplo 2","ejemplo 2","ejemplo 2","portada2",0));
        items.add(new BookDomain("ejemplo 3","ejemplo 3","ejemplo 3","ejemplo 3","portada3",0));

        recyclerViewBook=findViewById(R.id.view1);
        recyclerViewBook.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        adapterBookList=new BookListAdapter(items);
        recyclerViewBook.setAdapter(adapterBookList);

        //------------- reciclar boton filtro------------
        recyclerViewFilter=findViewById(R.id.viewFiltros);
        recyclerViewFilter.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));
        adapterFiltroList=new FiltroListAdapter(items);
        recyclerViewFilter.setAdapter(adapterFiltroList);
    }
}


