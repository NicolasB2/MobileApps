package com.example.camera;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private MainController controller;
    private ImageView photo;
    private Button cameraButton;
    private Button galleryButton;
    private Button downloadButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        photo = findViewById(R.id.photo);

        cameraButton = findViewById(R.id.cameraButton);
        galleryButton = findViewById(R.id.galeryButton);
        downloadButton = findViewById(R.id.downloadButton);

        controller = new MainController(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        controller.onActivityResult(requestCode,resultCode,data);
    }

    public ImageView getPhoto() {
        return photo;
    }

    public Button getCameraButton() {
        return cameraButton;
    }

    public Button getGalleryButton() {
        return galleryButton;
    }

    public Button getDownloadButton() {
        return downloadButton;
    }
}
