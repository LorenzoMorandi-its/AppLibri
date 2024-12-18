package com.example.applibri;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
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
    private int obiettivoSettimanale = 350; // Ad esempio, 350 pagine a settimana

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inizializza i componenti UI
        listView = findViewById(R.id.listView);
        progressBar = findViewById(R.id.progressBar);
        textViewPercentage = findViewById(R.id.textViewPercentage);

        // Popola la lista di libri
        listaLibri = new ArrayList<>();
        listaLibri.add(new Libro("Il nome della rosa", "Umberto Eco", "Un giallo storico", 500));
        listaLibri.add(new Libro("1984", "George Orwell", "Un distopico capolavoro", 328));
        // Aggiungi altri libri come necessario

        // Configura l'adapter
        adapter = new BookAdapter(this, listaLibri);
        listView.setAdapter(adapter);

        // Inizializza la mappa con i giorni della settimana
        pagineLetteGiornaliere = new HashMap<>();
        String[] giorni = {"Lunedì", "Martedì", "Mercoledì", "Giovedì", "Venerdì", "Sabato", "Domenica"};
        for (String giorno : giorni) {
            pagineLetteGiornaliere.put(giorno, 0);
        }

        // Esempio: Aggiorna le pagine lette per alcuni giorni
        aggiornaPagineLette("Lunedì", 50);
        aggiornaPagineLette("Martedì", 30);
        // Aggiungi altre chiamate a aggiornaPagineLette() secondo necessità

        // Calcola e aggiorna il progresso
        aggiornaProgresso();
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
}
