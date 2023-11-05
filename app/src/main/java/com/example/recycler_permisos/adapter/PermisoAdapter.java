package com.example.recycler_permisos.adapter;


import static androidx.core.content.ContextCompat.startActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;


import com.example.recycler_permisos.MainActivity;
import com.example.recycler_permisos.R;
import com.example.recycler_permisos.models.Permiso;

import java.util.List;

public class PermisoAdapter extends RecyclerView.Adapter<PermisoAdapter.ViewHolder>{
    private List<Permiso> LP;

    public PermisoAdapter(List<Permiso> LP) {
        this.LP = LP;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.permisoitem, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PermisoAdapter.ViewHolder holder, int position) {
        holder.setData(LP.get(position));
    }

    @Override
    public int getItemCount() {
        return LP.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements ActivityCompat.OnRequestPermissionsResultCallback {
        TextView txPermiso;
        Switch swPermiso;
        Permiso permisoH;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txPermiso = itemView.findViewById(R.id.tvPermiso);
            swPermiso = itemView.findViewById(R.id.swPermiso);
        }

        public void setData(Permiso permiso) {
            permisoH = permiso;
            txPermiso.setText(permiso.getDescripcion());

            swPermiso.setOnCheckedChangeListener((buttonView, isChecked) -> {
                if(isChecked) {
                    if(ContextCompat.checkSelfPermission(itemView.getContext(), permiso.getNombre()) == PackageManager.PERMISSION_DENIED) {
                        ActivityCompat.requestPermissions((MainActivity) itemView.getContext(), new String[]{permiso.getNombre()}, 1987);
                    } else {
                        LP.remove(permisoH);
                    }
                }
            });
        }


        @Override
        public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
            if(requestCode == 1987) {
                if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    LP.remove(permisoH);
                    notifyDataSetChanged();
                }
            }
        }







    }
}
