package com.example.newlibrary.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newlibrary.Domain.ForoDomain;
import com.example.newlibrary.R;

import java.util.ArrayList;

public class ForoListAdapter extends RecyclerView.Adapter<ForoListAdapter.ViewHolder> {
    ArrayList<ForoDomain> items;
    Context context;

    public ForoListAdapter(ArrayList<ForoDomain> items) {
        this.items = items;
        //notifyDataSetChanged();

    }
    @NonNull
    @Override
    public ForoListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.mensaje_foro, parent, false);
        context = parent.getContext();
        return new ForoListAdapter.ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ForoListAdapter.ViewHolder holder, int position) {
        holder.mensaje.setText(items.get(position).getPregunta());
        holder.usuario.setText(items.get(position).getUsername());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView mensaje, usuario;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mensaje = itemView.findViewById(R.id.mensaje);
            usuario = itemView.findViewById(R.id.userNameForo);
        }
    }
}
