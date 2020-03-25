package com.cortado.minionify.preference;

import android.content.SharedPreferences;

import com.cortado.minionify.mode.AppMode;

public class AppModePreferenceManager {
    private SharedPreferences mPreferences;

    private static final String MODE_PREFERENCE_KEY = "mode";
    private static final String NO_MODE_FOUND_DEFAULT_VALUE = " ";

    public AppModePreferenceManager(SharedPreferences prefs) {
        mPreferences = prefs;
    }

    public void setAppMode(AppMode chosenAppMode) {
        SharedPreferences.Editor prefsEditor = mPreferences.edit();
        prefsEditor.putString(MODE_PREFERENCE_KEY, chosenAppMode.toString());
        prefsEditor.commit();
    }

    public boolean isAppModeExists() {
        String appMode = mPreferences.getString(MODE_PREFERENCE_KEY, NO_MODE_FOUND_DEFAULT_VALUE);
        return !appMode.equals(NO_MODE_FOUND_DEFAULT_VALUE);
    }

    public AppMode getAppMode() {
        return AppMode.valueOf(mPreferences.getString(MODE_PREFERENCE_KEY, NO_MODE_FOUND_DEFAULT_VALUE));
    }
}
