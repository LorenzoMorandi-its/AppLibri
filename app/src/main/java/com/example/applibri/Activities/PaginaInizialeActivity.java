package com.example.applibri.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.example.applibri.R;

public class PaginaInizialeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagina_iniziale);

        Button btnRegistrati = findViewById(R.id.button_registrati);
        Button btnAccedi = findViewById(R.id.button_accedi);

        btnRegistrati.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PaginaInizialeActivity.this, RegistrazioneActivity.class);
                startActivity(intent);
            }
        });

        btnAccedi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PaginaInizialeActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}
