package com.example.todoapp.data.source.local;

import android.content.Context;

import com.example.todoapp.data.TodoNote;
import com.example.todoapp.data.source.TodoDataSource;

public class LocalDataSource implements TodoDataSource {

    DAO dao;

    public LocalDataSource(Context context) {
        dao = new DAO(context);
    }

    @Override
    public void getTodoNote(GetTodoNote callback) {
        dao.getTodoNote(callback);//cc
    }

    @Override
    public void setData(TodoNote note) {
        dao.openDb();
        dao.createRow(note.getTitle(),note.getSubtitle());
    }

    @Override
    public void getNotes(GetNotes callback) {
        dao.openDb();
        dao.getNotes(callback);
    }
}
