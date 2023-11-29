package com.example.newlibrary.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newlibrary.Domain.BookAllDomain;
import com.example.newlibrary.R;
import com.example.newlibrary.db.DbLibros;

import java.util.ArrayList;

public class SeeAllAdapter extends RecyclerView.Adapter<SeeAllAdapter.ViewHolder> {
    ArrayList<BookAllDomain> items;
    Context context;
    public SeeAllAdapter(ArrayList<BookAllDomain> items){this.items = items;}
    @NonNull
    @Override
    public SeeAllAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.book_list_see_all, parent, false);
        context = parent.getContext();
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull SeeAllAdapter.ViewHolder holder, int position) {
        holder.nomb.setText(items.get(position).getNombre());
        holder.autor.setText(items.get(position).getAutor());
        //int id = items.get(position).getId();
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int adapterPosition = holder.getAdapterPosition();
                if (adapterPosition != RecyclerView.NO_POSITION && adapterPosition < items.size()) {
                    // Obtén el elemento actual
                    BookAllDomain itemToDelete = items.get(adapterPosition);

                    // Elimina el elemento de la lista
                    items.remove(adapterPosition);

                    // Notifica al adaptador que el conjunto de datos ha cambiado
                    notifyItemRemoved(adapterPosition);

                    // Elimina el elemento de la base de datos
                    deleteItemFromDatabase(itemToDelete);
                }

            }
        });
    }
    private void deleteItemFromDatabase(BookAllDomain itemToDelete) {

        DbLibros dbLibros = new DbLibros(context);

        dbLibros.borrarLibros(itemToDelete.getId(), context);
        // Asume que hay un método eliminarLibro en tu DbLibros
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nomb, autor;
        ImageView delete;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nomb = itemView.findViewById(R.id.txtNombred);
            autor = itemView.findViewById(R.id.txtAutor);
            delete = itemView.findViewById(R.id.delete);
        }
    }
}
