package com.volthapps.passlock;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;

public class PopUpActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_popup);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout(width,height);

        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);


    }

}
