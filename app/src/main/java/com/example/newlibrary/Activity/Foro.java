package com.example.newlibrary.Activity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.newlibrary.Adapter.ForoListAdapter;
import com.example.newlibrary.Domain.ForoDomain;
import com.example.newlibrary.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Foro extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String user ="Sander";
    private String url ="http://192.168.100.131/api-rest/insert.php";
    //RecyclerView verMensajes;
    EditText texto;
    ImageView send;
    Context context;
    private RecyclerView recyckerViewForo;
    private RecyclerView.Adapter adapterForo;

    private String mParam1;
    private String mParam2;

    public Foro() {
        // Required empty public constructor
    }
    public static Foro newInstance(String param1, String param2) {
        Foro fragment = new Foro();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_foro, container, false);
        send = view.findViewById(R.id.Send);
        texto = view.findViewById(R.id.buscador);
       // verMensajes = view.findViewById(R.id.verMensajes);
        context = getContext();

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RequestQueue queue = Volley.newRequestQueue(context);
                StringRequest request= new StringRequest(Request.Method.POST, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                texto.setText("");
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(context, "Error " + error, Toast.LENGTH_LONG).show();
                            }
                        })
                {
                    @Override
                    protected Map<String, String> getParams(){
                        Map<String, String> parametros = new HashMap<>();
                        parametros.put("username", user);
                        parametros.put("pregunta", texto.getText().toString());
                        return parametros;
                    }
                };

                queue.add(request);

            }
        });
        initRecycler(view);
        return view;

    }
    public void initRecycler(View view){
        ArrayList<ForoDomain> itemss = new ArrayList<>();
        Context context = getContext();
        Respuesta(context,itemss);
        recyckerViewForo = view.findViewById(R.id.verMensajes);
        recyckerViewForo.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        adapterForo = new ForoListAdapter(itemss);
        recyckerViewForo.setAdapter(adapterForo);
    }
    public void Respuesta(Context context, ArrayList<ForoDomain> foroDomains){
        RequestQueue queue = Volley.newRequestQueue(context);
        String url ="http://192.168.100.131/api-rest/foro.php";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        JSONArray jsonArray;
                        try {
                            jsonArray = response.getJSONArray("data");
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject jsonObject = jsonArray.getJSONObject(i);

                                foroDomains.add(new ForoDomain(
                                        jsonObject.getString("username"),
                                        jsonObject.getString("pregunta")));
                            }adapterForo.notifyDataSetChanged();
                        } catch (JSONException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        queue.add(jsonObjectRequest);
    }
}