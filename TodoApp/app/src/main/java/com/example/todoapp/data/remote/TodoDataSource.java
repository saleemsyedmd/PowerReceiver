package com.example.todoapp.data.source;

import android.database.Cursor;

import com.example.todoapp.data.TodoNote;

public interface TodoDataSource {

    void getTodoNote(GetTodoNote callback);
    void setData(TodoNote note);
    void getNotes(GetNotes callback);



    interface GetTodoNote {

        void onNoteLoaded(TodoNote note);

        void onDataNotAvailable();
    }

    interface GetNotes {

        void onNotesLoaded(Cursor cursor);

    }
}
