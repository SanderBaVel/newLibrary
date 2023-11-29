package com.example.newlibrary.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newlibrary.Domain.BookAllDomain;
import com.example.newlibrary.Domain.DownloadDomain;
import com.example.newlibrary.R;
import com.example.newlibrary.Reponse.RespuestaDescarga;
import com.example.newlibrary.db.DbLibros;

import java.util.ArrayList;

public class DownloadListAdapter extends RecyclerView.Adapter<DownloadListAdapter.ViewHolder> {

    ArrayList<DownloadDomain> items;
    ArrayList<BookAllDomain> itemsDesc;

    Context context;
    public DownloadListAdapter(ArrayList<DownloadDomain> items) {
        this.items = items;
    }
    @NonNull
    @Override
    public DownloadListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.book_list_dowload, parent, false);
        context = parent.getContext();
        return new ViewHolder(inflate);
    }
    @Override
    public void onBindViewHolder(@NonNull DownloadListAdapter.ViewHolder holder, int position) {
        holder.nombre.setText(items.get(position).getTitulolb());
        holder.correo.setText(items.get(position).getAutor());
        String sendName= items.get(position).getTitulolb();
        String sendAutor= items.get(position).getAutor();
        String sendEdit = items.get(position).getMateria();
        String sendEtiqueta = items.get(position).getMateria();
        holder.desc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                descargar(sendName,sendAutor,sendEdit,sendEtiqueta);
            }
        });
    }
    private void descargar(String Name, String Autor,String Edit,String Etiqueta) {
        RespuestaDescarga respuestaDescarga = new RespuestaDescarga();
        respuestaDescarga.descargarLibro(context ,Name);
        save(Name,Autor,Edit,Etiqueta);
    }
    private void save(String Name, String Autor, String Editorial, String Etiqueta){
        DbLibros dbLibros = new DbLibros(context);
        long id = dbLibros.insertaLibro(Name, Autor, Etiqueta, Editorial);
        if (id > 0){
            Toast.makeText(context, "datos guardado correctamente",Toast.LENGTH_LONG).show();
        }else {Toast.makeText(context, "error al guardar datos", Toast.LENGTH_LONG).show();
        }

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nombre, correo;
        ImageView desc;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.txtCorreo);
            correo = itemView.findViewById(R.id.txtNombre);
            desc = itemView.findViewById(R.id.dowloadApi);
        }

    }
}
