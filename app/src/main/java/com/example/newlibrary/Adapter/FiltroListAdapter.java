package com.example.newlibrary.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newlibrary.Domain.BookDomain;
import com.example.newlibrary.R;

import java.util.ArrayList;

public class FiltroListAdapter extends RecyclerView.Adapter<FiltroListAdapter.ViewHolder>{
    ArrayList<BookDomain> items;
    Context context;
    public FiltroListAdapter(ArrayList<BookDomain> items){this.items = items;}
    @NonNull
    @Override
    public FiltroListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.boton_filtro, parent, false);
        context = parent.getContext();
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull FiltroListAdapter.ViewHolder holder, int position) {
        holder.etiquetas.setText(items.get(position).getEtiqueta());
    }
    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView etiquetas;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            etiquetas = itemView.findViewById(R.id.filtro_libros);
        }
    }
}
