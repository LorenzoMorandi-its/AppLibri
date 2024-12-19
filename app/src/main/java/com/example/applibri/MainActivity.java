package com.example.applibri;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import com.example.applibri.Adapter.BookAdapter;
import com.example.applibri.Models.Libro;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayList<Libro> listaLibri;
    private BookAdapter adapter;

    private ProgressBar progressBar;
    private TextView textViewPercentage;
    private Map<String, Integer> pagineLetteGiornaliere;
    private int obiettivoSettimanale = 350;


    private ActivityResultLauncher<Intent> reviewActivityLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        reviewActivityLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                        String recensione = result.getData().getStringExtra("recensione");
                        aggiungiRecensione(recensione);
                    }
                }
        );


        listView = findViewById(R.id.listView);
        listaLibri = new ArrayList<>();
        popolaListaLibri();

        adapter = new BookAdapter(this, listaLibri);
        listView.setAdapter(adapter);


        progressBar = findViewById(R.id.progressBar);
        textViewPercentage = findViewById(R.id.textViewPercentage);


        pagineLetteGiornaliere = new HashMap<>();
        inizializzaGiorni();
        aggiornaPagineLette("Lunedì", 50);
        aggiornaPagineLette("Martedì", 30);
        aggiornaProgresso();


         //Intent intent = new Intent(this, ReviewActivity.class);

        //reviewActivityLauncher.launch(intent);
    }

    private void popolaListaLibri() {
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

    }

    private void inizializzaGiorni() {
        String[] giorni = {"Lunedì", "Martedì", "Mercoledì", "Giovedì", "Venerdì", "Sabato", "Domenica"};
        for (String giorno : giorni) {
            pagineLetteGiornaliere.put(giorno, 0);
        }
    }

    private void aggiornaPagineLette(String giorno, int pagine) {
        if (pagineLetteGiornaliere.containsKey(giorno)) {
            pagineLetteGiornaliere.put(giorno, pagine);
        }
    }

    private void aggiornaProgresso() {
        int totalePagineLette = 0;
        for (int pagine : pagineLetteGiornaliere.values()) {
            totalePagineLette += pagine;
        }
        int percentuale = (int) ((totalePagineLette / (float) obiettivoSettimanale) * 100);
        progressBar.setProgress(percentuale);
        textViewPercentage.setText(percentuale + "%");
    }

    private void aggiungiRecensione(String recensione) {

        if (!listaLibri.isEmpty()) {
            listaLibri.get(0).setRecensione(recensione); // Assicurati che il metodo setRecensione esista nella classe Libro
        }
        adapter.notifyDataSetChanged();
    }
}
