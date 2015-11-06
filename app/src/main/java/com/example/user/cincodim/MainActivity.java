package com.example.user.cincodim;

import android.app.Activity;
import android.app.LauncherActivity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
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
        LaunchActivity communicator = new LaunchActivity(getApplicationContext(),
                (ImageButton) findViewById(R.id.btnCommunicator), "com.uvigo.gti.PictoDroidLite");

        LaunchActivity chat = new LaunchActivity(getApplicationContext(),
                (ImageButton) findViewById(R.id.btnChat), "es.uvigo.gti.PictoTalk");

        LaunchUrl moodle = new LaunchUrl(this,
                (ImageButton) findViewById(R.id.btnMoodle), "http://5duruguay.edu.uy");

        LaunchActivity schedule = new LaunchActivity(getApplicationContext(),
                (ImageButton) findViewById(R.id.btnSchedule), "com.lorenzomoreno.pictogramagenda");

        ImageButton educational = (ImageButton) findViewById(R.id.btnEducational);
        ImageButton utils = (ImageButton) findViewById(R.id.btnUtils);
        ImageButton writer = (ImageButton) findViewById(R.id.btnWriter);
        ImageButton close = (ImageButton) findViewById(R.id.btnClose);

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exitApp();
            }
        });

        educational.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMessage("Sin implementar");
            }
        });
        utils.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMessage("Sin implementar");
            }
        });
        writer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMessage("Sin implementar");
            }
        });
    }

    public void showMessage(String txt) {
        Toast msgToast = Toast.makeText(MainActivity.this, txt, Toast.LENGTH_SHORT);
        msgToast.show();
    }

    public void exitApp()
    {
        //call this method to exit _CLEARLY_,
        //and prompt the user which launcher to use next

        //clear the default for your app (to show the prompt when exiting)
        final PackageManager pm = getPackageManager();
        pm.clearPackagePreferredActivities(getApplicationContext().getPackageName());

        //exit _CLEARLY_
        //calling finish(); would be ok also,
        //but there would stay a 'zombie' in the dalvik cache
        //and 'zombies' only use up your memory, so kill your entire app:
        android.os.Process.killProcess(android.os.Process.myPid());
    }
}