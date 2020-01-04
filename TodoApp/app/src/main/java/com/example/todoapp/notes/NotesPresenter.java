package com.example.todoapp.notes;

import android.database.Cursor;

import com.example.todoapp.data.source.TodoDataSource;
import com.example.todoapp.data.source.TodoRepository;

public class NotesPresenter implements NotesContract.Presenter, TodoDataSource.GetNotes {

    TodoDataSource repository;
    NotesContract.View view;

    public NotesPresenter(NotesActivity notesActivity) {
        repository = new TodoRepository(notesActivity);
        view = notesActivity;
    }

    @Override
    public void activityCreated() {
        repository.getNotes(this);

    }

    @Override
    public void onNotesLoaded(Cursor cursor) {
        view.populateList(cursor);
    }
}
