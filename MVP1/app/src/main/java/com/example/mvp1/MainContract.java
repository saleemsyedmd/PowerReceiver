package com.example.mvp1;

public interface MainContract {

    interface View {
        void showToast(String abdul);
    }

    interface Presenter {
        void onButtonClicked();
    }
}