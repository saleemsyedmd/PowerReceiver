package com.example.sqliteapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements MainContract.View{
    MainContract.Presenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void clickHandler(MainContract.View view) {//2
        switch (view.getId()){
            case R.id.buttonget:
                presenter.onButtonClicked();//11

                break;
            case R.id.buttonset:
                EditText titleEditText = findViewById(R.id.editTextTitle);
                EditText subtitleEditText =  findViewById(R.id.editTextSubTitle);
                String title = titleEditText.getText().toString();
                String subtitle = subtitleEditText.getText().toString();
                TodoNote note = new TodoNote(title,subtitle);

                presenter.setData(note);
                break;
        }
        //hey mr presenter somebody clicked my button what should i do
        presenter.onButtonClicked();//11
    }

    public void clickHandler(View view) {
        switch (view.getId()){
            case R.id.get:
                presenter.onButtonClicked();//11

                break;
            case R.id.buttonset:
                EditText titleEditText = findViewById(R.id.editTexttitle);
                EditText subtitleEditText =  findViewById(R.id.editTextSubtitle);
                String title = titleEditText.getText().toString();
                String subtitle = subtitleEditText.getText().toString();
                TodoNote note = new TodoNote(title,subtitle);

                presenter.setData(note);
                break;
        }
        //hey mr presenter somebody clicked my button what should i do
        presenter.onButtonClicked();//11
    }

    @Override
    public int getId() {
        return 0;
    }

    @Override
    }

    @Override
}
