package com.example.newlibrary.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newlibrary.Domain.BookAllDomain;
import com.example.newlibrary.R;

import java.util.ArrayList;

public class FiltroListAdapter extends RecyclerView.Adapter<FiltroListAdapter.ViewHolder>{
    ArrayList<BookAllDomain> items;
    Context context;
    public FiltroListAdapter(ArrayList<BookAllDomain> items){this.items = items;}

    @NonNull
    @Override
    public FiltroListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.boton_filtro, parent, false);
        context = parent.getContext();
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull FiltroListAdapter.ViewHolder holder, int position) {
        holder.etiquetas.setText(items.get(position).getFiltroEtiqueta());
        String nameEtiqueta = items.get(position).getFiltroEtiqueta();

        holder.etiquetas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, nameEtiqueta, Toast.LENGTH_SHORT).show();
                // Cambiar el color del TextView actual
                TextView currentTextView = (TextView) view;
            }
        });
    }
    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView etiquetas;
        private TextView lastClick;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            etiquetas = itemView.findViewById(R.id.filtro_libros);
            lastClick = itemView.findViewById(R.id.filtro_libros_change);
        }
    }
}
