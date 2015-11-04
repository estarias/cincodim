package com.example.user.cincodim;

import android.content.Context;
import android.view.View;
import android.widget.ImageButton;

public class LaunchButton {
    private Context context;
    private ImageButton btn;

    public LaunchButton(Context context, ImageButton btn) {
        this.context = context;
        this.btn = btn;
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launch();
            }
        });
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public ImageButton getBtn() {
        return btn;
    }

    public void setBtn(ImageButton btn) {
        this.btn = btn;
    }
    
    public void launch(){}
}
