package com.example.todoapp.notes;

import android.database.Cursor;

public interface NotesContract {
    interface View{
        void populateList(Cursor cursor);
    }
    interface Presenter{
        void activityCreated();
    }
}
