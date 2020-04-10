package com.example.threads;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class GetRequest extends Thread {

    private String url;
    private OnResponseListener listener;

    public GetRequest(String url){
        this.url = url;
    }

    @Override
    public void run() {
        try {
            URL url = new URL(this.url);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            InputStream is = connection.getInputStream();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();

            //Transferir bytes de is a baos
            byte[] buffer = new byte[1024];
            int bytesRead;

            while ((bytesRead = is.read(buffer))!= -1){
                baos.write(buffer,0,bytesRead);
            }

            is.close();
            baos.close();

            String response = new String(baos.toByteArray(),"UTF-8");
            listener.onRsponse(response);


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public interface OnResponseListener{
        void onRsponse(String response);
    }

    public void setListener(OnResponseListener listener) {
        this.listener = listener;
    }
}
