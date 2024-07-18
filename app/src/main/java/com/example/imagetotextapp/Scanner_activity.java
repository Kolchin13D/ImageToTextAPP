package com.example.imagetotextapp;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class Scanner_activity extends AppCompatActivity {

    private ImageView captureIV;
    private TextView resultTV;
    private Button snapbtn, recogBtn;
    private Bitmap imageBitmap;
    static final int REQUEST_IMAGE_CAPTURE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_scanner);

        captureIV = findViewById(R.id.CaptureImage);
        resultTV = findViewById(R.id.textView);
        snapbtn = findViewById(R.id.snapBtn);
        recogBtn = findViewById(R.id.recogBtn);

        recogBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RecognitionText();
            }
        });

        snapbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkPermission()){
                    captureImage();
                }else{
                    requestPermission();
                }
            }
        });
    }

    private boolean checkPermission() {
        int camera_permisiion = ContextCompat.checkSelfPermission(getApplicationContext(), CAMERA_SERVICE);
        return camera_permisiion == PackageManager.PERMISSION_GRANTED;
    }

    private void captureImage() {
    }

    private void requestPermission() {
        int code = 200;
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.});
    }

    private void RecognitionText() {
    }
}