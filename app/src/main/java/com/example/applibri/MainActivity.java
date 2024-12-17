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
        listaLibri.add(new Libro("Il nome della rosa", "Umberto Eco", "Un giallo storico", 500));
        listaLibri.add(new Libro("1984", "George Orwell", "Un distopico capolavoro", 328));
        listaLibri.add(new Libro("I promessi sposi", "Alessandro Manzoni", "Un romanzo storico italiano", 720));
        listaLibri.add(new Libro("Moby Dick", "Herman Melville", "La caccia alla balena bianca", 635));
        listaLibri.add(new Libro("Orgoglio e pregiudizio", "Jane Austen", "Un romanzo sull'amore e le convenzioni sociali", 432));
        listaLibri.add(new Libro("Il grande Gatsby", "F. Scott Fitzgerald", "Un ritratto della società americana degli anni '20", 180));
        listaLibri.add(new Libro("Delitto e castigo", "Fëdor Dostoevskij", "Un'esplorazione della moralità e della redenzione", 671));
        listaLibri.add(new Libro("Cime tempestose", "Emily Brontë", "Una storia di amore e vendetta", 416));
        listaLibri.add(new Libro("Il processo", "Franz Kafka", "Un'analisi dell'assurdità della burocrazia", 304));
        listaLibri.add(new Libro("Il conte di Montecristo", "Alexandre Dumas", "Una storia di vendetta e redenzione", 1276));
        listaLibri.add(new Libro("La divina commedia", "Dante Alighieri", "Un viaggio allegorico nell'aldilà", 798));
        listaLibri.add(new Libro("Ulisse", "James Joyce", "Un'odissea moderna nella vita di Dublino", 730));
        listaLibri.add(new Libro("Don Chisciotte della Mancia", "Miguel de Cervantes", "Le avventure di un cavaliere idealista", 1072));
        listaLibri.add(new Libro("Madame Bovary", "Gustave Flaubert", "La tragedia di una donna insoddisfatta", 329));
        listaLibri.add(new Libro("Il rosso e il nero", "Stendhal", "L'ambizione e l'amore nella Francia post-napoleonica", 576));

        // Configura l'adapter
        adapter = new BookAdapter(this, listaLibri);
        listView.setAdapter(adapter);
    }
}
