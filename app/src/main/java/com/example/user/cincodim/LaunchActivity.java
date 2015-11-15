package com.example.user.cincodim;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.ImageButton;

public class LaunchActivity extends LaunchButton {
    private String activity_package;

    public LaunchActivity(Context context, ImageButton btn, String activity_package) {
        super(context, btn);
        setActivityPackage(activity_package);
    }

    public void setActivityPackage(String activity_package) {
        this.activity_package = activity_package;
    }

    public String getActivityPackage() {
        return this.activity_package;
    }

    @Override
    public void launch(){
        Intent intent = getContext().getPackageManager().getLaunchIntentForPackage(getActivityPackage());
        if (intent == null) {
            intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("market://details?id=" + getActivityPackage()));
        }
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        getContext().startActivity(intent);
    }

}
