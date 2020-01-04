package com.example.todoapp.main;

import com.example.todoapp.data.TodoNote;
import com.example.todoapp.data.source.TodoDataSource;
import com.example.todoapp.data.source.TodoRepository;

public class MainPresenter implements MainContract.Presenter, TodoDataSource.GetTodoNote{//8
    MainContract.View view;//12
    TodoDataSource repository;


    public MainPresenter(MainActivity mainActivity) {

        view = mainActivity;//13
        repository = new TodoRepository(mainActivity);
    }

    @Override
    public void onButtonClicked() {
        //mr view plz show a toast to him
        view.showToast();//14
        repository.getTodoNote(this);//aa

    }

    @Override
    public void setData(TodoNote note) {
        repository.setData(note);
    }

    @Override
    public void onNoteLoaded(TodoNote note) {
        view.setText(note.getTitle());//ee

    }

    @Override
    public void onDataNotAvailable() {

    }
}
