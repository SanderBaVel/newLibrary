package com.example.newlibrary.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newlibrary.Adapter.BookListAdapter;
import com.example.newlibrary.Adapter.FiltroListAdapter;
import com.example.newlibrary.Domain.BookAllDomain;
import com.example.newlibrary.R;
import com.example.newlibrary.db.DbLibros;

import java.util.ArrayList;
import java.util.stream.Collectors;


public class Home extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;

    private RecyclerView recyclerViewBook;
    private RecyclerView recyclerViewFilter;
    private TextView verTodo;
    private EditText buscar;
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
        verTodo = view.findViewById(R.id.verTodo);
        buscar = view.findViewById(R.id.buscador);
        buscar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                DbLibros dbLibros = new DbLibros(getContext());
                ArrayList<BookAllDomain> items = new ArrayList<>(dbLibros.mostrarLibros());
                String userFilter = charSequence.toString();
                ArrayList<BookAllDomain> itemsFiltrados = items.stream()
                        .filter(nombre -> nombre.getNombre().toLowerCase().contains(userFilter))
                        .collect(Collectors.toCollection(ArrayList::new));
                BookListAdapter bookListAdapter =new BookListAdapter(itemsFiltrados);
                recyclerViewBook=view.findViewById(R.id.view1);
                recyclerViewBook.setAdapter(bookListAdapter);
            }
            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        verTodo.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), SeeAll.class);
                startActivity(intent);
            }
        });
        initRecyclerView(view);
        return view;
    }
    private void initRecyclerView(View view) {
        DbLibros dbLibros = new DbLibros(getContext());

        recyclerViewBook=view.findViewById(R.id.view1);
        recyclerViewBook.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        BookListAdapter adapter = new BookListAdapter(dbLibros.mostrarLibros());
        recyclerViewBook.setAdapter(adapter);

        //------------- reciclar boton filtro------------
        recyclerViewFilter=view.findViewById(R.id.viewFiltros);
        recyclerViewFilter.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        FiltroListAdapter adapterl = new FiltroListAdapter(dbLibros.filtroEtiquetas());
        recyclerViewFilter.setAdapter(adapterl);
    }
}