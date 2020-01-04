package com.example.databaseimplementationapp.TodoApp;

import com.example.databaseimplementationapp.TodoNote;

public interface MainContract {
    interface View{
        interface Presenter{
            void onButtonClicked();
            void setData(TodoNote note);
        }
    }

    public class Presenter {
        public void onButtonClicked() {
        }
    }
}
