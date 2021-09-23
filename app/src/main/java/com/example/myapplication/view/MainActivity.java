package com.example.myapplication.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.widget.EditText;

import com.example.myapplication.R;
import com.example.myapplication.presenter.MainPresenter;

import android.app.Activity;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements ViewInterface {

    private MainPresenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        init();
    }

    private void init() {
        findViewById(R.id.secBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Явный интент
                Intent intent = new Intent(MainActivity.this, About.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.addNote();
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, getNoteText());
                sendIntent.setType("text/plain");

                // Неявный интент
                Intent shareIntent = Intent.createChooser(sendIntent, null);
                startActivity(shareIntent);
            }

        });
        presenter = new MainPresenter(this);

    }

    @Override
    public void showSaveNotify(String notify) {
        Toast toast = Toast.makeText(this, notify, Toast.LENGTH_LONG);
        toast.show();
    }

    @Override
    public String getNoteText() {
        return ((EditText) this.findViewById(R.id.editTextTextPersonName)).getText().toString();
    }
}

