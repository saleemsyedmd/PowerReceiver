package com.example.sqliteapp;

import android.provider.BaseColumns;

public final class TodoContract {
    private TodoContract(){

    }
    public static class TodoEntry implements BaseColumns {
        public static final String TABLE_NAME = "notes";
        public static final String COLUMN_NAME_TITLE = "title";
        public static final String COLUMN_NAME_SUBTITLE = "subtitle";
    }
}

