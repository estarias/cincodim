package com.example.user.cincodim;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class EducationalActivity extends Activity {
    String GAMES = "http://www.pictojuegos.com/";
    String STORIES = "http://www.pictocuentos.com/";
    String AUDIO = "http://www.pictosonidos.com/";
//    String READING = "";
//    String WRITING = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_educational);
        init();
    }

    private void init() {

        LaunchUrl games = new LaunchUrl(this,
                (ImageButton) findViewById(R.id.btnGames), GAMES);

        LaunchUrl stories = new LaunchUrl(this,
                (ImageButton) findViewById(R.id.btnStories), STORIES);

        LaunchUrl audio = new LaunchUrl(this,
                (ImageButton) findViewById(R.id.btnAudio), AUDIO);

        ImageButton writing = (ImageButton) findViewById(R.id.btnWriting);
        ImageButton reading = (ImageButton) findViewById(R.id.btnReading);
        writing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMessage("Sin implementar");
            }
        });
        reading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMessage("Sin implementar");
            }
        });
/*
        LaunchUrl reading = new LaunchUrl(this,
                (ImageButton) findViewById(R.id.btnReading), READING);

        LaunchUrl writing = new LaunchUrl(this,
                (ImageButton) findViewById(R.id.btnWriting), WRITING);*/

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

    public void showMessage(String txt) {
        Toast msgToast = Toast.makeText(EducationalActivity.this, txt, Toast.LENGTH_SHORT);
        msgToast.show();
    }


}
