package com.example.threads;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private MainController controller;
    private TextView stopwatchTV;
    private TextView responseTV;
    private EditText urlET;
    private Button getBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        stopwatchTV = findViewById(R.id.stopwatchTV);
        responseTV = findViewById(R.id.responseTV);
        responseTV.setMovementMethod(new ScrollingMovementMethod());
        urlET = findViewById(R.id.urlET);
        getBtn = findViewById(R.id.getBtn);

        controller = new MainController(this);
    }

    public TextView getStopwatchTV() {
        return stopwatchTV;
    }

    public TextView getResponseTV() {
        return responseTV;
    }

    public EditText getUrlET() {
        return urlET;
    }

    public Button getGetBtn() {
        return getBtn;
    }
}
