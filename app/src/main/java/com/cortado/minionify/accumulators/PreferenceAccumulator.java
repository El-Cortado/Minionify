package com.cortado.minionify.accumulators;

import android.content.SharedPreferences;

import com.cortado.minionify.accumulators.exceptions.KeyDoesNotExistException;

public class PreferenceAccumulator implements Accumulator {
    private SharedPreferences mPreferences;

    private static final int KEY_NOT_FOUND_DEFAULT_VALUE = -1;

    public PreferenceAccumulator(SharedPreferences prefs) {
        mPreferences = prefs;
    }

    @Override
    public void set(String key, int value) {
        SharedPreferences.Editor prefsEditor = mPreferences.edit();
        prefsEditor.putInt(key, value);
        prefsEditor.commit();
    }

    @Override
    public int get(String key) throws KeyDoesNotExistException {
        if (!exists(key)) {
            throw new KeyDoesNotExistException();
        }

        return mPreferences.getInt(key, KEY_NOT_FOUND_DEFAULT_VALUE);
    }

    @Override
    public boolean exists(String key) {
        int value = mPreferences.getInt(key, KEY_NOT_FOUND_DEFAULT_VALUE);
        return !(value == KEY_NOT_FOUND_DEFAULT_VALUE);
    }
}
