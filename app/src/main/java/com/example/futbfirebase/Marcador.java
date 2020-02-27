package com.example.futbfirebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.example.futbfirebase.models.ModelMarcador;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import static android.content.ContentValues.TAG;

public class Marcador extends AppCompatActivity {
    private DatabaseReference mDatabase;
    private Adaptador adaptador;
    private RecyclerView recyclerView;

    private ArrayList<ModelMarcador> modelMarcadorsU = new ArrayList<>();
    private ArrayList<ModelMarcador> modelMarcadorsP = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marcador);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        getUsers();
    }

    private void getUsers(){
        mDatabase = FirebaseDatabase.getInstance().getReference();
        mDatabase.child("Marcadores").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot ds : dataSnapshot.getChildren()){
                    String user = ds.child("usuario").getValue().toString();
                    String puntosM = ds.child("puntos").getValue().toString();
                    modelMarcadorsU.add(new ModelMarcador(user));
                    modelMarcadorsP.add(new ModelMarcador(puntosM));
                }
                adaptador = new Adaptador(modelMarcadorsU,modelMarcadorsP,R.layout.item);
                recyclerView.setAdapter(adaptador);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void douc(){
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("users")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d(TAG, document.getId() + " => " + document.getData());
                            }
                        } else {
                            Log.w(TAG, "Error getting documents.", task.getException());
                        }
                    }
                });
    }
}
