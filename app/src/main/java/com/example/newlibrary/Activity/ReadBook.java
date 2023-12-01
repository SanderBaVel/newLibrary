
package com.example.newlibrary.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.newlibrary.R;
import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle;

import java.io.File;


public class ReadBook extends AppCompatActivity {
    private PDFView pdfView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_book);

        pdfView = findViewById(R.id.pdfView);
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("nombreLibro")) {
            String nombreLibro = intent.getStringExtra("nombreLibro");
            openPdf(nombreLibro);
        }

    }
    public void regresar(View view){
        Intent intent = new Intent(ReadBook.this, BarraNav.class);
        startActivity(intent);
    }
    public void openPdf(String name){
        // Verificar si la tarjeta SD está disponible
        String filePath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS) + "/" + name;

// Verificar si el archivo existe
        File file = new File(filePath);
        if (file.exists()) {
            try {
                pdfView.fromFile(file)
                        .defaultPage(0)
                        .scrollHandle(new DefaultScrollHandle(this))
                        .spacing(10)
                        .load();
            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(this, "Error al abrir el archivo PDF.", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "El archivo no se encuentra en la carpeta de descargas.", Toast.LENGTH_SHORT).show();
        }

    }
}