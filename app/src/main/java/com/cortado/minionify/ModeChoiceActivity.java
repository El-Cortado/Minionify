package com.cortado.minionify;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import com.cortado.minionify.accumulators.IAccumulator;
import com.cortado.minionify.accumulators.PreferencesFiles;
import com.cortado.minionify.accumulators.Preferences;
import com.cortado.minionify.mode.AppMode;
import com.cortado.minionify.accumulators.PreferenceAccumulator;

public class ModeChoiceActivity extends AppCompatActivity {

    private IAccumulator mAccumulator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAccumulator = new PreferenceAccumulator(getSharedPreferences(PreferencesFiles.GENERAL_PREFERENCES, Context.MODE_PRIVATE));
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
        if (mAccumulator.exists(Preferences.APP_MODE_PREFERENCE_KEY)) {
            AppMode appMode = getAppMode();
            redirectActivity(appMode);
            findViewById(R.id.manager_button).setEnabled(false);
            findViewById(R.id.minion_button).setEnabled(false);
        }
    }

    private AppMode getAppMode() {
        return AppMode.valueOf(mAccumulator.get(Preferences.APP_MODE_PREFERENCE_KEY));
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

        mAccumulator.set(Preferences.APP_MODE_PREFERENCE_KEY, appMode.getValue());
        redirectActivity(appMode);
    }
}