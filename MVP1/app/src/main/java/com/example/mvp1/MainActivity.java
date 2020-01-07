package com.example.mvp1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements MainContract.View {
    MainContract.Presenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new MainPresenter(this);
    }

    public void ClickListener(View view) {
        //view: hey mr presenter somebody clicked a button on me
        presenter.onButtonClicked();
    }

    @Override
    public void showToast(String najma) {

        Toast.makeText(this,najma , Toast.LENGTH_SHORT).show(); 
    }
}