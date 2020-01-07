package com.example.mvp1;

public class MainPresenter implements  MainContract.Presenter {
    MainContract.View view;
    public MainPresenter(MainActivity mainActivity) {
        view = mainActivity;//10--wiring
    }
    @Override
    public void onButtonClicked() {
        //presenter : hey mr view show a toast
        view.showToast("abdul");//11


    }
}
