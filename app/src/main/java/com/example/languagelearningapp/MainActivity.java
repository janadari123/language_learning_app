package com.example.languagelearningapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText wordEditText, translationEditText;
    private Button addWordButton;
    private ListView wordListView;

    private WordAdapter wordAdapter;
    private ArrayList<Word> wordList;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wordEditText = findViewById(R.id.wordEditText);
        translationEditText = findViewById(R.id.translationEditText);
        addWordButton = findViewById(R.id.addWordButton);
        wordListView = findViewById(R.id.wordListView);

        wordList = new ArrayList<>();
        databaseHelper = new DatabaseHelper(this);

        wordAdapter = new WordAdapter(this, wordList);
        wordListView.setAdapter(wordAdapter);

        addWordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String word = wordEditText.getText().toString();
                String translation = translationEditText.getText().toString();

                Word newWord = new Word(word, translation);
                long wordId = databaseHelper.insertWord(newWord);

                if (wordId != -1) {
                    newWord.setId(wordId);
                    wordList.add(newWord);
                    wordAdapter.notifyDataSetChanged();

                    wordEditText.setText("");
                    translationEditText.setText("");
                }
            }
        });

        loadWords();
    }

    private void loadWords() {
        wordList.clear();
        wordList.addAll(databaseHelper.getAllWords());
        wordAdapter.notifyDataSetChanged();
    }
}
