package com.volthapps.passlock;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.ViewGroup;
import android.widget.Button;

public class Action_Bar_Activity extends AppCompatActivity {

    private Button backButton;
    private ViewGroup layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.action_bar);

        backButton= findViewById(R.id.backButton);
        layout = (ViewGroup) backButton.getParent();
        layout.addView(backButton);
        layout.removeView(backButton);
    }
}

