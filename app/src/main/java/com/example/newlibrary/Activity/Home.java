package com.example.newlibrary.Activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newlibrary.Adapter.BookListAdapter;
import com.example.newlibrary.Adapter.FiltroListAdapter;
import com.example.newlibrary.Domain.BookDomain;
import com.example.newlibrary.R;

import java.util.ArrayList;


public class Home extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;

    private RecyclerView.Adapter adapterBookList;
    private RecyclerView.Adapter adapterFiltroList;
    private RecyclerView recyclerViewBook;
    private RecyclerView recyclerViewFilter;

    public Home() {
        // Required empty public constructor
    }

    public static Home newInstance(String param1, String param2) {
        Home fragment = new Home();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        initRecyclerView(view);
        return view;
    }
    private void initRecyclerView(View view) {
        ArrayList<BookDomain> items = new ArrayList<>();
        items.add(new BookDomain("smoke and mirrors","albun","imagine","desconocido","portada1",0));
        items.add(new BookDomain("ejemplo 2","ejemplo 2","ejemplo 2","ejemplo 2","portada2",0));
        items.add(new BookDomain("ejemplo 3","ejemplo 3","ejemplo 3","ejemplo 3","portada3",0));

        recyclerViewBook=view.findViewById(R.id.view1);
        recyclerViewBook.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        adapterBookList=new BookListAdapter(items);
        recyclerViewBook.setAdapter(adapterBookList);

        //------------- reciclar boton filtro------------
        recyclerViewFilter=view.findViewById(R.id.viewFiltros);
        recyclerViewFilter.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL,false));
        adapterFiltroList=new FiltroListAdapter(items);
        recyclerViewFilter.setAdapter(adapterFiltroList);
    }
}