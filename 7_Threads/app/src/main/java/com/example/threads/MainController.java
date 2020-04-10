package com.example.threads;

import android.util.Log;
import android.view.View;

public class MainController implements Stopwatch.OnValueListener,GetRequest.OnResponseListener, View.OnClickListener{

    private MainActivity view;
    private Stopwatch stopwatch;
    private GetRequest getRequest;

    public MainController(MainActivity view){
        this.view = view;
        stopwatch = new Stopwatch();
        stopwatch.setListener(this);
        stopwatch.start();

        view.getGetBtn().setOnClickListener(this);
    }

    @Override
    public void onValue(int time) {
        //poner el valor del cronometro en un textview
        view.runOnUiThread(
            ()->{
                view.getStopwatchTV().setText(""+time);
            }
        );
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.getBtn:
                String url = this.view.getUrlET().getText().toString();
                GetRequest request = new GetRequest(url);
                request.setListener(this);
                request.start();//no se puede usar run()
                break;
        }
    }

    @Override
    public void onRsponse(String response) {
        //Recibimos los bytes que nos descargamos y los cargamos en el textview
        view.runOnUiThread(
                ()->{
                    view.getResponseTV().setText(response);
                }
        );
    }
}
