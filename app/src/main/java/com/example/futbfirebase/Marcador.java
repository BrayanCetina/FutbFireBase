package com.example.futbfirebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import static android.content.ContentValues.TAG;

public class Marcador extends AppCompatActivity {

    ListView lista;
    String[] contenido;
    String[] titulo;
    String[] IMGS;
    String[] idas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marcador);
        lista = (ListView) findViewById(R.id.lvItems);
        validarUsuario();
    }
    private void validarUsuario() {
        //se envian los 3 parametros
        try {
            FirebaseFirestore db = FirebaseFirestore.getInstance();

            DocumentReference docRef = db.collection("Marcadores").document("SF");
            docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                    if (task.isSuccessful()) {
                        DocumentSnapshot document = task.getResult();
                        if (document.exists()) {
                            Log.d(TAG, "DocumentSnapshot data: " + document.getData());
                        } else {
                            Log.d(TAG, "No such document");
                        }
                    } else {
                        Log.d(TAG, "get failed with ", task.getException());
                    }
                }
            });

            JSONArray ja = new JSONArray(docRef);
            JSONObject jo = null;
            idas = new String[ja.length()];
            IMGS = new String[ja.length()];
            titulo = new String[ja.length()];
            contenido = new String[ja.length()];

            for (int i = 0; i < ja.length(); i++) {
                jo = ja.getJSONObject(i);
                idas[i] = jo.getString("id");
                IMGS[i] = jo.getString("url");
                titulo[i] = jo.getString("titulo");
                contenido[i] = jo.getString("contenido");
            }
            lista.setAdapter(new Adaptador(this, idas, IMGS,titulo,contenido));
        } catch (JSONException e) {
            e.getMessage();
        }
    }
}
