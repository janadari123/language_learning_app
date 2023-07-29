package com.example.languagelearningapp;

public class VocabularyWord {

    private long id;
    private String word;
    private String translation;

    public VocabularyWord(String word, String translation) {
        this.word = word;
        this.translation = translation;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public String getTranslation() {
        return translation;
    }
}
