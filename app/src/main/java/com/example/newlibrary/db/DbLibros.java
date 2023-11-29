package com.example.newlibrary.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.example.newlibrary.Domain.BookAllDomain;

import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;

public class DbLibros extends DbHelper{
    Context context;
    public DbLibros(@Nullable Context context){
        super(context);
        this.context = context;
    }
    public long insertaLibro(String nombre,String autor, String etiqueta,String editorial){
        long id = 0;
        try {
            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db= dbHelper.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("nombre", nombre);
            values.put("autor", autor);
            values.put("etiqueta", etiqueta);
            values.put("editorial", editorial);
            id = db.insert(TABLE_LIBROS, null, values);

        } catch (Exception ex){
            ex.toString();
        }
        return id;
    }
    public ArrayList<BookAllDomain> mostrarLibros(){
        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db =dbHelper.getWritableDatabase();

        ArrayList<BookAllDomain> books = new ArrayList<>();
        BookAllDomain bookAllDomain = null;
        Cursor cursor = null;

        cursor = db.rawQuery("SELECT * FROM "+TABLE_LIBROS,null);
        if (cursor.moveToFirst()){
            do {
                bookAllDomain = new BookAllDomain();
                bookAllDomain.setId(cursor.getInt(0));
                bookAllDomain.setNombre(cursor.getString(1));
                bookAllDomain.setAutor(cursor.getString(2));
                bookAllDomain.setEtiqueta(cursor.getString(3));
                bookAllDomain.setEditorial(cursor.getString(4));
                books.add(bookAllDomain);
            }while (cursor.moveToNext());
        }
        cursor.close();
        return books;
    }
    public void borrarLibros(int id, Context cont) {
        try {
            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            String clausula = "id_libros = ?";
            String[] args = {String.valueOf(id)};

            db.delete(TABLE_LIBROS, clausula, args);
        } catch (Exception e) {
            Toast.makeText(cont, e.toString(), Toast.LENGTH_SHORT).show();
        }
    }

    public ArrayList<BookAllDomain> filtroEtiquetas() {
        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ArrayList<BookAllDomain> books = new ArrayList<>();
        BookAllDomain bookAllDomain = null;
        Cursor cursor = null;

        cursor = db.rawQuery("SELECT DISTINCT etiqueta FROM " + TABLE_LIBROS, null);
        if (cursor.moveToFirst()){
            do {
                bookAllDomain = new BookAllDomain();
                bookAllDomain.setFiltroEtiqueta(cursor.getString(0));
                books.add(bookAllDomain);
            }while (cursor.moveToNext());
        }
        cursor.close();
        return books;
    }

}
