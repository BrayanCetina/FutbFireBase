package com.example.futbfirebase;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.futbfirebase.models.ModelMarcador;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Adaptador extends RecyclerView.Adapter <Adaptador.ViewHolder> {

    private int resource;
    private ArrayList<ModelMarcador> usuarios;
    private ArrayList<ModelMarcador> puntos;

    public Adaptador(ArrayList<ModelMarcador> usuarios,ArrayList<ModelMarcador> puntos, int resource){
        this.usuarios = usuarios;
        this.puntos = puntos;
        this.resource = resource;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(resource,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        ModelMarcador us = usuarios.get(position);
        ModelMarcador pt = puntos.get(position);

        viewHolder.User.setText(us.getTexto());
        viewHolder.Marcador.setText(pt.getTexto());
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public  class ViewHolder extends RecyclerView.ViewHolder{

        private TextView User;
        private TextView Marcador;

        public View view;

        public  ViewHolder (View view){
            super(view);

            this.view = view;
            this.User = (TextView) view.findViewById(R.id.tvTitulo);
            this.Marcador = (TextView) view.findViewById(R.id.tvContenido);
        }
    }

}
