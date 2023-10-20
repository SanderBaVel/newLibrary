package com.example.newlibrary.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newlibrary.Adapter.BookListAdapter;
import com.example.newlibrary.Domain.BookDomain;
import com.example.newlibrary.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
private RecyclerView.Adapter adapterBookList;
private RecyclerView recyclerViewBook;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initRecycleView();
    }
    ImageView dowloal, user, seeAll;

    private void initRecycleView() {
        ArrayList<BookDomain> items = new ArrayList<>();
        items.add(new BookDomain("smoke and mirrors","albun","imagine","desconocido","portada1",0));
        items.add(new BookDomain("ejemplo 2","ejemplo 2","ejemplo 2","ejemplo 2","portada2",0));
        items.add(new BookDomain("ejemplo 3","ejemplo 3","ejemplo 3","ejemplo 3","portada3",0));

        recyclerViewBook=findViewById(R.id.view1);
        recyclerViewBook.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        adapterBookList=new BookListAdapter(items);
        recyclerViewBook.setAdapter(adapterBookList);
    }
    //metodos para redirijir
    public void Dowload(View view){
        Intent dowload = new Intent(this, Download.class);
        startActivity(dowload);
    }
    public void SeeAll(View view){
        Intent seeAll = new Intent(this, SeeAll.class);
        startActivity(seeAll);
    }
    public void UserInf(View view){
        Intent userInf = new Intent(this, UserInfo.class);
        startActivity(userInf);
    }

}