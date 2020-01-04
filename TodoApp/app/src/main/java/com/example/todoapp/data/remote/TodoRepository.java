package com.example.todoapp.data.source;

import android.content.Context;

import com.example.todoapp.data.TodoNote;
import com.example.todoapp.data.source.local.LocalDataSource;

/**
 * this class will get data either from localdb or remote db
 * based on the n/w connectivity
 */
public class TodoRepository implements TodoDataSource{

    TodoDataSource localTodoDataSource;

    public TodoRepository(Context context){
        localTodoDataSource = new LocalDataSource(context);
    }

    @Override
    public void getTodoNote(GetTodoNote callback) {
        //if there is internet it'll get the data from webservice
        localTodoDataSource.getTodoNote(callback);//bb
    }

    @Override
    public void setData(TodoNote note) {
        localTodoDataSource.setData(note);
    }

    @Override
    public void getNotes(GetNotes callback) {
        localTodoDataSource.getNotes(callback);
    }
}
