package com.example.recycler_permisos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;

import com.example.recycler_permisos.adapter.PermisoAdapter;
import com.example.recycler_permisos.models.Permiso;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rvPermisos = findViewById(R.id.rvPermisos);
        List<Permiso> ListaPermisos = new ArrayList<>();

        ListaPermisos.add(new Permiso(Manifest.permission.CALL_PHONE, "Llamar"));
        ListaPermisos.add(new Permiso(Manifest.permission.CAMERA, "Camara"));


        rvPermisos.setAdapter(new PermisoAdapter(ListaPermisos));
        rvPermisos.setLayoutManager(new LinearLayoutManager(this));
        rvPermisos.setHasFixedSize(true);
    }
}