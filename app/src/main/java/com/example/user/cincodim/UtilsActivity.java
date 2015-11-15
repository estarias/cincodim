package com.example.user.cincodim;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageButton;

public class UtilsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_utils);
        init();
    }


    private void init() {
        LaunchActivity cam = new LaunchActivity(getApplicationContext(),
                (ImageButton) findViewById(R.id.btnCam), "com.android.camera2");

        LaunchActivity paint = new LaunchActivity(getApplicationContext(),
                (ImageButton) findViewById(R.id.btnPaint), "com.pescapps.kidspaint");

        LaunchActivity record = new LaunchActivity(getApplicationContext(),
                (ImageButton) findViewById(R.id.btnRecordSound), "com.android.soundrecorder");

        LaunchActivity browser = new LaunchActivity(this,
                (ImageButton) findViewById(R.id.btnBrowser), "com.android.chrome");

        LaunchActivity gallery = new LaunchActivity(getApplicationContext(),
                (ImageButton) findViewById(R.id.btnGallery), "com.android.gallery3d");

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
