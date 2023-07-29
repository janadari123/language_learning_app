package com.example.languagelearningapp;

public class Word {

    private long id;
    private String word;
    private String translation;

    public Word(String word, String translation) {
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

