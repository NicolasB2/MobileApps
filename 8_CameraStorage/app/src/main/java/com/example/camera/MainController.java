package com.example.camera;

import android.Manifest;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;

import androidx.core.app.ActivityCompat;
import androidx.core.content.FileProvider;

import com.bumptech.glide.Glide;

import java.io.File;

import static android.app.Activity.RESULT_OK;

public class MainController implements View.OnClickListener{

    public static final int CAMERA_CALLBACK  = 1;
    public static final int GALLERY_CALLBACK = 2;

    private MainActivity view;
    private File file;

    public MainController(MainActivity view) {

        this.view = view;

        ActivityCompat.requestPermissions(view,new String[]{
                Manifest.permission.CAMERA,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_EXTERNAL_STORAGE
        },0);

        this.view.getCameraButton().setOnClickListener(this);
        this.view.getGalleryButton().setOnClickListener(this);
        this.view.getDownloadButton().setOnClickListener(this);

        File root = new File(view.getExternalFilesDir(null)+"");
        Log.e(">>>",""+root);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.cameraButton:
                Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                file = new File(this.view.getExternalFilesDir(null)+"/photo.png");
                Uri photoUri = FileProvider.getUriForFile(this.view,this.view.getPackageName(),file);
                i.putExtra(MediaStore.EXTRA_OUTPUT,photoUri);
                this.view.startActivityForResult(i,CAMERA_CALLBACK);
                break;
            case R.id.galeryButton:
                Intent gal = new Intent(Intent.ACTION_GET_CONTENT);
                gal.setType("image/*");
                this.view.startActivityForResult(gal,GALLERY_CALLBACK);
                break;
            case R.id.downloadButton:
                Glide.with(this.view)
                        .load("https://raw.githubusercontent.com/bumptech/glide/master/static/glide_logo.png")
                        .fitCenter()
                        .into(this.view.getPhoto());
                break;
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data){
        if(requestCode == CAMERA_CALLBACK && resultCode == RESULT_OK){
            Bitmap image = BitmapFactory.decodeFile(file.getPath());
            Bitmap thumbnail = Bitmap.createScaledBitmap(image,image.getWidth()/4,image.getWidth()/4,false);
            view.getPhoto().setImageBitmap(thumbnail);
        }else if(requestCode == GALLERY_CALLBACK && resultCode == RESULT_OK){
            Uri uri = data.getData();
            file = new File(UtilDomi.getPath(this.view,uri));
            Bitmap imagen  = BitmapFactory.decodeFile(file.toString());
            this.view.getPhoto().setImageBitmap(imagen);
        }
    }
}
