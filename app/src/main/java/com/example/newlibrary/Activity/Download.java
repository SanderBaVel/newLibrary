package com.example.newlibrary.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.newlibrary.Adapter.DownloadListAdapter;
import com.example.newlibrary.Domain.DownloadDomain;
import com.example.newlibrary.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Download extends Fragment {

    private RecyclerView recyckerViewBookDownload;
    private RecyclerView.Adapter adapterBooksDownload;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public Download() {
        // Required empty public constructor
    }
    public static Download newInstance(String param1, String param2) {
        Download fragment = new Download();
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
        //-------------------permisos para almacenar libros en dispositivo-----------
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            if (!Environment.isExternalStorageManager()) {
                Intent intent = new Intent(Settings.ACTION_MANAGE_ALL_FILES_ACCESS_PERMISSION);
                startActivity(intent);
            }
        }
        //---------------inflar tarjetas de descarga--------------------
            View view = inflater.inflate(R.layout.fragment_download, container, false);
            initRecyclerView(view);
            return view;
    }
    private void initRecyclerView(View view) {

        ArrayList<DownloadDomain> items = new ArrayList<>();
        Context context = getContext();
        Respuestas(context,items);
        recyckerViewBookDownload = view.findViewById(R.id.verLibrosBd);
        recyckerViewBookDownload.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        adapterBooksDownload = new DownloadListAdapter(items);
        recyckerViewBookDownload.setAdapter(adapterBooksDownload);
    }
    public void Respuestas(Context context,ArrayList<DownloadDomain> downloadDomains){
        //Context context = requireContext();
        RequestQueue queue = Volley.newRequestQueue(context);
        String url ="http://192.168.100.131/api-rest/registros.php";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        JSONArray jsonArray;
                        try {
                            jsonArray = response.getJSONArray("data");
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject jsonObject = jsonArray.getJSONObject(i);

                                downloadDomains.add(new DownloadDomain(
                                        jsonObject.getInt("id"),
                                        jsonObject.getInt("volumen"),
                                        jsonObject.getString("carrera"),
                                        jsonObject.getString("materia"),
                                        jsonObject.getString("titulolb"),
                                        jsonObject.getString("autor")));
                            }adapterBooksDownload.notifyDataSetChanged();
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
