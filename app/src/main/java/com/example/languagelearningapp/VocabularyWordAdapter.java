package com.example.languagelearningapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.ArrayList;

public class VocabularyWordAdapter extends ArrayAdapter<VocabularyWord> {

    private Context context;
    private ArrayList<VocabularyWord> vocabularyWords;

    public VocabularyWordAdapter(Context context, ArrayList<VocabularyWord> vocabularyWords) {
        super(context, 0, vocabularyWords);
        this.context = context;
        this.vocabularyWords = vocabularyWords;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.word_item, parent, false);
        }

        VocabularyWord vocabularyWord = vocabularyWords.get(position);

        TextView wordTextView = convertView.findViewById(R.id.wordTextView);
        TextView translationTextView = convertView.findViewById(R.id.translationTextView);

        wordTextView.setText(vocabularyWord.getWord());
        translationTextView.setText(vocabularyWord.getTranslation());

        return convertView;
    }
}
