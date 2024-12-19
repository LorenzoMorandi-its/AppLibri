package com.example.applibri;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ReviewActivity extends AppCompatActivity {

    private EditText reviewEditText;
    private Button submitButton;
    private String bookTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);




        reviewEditText = findViewById(R.id.editTextReview);
        submitButton = findViewById(R.id.buttonSubmit);

        bookTitle = getIntent().getStringExtra("book_title");

        submitButton.setOnClickListener(v -> {
            String review = reviewEditText.getText().toString();
            if (!review.isEmpty()) {
                Toast.makeText(this, "Recensione inviata per " + bookTitle, Toast.LENGTH_SHORT).show();
                finish();
            } else {
                Toast.makeText(this, "Inserisci una recensione", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
