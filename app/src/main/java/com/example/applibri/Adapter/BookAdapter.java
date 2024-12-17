package com.example.applibri.Adapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.applibri.Models.Libro;
import com.example.applibri.R;

import java.util.ArrayList;
public class BookAdapter extends ArrayAdapter<Libro> {
    static class ViewHolder{
        TextView autoreTextView;
        TextView titoloTextView;
    }

    private LayoutInflater inflater;
    public BookAdapter(@NonNull Context context, @NonNull ArrayList<Libro> objects) {
        super(context, 0, objects);
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder;


        if (convertView == null) {
            convertView = inflater.inflate(R.layout.rowitem_book, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.autoreTextView = convertView.findViewById(R.id.autoreTextView);
            viewHolder.titoloTextView = convertView.findViewById(R.id.titoloTextView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Libro libro = getItem(position);
        if (libro != null) {
            viewHolder.autoreTextView.setText(libro.autore);
            viewHolder.titoloTextView.setText(libro.titolo);
        }

        return convertView;
    }
}

