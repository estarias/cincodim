package com.example.user.cincodim;

import android.content.Context;
import android.util.Log;
import android.widget.ImageButton;
import android.content.Intent;
import android.net.Uri;

public class LaunchUrl extends LaunchButton {
    private String url;

    public LaunchUrl(Context context, ImageButton btn, String url) {
        super(context, btn);
        setUrl(url);
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        if (!url.startsWith("https://") && !url.startsWith("http://")){
            url = "http://" + url;
        }
        this.url = url;
    }

    @Override
    public void launch(){
        Log.d("open page: ", getUrl());
        Uri uri = Uri.parse(getUrl());
        Intent it  = new Intent(Intent.ACTION_VIEW,uri);
        getContext().startActivity(it);
    }

}
