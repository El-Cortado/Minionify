package com.cortado.minionify;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Window window = getWindow();
        setActionBarTransparent(window);
        setNavigationBarTransparent(window);
    }

    private void setNavigationBarTransparent(Window window) {
        WindowManager.LayoutParams winParams = window.getAttributes();
        winParams.flags |= WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION;
        window.setAttributes(winParams);
    }

    private void setActionBarTransparent(Window window) {
        WindowManager.LayoutParams winParams = window.getAttributes();
        winParams.flags |= WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
        window.setAttributes(winParams);
    }
}
