package com.example.applibri.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.BaseAdapter;

import com.example.applibri.Models.Libro;
import com.example.applibri.ReviewActivity;
import com.example.applibri.R;

import java.util.ArrayList;

public class BookAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Libro> listaLibri;

    public BookAdapter(Context context, ArrayList<Libro> listaLibri) {
        this.context = context;
        this.listaLibri = listaLibri;
    }

    @Override
    public int getCount() {
        return listaLibri.size();
    }

    @Override
    public Object getItem(int position) {
        return listaLibri.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.rowitem_book, parent, false);
        }

        TextView titleTextView = convertView.findViewById(R.id.textViewTitle);
        TextView authorTextView = convertView.findViewById(R.id.textViewAuthor);
        Button reviewButton = convertView.findViewById(R.id.buttonReview);
        RatingBar ratingBar = convertView.findViewById(R.id.ratingBar);

        Libro libro = listaLibri.get(position);
        titleTextView.setText(libro.getTitolo());
        authorTextView.setText(libro.getAutore());
        ratingBar.setRating(libro.getValutazione());

        reviewButton.setOnClickListener(v -> {
            Intent intent = new Intent(context, ReviewActivity.class);
            intent.putExtra("book_title", libro.getTitolo());
            context.startActivity(intent);
        });

        return convertView;
    }
}
