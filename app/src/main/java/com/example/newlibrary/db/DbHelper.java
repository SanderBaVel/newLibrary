package com.example.newlibrary.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION =3;
    private static final String DATABASE_NOMBRE= "biblioteca.db";
    public static final String TABLE_LIBROS = "libros";
    public static final String TABLE_DESCARGA = "descarga";
    public static final String TABLE_USUARIO = "usuario";
    public static final String TABLE_FORO="foro";

    public DbHelper(@Nullable Context context) {
        super(context, DATABASE_NOMBRE, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_LIBROS + "(" +
                "id_libros INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nombre TEXT NOT NULL," +
                "autor TEXT NOT NULL," +
                "etiqueta TEXT NOT NULL, " +
                "editorial TEXT NOT NULL)");

        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_DESCARGA + "(" +
                "id_descarga INTEGER PRIMARY KEY AUTOINCREMENT," +
                "id_libros INTEGER NOT NULL," +
                "id_usuario integer NOT NULL," +
                "fecha DATE NOT NULL," +
                "FOREIGN KEY (id_libros) REFERENCES " + TABLE_LIBROS + "(id_libros))");

        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_USUARIO + "(" + "id_usuario INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nombre TEXT NOT NULL," +
                "apellido TEXT NOT NULL," +
                "correo TEXT NOT NULL," +
                "usuario TEXT NOT NULL," +
                "contraseña TEXT NOT NULL)");

        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_FORO + "(" +
                "id_pregunta INTEGER PRIMARY KEY," +
                "id_usuario INTEGER NOT NULL," +
                "pregunta TEXT NOT NULL," +
                "FOREIGN KEY (id_usuario) REFERENCES " + TABLE_USUARIO + "(id_usuario))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE " + TABLE_LIBROS + TABLE_DESCARGA + TABLE_USUARIO + TABLE_FORO);
        onCreate(sqLiteDatabase);
    }
}
