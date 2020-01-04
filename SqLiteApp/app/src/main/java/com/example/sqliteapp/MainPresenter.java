package com.example.sqliteapp;

import android.app.Activity;

public  MainPresenter(MainActivity mainActivity) {

        view = mainActivity;//13
        repository = new TodoRepository();
        repository = new TodoRepository(mainActivity);
        }

@Override
 public void onButtonClicked() {

        }

@Override
public void setData(TodoNote note) {
        repository.setData(note);
        }

@Override
public void onNoteLoaded(TodoNote note) {
        view.setText(note.getTitle());{

