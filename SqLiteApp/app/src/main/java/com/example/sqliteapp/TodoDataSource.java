package com.example.sqliteapp;

public interface TodoDataSource {
    void getTodoNote(GetTodoNote callback);
    void setData(TodoNote note);
}
