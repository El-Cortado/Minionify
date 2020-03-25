package com.cortado.minionify.preference;

import android.content.SharedPreferences;

import com.cortado.minionify.mode.AppMode;
import com.cortado.minionify.mode.exceptions.ModeNotExistsException;
import com.cortado.minionify.preference.exceptions.PreferenceOperationFailure;

public class PreferencesSingleton {
    private static PreferencesSingleton INSTANCE = null;
    private SharedPreferences mPreferences;

    private static final String MODE_PREFERENCE_KEY = "mode";

    private PreferencesSingleton(SharedPreferences prefs) {
        mPreferences = prefs;
    }

    public static PreferencesSingleton getInstance(SharedPreferences prefs) {
        if (INSTANCE == null) {
            INSTANCE = new PreferencesSingleton(prefs);
        }

        return INSTANCE;
    }

    public void setAppMode(AppMode chosenAppMode) throws PreferenceOperationFailure {
        SharedPreferences.Editor prefsEditor = mPreferences.edit();

        try {
            prefsEditor.putInt(MODE_PREFERENCE_KEY, AppMode.toInteger(chosenAppMode));
            prefsEditor.apply();
        } catch (IllegalArgumentException e) {
            throw new PreferenceOperationFailure(e);
        }
    }

    public AppMode getAppMode() throws ModeNotExistsException {
        int modeInteger = mPreferences.getInt(MODE_PREFERENCE_KEY, -1);
        if (modeInteger == -1) {
            throw new ModeNotExistsException();
        }

        return AppMode.fromInteger(modeInteger);
    }
}
