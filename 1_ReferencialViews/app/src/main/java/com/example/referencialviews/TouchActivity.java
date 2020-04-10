package com.example.referencialviews;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.TextView;

public class TouchActivity extends AppCompatActivity {

    private TextView box,console;
    private float Xini,Yini;
    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touch);

        box = findViewById(R.id.box);
        console = findViewById(R.id.console);

        box.setOnTouchListener(
                (v,event)->{
                    switch (event.getAction()){
                        case MotionEvent.ACTION_DOWN:
                            console.setText("DOWN");
                            Xini = box.getX();
                            Yini = box.getY();
                            break;
                        case MotionEvent.ACTION_MOVE:
                            console.setText("MOVE");
                            box.setX(box.getX()+event.getX()-100);
                            box.setY(box.getY()+event.getY()-100);

                            break;
                        case MotionEvent.ACTION_UP:
                            console.setText("UP");
                            break;

                    }
                    console.append("\nX: "+event.getX());
                    console.append("\nY: "+event.getY());
                    return true;
                }

        );
    }
}
