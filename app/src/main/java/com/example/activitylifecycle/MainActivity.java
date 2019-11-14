package com.example.activitylifecycle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
Button call;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this,"OnCreateFinished",Toast.LENGTH_LONG).show();
        Log.i("MainActivity","OnCreate");

    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this,"OnStartFinished",Toast.LENGTH_LONG).show();
        Log.i("MainActivity","OnStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this,"OnResumeFinished",Toast.LENGTH_LONG).show();
        Log.i("MainActivity","OnResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this,"OnPauseFinished",Toast.LENGTH_LONG).show();
        Log.i("MainActivity","OnPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this,"OnStopFinished",Toast.LENGTH_LONG).show();
        Log.i("MainActivity","OnStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this,"OnRestartFinished",Toast.LENGTH_LONG).show();
        Log.i("MainActivity","OnRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this,"OnDestroyFinished",Toast.LENGTH_LONG).show();
        Log.i("MainActivity","OnDestroy");
    }

    public void ClickListener(View view) {
        switch (view.getId()) {

            case R.id.button:
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.youtube.com"));
                startActivity(intent);

                break;
            case R.id.button2:

                Intent intent2 = new Intent(Intent.ACTION_VIEW, Uri.parse("tel: 8610736109"));
                startActivity(intent2);

                break;

            case R.id.button3:
                Intent intent3 = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:11.1271° N, 78.6569° E"));
                startActivity(intent3);

                break;
        }


        }


    }
