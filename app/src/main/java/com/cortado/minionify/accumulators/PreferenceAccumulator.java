package com.cortado.minionify.accumulators;

import android.content.SharedPreferences;

import com.cortado.minionify.mode.AppMode;

public class PreferenceAccumulator implements IAccumulator {
    private SharedPreferences mPreferences;

    private static final String KEY_NOT_FOUND_DEFAULT_VALUE = " ";

    public PreferenceAccumulator(SharedPreferences prefs) {
        mPreferences = prefs;
    }

    @Override
    public void set(String key, String value) {
        SharedPreferences.Editor prefsEditor = mPreferences.edit();
        prefsEditor.putString(key, value);
        prefsEditor.commit();
    }

    @Override
    public String get(String key) {
        return mPreferences.getString(key, KEY_NOT_FOUND_DEFAULT_VALUE);
    }

    @Override
    public boolean exists(String key) {
        String value = mPreferences.getString(key, KEY_NOT_FOUND_DEFAULT_VALUE);
        return !value.equals(KEY_NOT_FOUND_DEFAULT_VALUE);
    }
}
