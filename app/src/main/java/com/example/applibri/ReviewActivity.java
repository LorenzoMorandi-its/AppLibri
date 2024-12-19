package com.example.applibri;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class ReviewActivity extends AppCompatActivity {

    private EditText reviewEditText;
    private Button submitButton;
    private RatingBar ratingBar;
    private String bookTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);

        reviewEditText = findViewById(R.id.editTextReview);
        submitButton = findViewById(R.id.buttonSubmit);
        ratingBar = findViewById(R.id.ratingBar);

        bookTitle = getIntent().getStringExtra("book_title");

        submitButton.setOnClickListener(v -> {
            String review = reviewEditText.getText().toString();
            float rating = ratingBar.getRating();

            if (!review.isEmpty()) {
                // Passa recensione e valutazione
                Intent resultIntent = new Intent();
                resultIntent.putExtra("recensione", review);
                resultIntent.putExtra("rating", rating);
                setResult(RESULT_OK, resultIntent);
                Toast.makeText(this, "Recensione inviata per " + bookTitle, Toast.LENGTH_SHORT).show();
                finish();
            } else {
                Toast.makeText(this, "Inserisci una recensione", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
