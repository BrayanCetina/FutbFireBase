package com.example.futbfirebase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView txtUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtUser = findViewById(R.id.txtCorreo);
    }
    public void cancha (View view){
        Intent cancha = new Intent(this, cancha.class);
        cancha.putExtra("user",txtUser.getText().toString());
        startActivity(cancha);
        finish();
    }
}
