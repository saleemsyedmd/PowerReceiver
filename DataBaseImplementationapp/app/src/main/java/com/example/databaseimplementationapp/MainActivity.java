package com.example.databaseimplementationapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.databaseimplementationapp.TodoApp.MainContract;

public class MainActivity extends AppCompatActivity implements MainContract.View {
MainContract.Presenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void ClickListenerGet(View view) {
        switch (view.getId()){
            case R.id.button:
                presenter.onButtonClicked();

                break;
        }
        presenter.onButtonClicked();
    }

    public void ClickListenerPut(View view) {
    }
}
