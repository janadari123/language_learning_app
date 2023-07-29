package com.example.languagelearningapp;

public class DatabaseContract {

    private DatabaseContract() {}

    public static class WordEntry {
        public static final String TABLE_NAME = "words";
        public static final String COLUMN_ID = "id";
        public static final String COLUMN_WORD = "word";
        public static final String COLUMN_TRANSLATION = "translation";
    }
}
