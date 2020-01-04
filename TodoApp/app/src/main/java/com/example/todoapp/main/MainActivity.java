package com.example.todoapp.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.todoapp.R;
import com.example.todoapp.data.TodoNote;

//MainActivity = view no biz logic in it-- notice board
public class MainActivity extends AppCompatActivity implements MainContract.View{
    MainContract.Presenter presenter;//9

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new MainPresenter(this);//10
    }

    public void clickHandler(View view) {//2
        switch (view.getId()){
            case R.id.buttonget:
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
    }

    @Override
    public void showToast() {
        Toast.makeText(this, "clicked", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setText(String text) {
        TextView resTextView = findViewById(R.id.textViewresult);
        resTextView.setText(text);//ff

    }
}
