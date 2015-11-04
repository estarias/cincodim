package com.example.user.cincodim;

import android.app.Activity;
import android.app.LauncherActivity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    public void init() {
        LaunchActivity browser = new LaunchActivity(getApplicationContext(),
                (ImageButton) findViewById(R.id.btnBrowser), "com.android.browser");
        LaunchActivity communicator = new LaunchActivity(getApplicationContext(),
                (ImageButton) findViewById(R.id.btnCommunicator), "com.uvigo.gti.PictoDroidLite");
        LaunchActivity chat = new LaunchActivity(getApplicationContext(),
                (ImageButton) findViewById(R.id.btnChat), "es.uvigo.gti.PictoTalk");

       LaunchUrl moodle = new LaunchUrl(this,
               (ImageButton) findViewById(R.id.btnMoodle), "http://5duruguay.edu.uy");

    }

    public void showMessage(String txt) {
        Toast msgToast = Toast.makeText(MainActivity.this, txt, Toast.LENGTH_SHORT);
        msgToast.show();
    }
}