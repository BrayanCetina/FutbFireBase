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

import androidx.recyclerview.widget.RecyclerView;

import java.io.InputStream;

public class Adaptador extends RecyclerView.Adapter {

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
