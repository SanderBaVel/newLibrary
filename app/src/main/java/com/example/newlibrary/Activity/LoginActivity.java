package com.example.newlibrary.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.newlibrary.R;

public class LoginActivity extends AppCompatActivity {
    EditText user, pass;
    TextView iniciar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        user = findViewById(R.id.userName);
        pass = findViewById(R.id.TextPasswordLogin);
        iniciar = findViewById(R.id.loginMain);
        iniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Respuestas();
            }
        });
    }
    public void Logear(){
        Intent intent = new Intent(this, BarraNav.class);
        startActivity(intent);
        finish();
    }
    public void Respuestas(){
        String baseUrl ="http://192.168.137.1/api-rest/login.php";
        String inputUsername = user.getText().toString();
        String inputPassword = pass.getText().toString();
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = baseUrl + "?usuario=" + inputUsername + "&clave=" + inputPassword;
        StringRequest request = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Procesa la respuesta del servidor
                        if (response.trim().equals("Login exitoso")) {
                            Logear();
                        } else {
                            Toast.makeText(LoginActivity.this, "Inicio de sesión fallido", Toast.LENGTH_SHORT).show();
                            // Acción en caso de un inicio de sesión fallido
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // Manejo de errores
                        Toast.makeText(LoginActivity.this, "Error de conexión", Toast.LENGTH_SHORT).show();
                    }
                });

// Agrega la solicitud a la cola
        //RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(request);
    }
}