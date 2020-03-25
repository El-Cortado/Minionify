package com.cortado.minionify;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import com.cortado.minionify.mode.AppMode;
import com.cortado.minionify.preference.AppModePreferenceManager;

public class ModeChoiceActivity extends AppCompatActivity {

    private AppModePreferenceManager mAppModePreferenceManager;

    private static final String GENERAL_PREFERENCES = "generalPreferences";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAppModePreferenceManager = new AppModePreferenceManager(getSharedPreferences(GENERAL_PREFERENCES, Context.MODE_PRIVATE));
        redirectActivityIfModeExists();

        Window window = getWindow();
        setStatusBarTranslucent(window);
        setNavigationBarTranslucent(window);
    }

    private void setNavigationBarTranslucent(Window window) {
        WindowManager.LayoutParams winParams = window.getAttributes();
        winParams.flags |= WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION;
        window.setAttributes(winParams);
    }

    private void setStatusBarTranslucent(Window window) {
        WindowManager.LayoutParams winParams = window.getAttributes();
        winParams.flags |= WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
        window.setAttributes(winParams);
    }

    private void redirectActivityIfModeExists() {
        if (mAppModePreferenceManager.isAppModeExists()) {
            AppMode appMode = getAppMode();
            redirectActivity(appMode);
            findViewById(R.id.manager_button).setEnabled(false);
            findViewById(R.id.minion_button).setEnabled(false);
        }
    }

    private AppMode getAppMode() {
        return mAppModePreferenceManager.getAppMode();
    }

    private void redirectActivity(AppMode appMode) {
        // todo: redirect to the right activity
    }

    public synchronized void onAppModeChosen(View view) {
        AppMode appMode;

        if (view.getId() == R.id.minion_button) {
            appMode = AppMode.MINION;
        } else {
            appMode = AppMode.MANAGER;
        }

        mAppModePreferenceManager.setAppMode(appMode);
        redirectActivity(appMode);
    }
}