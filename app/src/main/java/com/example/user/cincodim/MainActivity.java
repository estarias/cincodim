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
    String COMMUNICATOR = "com.uvigo.gti.PictoDroidLite";
    String CHAT = "es.uvigo.gti.PictoTalk";
    String MOODLE_PAGE = "http://5duruguay.edu.uy";
    String SCHEDULE = "com.lorenzomoreno.pictogramagenda";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    public void init() {
        LaunchActivity communicator = new LaunchActivity(getApplicationContext(),
                (ImageButton) findViewById(R.id.btnCommunicator), COMMUNICATOR);

        LaunchActivity chat = new LaunchActivity(getApplicationContext(),
                (ImageButton) findViewById(R.id.btnChat), CHAT);

        LaunchUrl moodle = new LaunchUrl(this,
                (ImageButton) findViewById(R.id.btnMoodle), MOODLE_PAGE);

        LaunchActivity schedule = new LaunchActivity(getApplicationContext(),
                (ImageButton) findViewById(R.id.btnSchedule), SCHEDULE);

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
        utils.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showUtils();
            }
        });

        educational.setOnClickListener(new View.OnClickListener() {
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
    public void showUtils() {
        Intent intent = new Intent(MainActivity.this, UtilsActivity.class);
        startActivity(intent);
        //startActivityForResult(intent, RESULT_OK);
    }

    public void exitApp(){
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