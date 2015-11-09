package com.example.user.cincodim;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.ImageButton;

public class UtilsActivity extends Activity {
    String CAM = "com.android.camera";
    String GALLERY = "com.android.gallery";
    String RECORD = "com.android.sound";
    String PAINT = "com.pescapps.kidspaint";
    int CURRENT_API_VERSION = android.os.Build.VERSION.SDK_INT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_utils);
        init();
    }

    private void init() {
        if (CURRENT_API_VERSION <= android.os.Build.VERSION_CODES.LOLLIPOP){
            CAM = "com.sec.android.app.camera";
            GALLERY = "com.sec.android.gallery3d";
            RECORD = "com.sec.android.app.voicerecorder";
        }
        LaunchActivity cam = new LaunchActivity(getApplicationContext(),
                (ImageButton) findViewById(R.id.btnCam), CAM);

        LaunchActivity paint = new LaunchActivity(getApplicationContext(),
                (ImageButton) findViewById(R.id.btnPaint), PAINT);

        LaunchActivity record = new LaunchActivity(getApplicationContext(),
                (ImageButton) findViewById(R.id.btnRecordSound), RECORD);

        LaunchUrl browser = new LaunchUrl(this,
                (ImageButton) findViewById(R.id.btnBrowser), "http://www.google.com");

        LaunchActivity gallery = new LaunchActivity(getApplicationContext(),
                (ImageButton) findViewById(R.id.btnGallery), GALLERY);

        ImageButton close = (ImageButton) findViewById(R.id.btnClose);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go_back();
            }
        });
    }

    private void go_back() {
        Intent intent = new Intent();
        setResult(RESULT_OK, intent);
        finish();
    }




}
