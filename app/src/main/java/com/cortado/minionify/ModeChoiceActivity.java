package com.cortado.minionify;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.cortado.minionify.mode.AppMode;
import com.cortado.minionify.mode.exceptions.ModeNotExistsException;
import com.cortado.minionify.preference.PreferencesSingleton;
import com.cortado.minionify.R;
import com.cortado.minionify.preference.exceptions.PreferenceOperationFailure;

public class ModeChoiceActivity extends AppCompatActivity {

    private PreferencesSingleton mPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPreferences = PreferencesSingleton.getInstance(getPreferences(Context.MODE_PRIVATE));

        AppMode appMode = getAppMode();
        if (appMode != null) {
            redirectActivity(appMode);
            findViewById(R.id.manager_button).setOnClickListener(null);
            findViewById(R.id.minion_button).setOnClickListener(null);
        }

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

    private AppMode getAppMode() {
        try {
            return mPreferences.getAppMode();
        } catch (ModeNotExistsException e) {
            return null;
        }
    }

    private void redirectActivity(AppMode appMode) {
        // redirect to the right activity
    }

    public void onAppModeChosen(View view) {
        try {
            if (view.getId() == R.id.minion_button) {
                mPreferences.setAppMode(AppMode.MINION);
                redirectActivity(AppMode.MINION);
            } else if (view.getId() == R.id.manager_button) {
                mPreferences.setAppMode(AppMode.MANAGER);
                redirectActivity(AppMode.MANAGER);
            }
        } catch (PreferenceOperationFailure e) {
            Toast.makeText(this, "Internal Error: Couldn't choose mode", Toast.LENGTH_LONG).show();
        }
    }
}