package com.example.applibri;

import android.os.Bundle;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.applibri.Adapter.BookAdapter;
import com.example.applibri.Models.Libro;
import com.example.applibri.R;

import java.util.ArrayList;

;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayList<Libro> listaLibri;
    private BookAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Configurazione Toolbar
        //Toolbar toolbar = findViewById(R.id.Toolbar);
        //setSupportActionBar(toolbar);

        // Inizializza la ListView
        listView = findViewById(R.id.listView);

        // Popola la lista di libri
        listaLibri = new ArrayList<>();
        listaLibri.add(new Libro("Il nome della rosa", "Umberto Eco", "Un giallo storico", 500));
        listaLibri.add(new Libro("1984", "George Orwell", "Un distopico capolavoro", 328));
        listaLibri.add(new Libro("I promessi sposi", "Alessandro Manzoni", "Un romanzo storico italiano", 720));
        listaLibri.add(new Libro("Moby Dick", "Herman Melville", "La caccia alla balena bianca", 635));

        // Configura l'adapter
        adapter = new BookAdapter(this, listaLibri);
        listView.setAdapter(adapter);
    }
}
