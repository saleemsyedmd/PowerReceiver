package com.example.sqliteapp;
import android.content.Context;
import com.example.sqliteapp.data.TodoNote;
import com.example.sqliteapp.data.source.TodoDataSource;



public class LocalDataSource implements TodoDataSource {

    DAO dao;

    public LocalDataSource() {
        dao = new DAO();
    public LocalDataSource(Context context) {
            dao = new DAO(context);
        }
        @Override
        public void getTodoNote (GetTodoNote callback){
            dao.getTodoNote(callback);//cc
        }

        @Override
        public void setData (TodoNote note){
            dao.openDb();
            dao.createRow(note.getTitle(), note.getSubtitle());
        }
    }

    @Override
    public void getTodoNote(GetTodoNote callback) {

    }
}
