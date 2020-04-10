package com.example.threads;

public class Stopwatch extends Thread {

    private int counter;
    private boolean running;
    private OnValueListener listener;

    public Stopwatch(){
        counter = 0;
        running = true;
    }

    @Override
    public void run() {
        while(running){
            delay(100);
            counter+=100;
            listener.onValue(counter);
        }
    }

    public void delay(long time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public interface OnValueListener{
        void onValue(int time);
    }

    public void setListener(OnValueListener listener) {
        this.listener = listener;
    }
}
