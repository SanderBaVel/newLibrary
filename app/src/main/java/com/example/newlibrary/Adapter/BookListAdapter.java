package com.example.newlibrary.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newlibrary.Activity.ReadBook;
import com.example.newlibrary.Domain.BookAllDomain;
import com.example.newlibrary.R;

import java.util.ArrayList;

public class BookListAdapter extends RecyclerView.Adapter<BookListAdapter.ViewHolder> {
    ArrayList<BookAllDomain> items;
    Context context;

    public BookListAdapter(ArrayList<BookAllDomain> items) {
        this.items = items;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_book_list, parent, false);
        context = parent.getContext();
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.autor.setText(items.get(position).getAutor());
        holder.tituloTxt.setText(items.get(position).getNombre());
        holder.etiqueta.setText(items.get(position).getEtiqueta());
        String nombre = items.get(position).getNombre();

        holder.pic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickRead(nombre);
            }
        });

        //int drawableResourceId=holder.itemView.getResources().getIdentifier(items.get(position).getPicUrl(),"drawable",holder.itemView.getContext().getPackageName());

        //Glide.with(holder.itemView.getContext())
          //      .load(drawableResourceId)
            //    .transform(new GranularRoundedCorners(30,30,0,0))
              //  .into(holder.pic);
    }
    public void onClickRead(String nombre){
        Intent intent = new Intent(context, ReadBook.class);
        intent.putExtra("nombreLibro", nombre);
        context.startActivity(intent);
    }

    @Override
    public int getItemCount() {

        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tituloTxt, autor, etiqueta;
        ImageView pic;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tituloTxt = itemView.findViewById(R.id.tituloTxt);
            autor = itemView.findViewById(R.id.autor);
            etiqueta = itemView.findViewById(R.id.etiqueta);
            pic = itemView.findViewById(R.id.pic);
        }
    }
}
