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

    // Variables for progress bar
    private ProgressBar progressBar;
    private TextView textViewPercentage;
    private Map<String, Integer> pagineLetteGiornaliere;
    private int obiettivoSettimanale = 350; // Example: 350 pages per week

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize ListView
        listView = findViewById(R.id.listView);
        listaLibri = new ArrayList<>();

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
        listaLibri.add(new Libro("Il barone rampante", "Italo Calvino", "La storia di un uomo che vive sugli alberi", 400));
        listaLibri.add(new Libro("La montagna incantata", "Thomas Mann", "Un romanzo sulla malattia e la morte", 720));
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


        // Set the adapter to the ListView
        adapter = new BookAdapter(this, listaLibri);
        listView.setAdapter(adapter);

        // Initialize ProgressBar and TextView
        progressBar = findViewById(R.id.progressBar);
        textViewPercentage = findViewById(R.id.textViewPercentage);

        // Initialize the map with the days of the week
        pagineLetteGiornaliere = new HashMap<>();
        String[] giorni = {"Lunedì", "Martedì", "Mercoledì", "Giovedì", "Venerdì", "Sabato", "Domenica"};
        for (String giorno : giorni) {
            pagineLetteGiornaliere.put(giorno, 0);
        }

        // Example: Update pages read for some days
        aggiornaPagineLette("Lunedì", 50);
        aggiornaPagineLette("Martedì", 30);
        // Add other updates as needed

        // Calculate and update progress
        aggiornaProgresso();
    }

    // Method to update pages read for a specific day
    private void aggiornaPagineLette(String giorno, int pagine) {
        if (pagineLetteGiornaliere.containsKey(giorno)) {
            pagineLetteGiornaliere.put(giorno, pagine);
        }
    }

    // Method to calculate and update the progress based on pages read
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
