package com.example.languagelearningapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {

    private Context context;
    private ArrayList<Word> words;

    public WordAdapter(Context context, ArrayList<Word> words) {
        super(context, 0, words);
        this.context = context;
        this.words = words;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.word_item, parent, false);

        }

        Word word = words.get(position);

        TextView wordTextView = convertView.findViewById(R.id.wordTextView);
        TextView translationTextView = convertView.findViewById(R.id.translationTextView);

        wordTextView.setText(word.getWord());
        translationTextView.setText(word.getTranslation());

        return convertView;
    }
}
