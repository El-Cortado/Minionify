package com.cortado.minionify.mode;

public enum AppMode {
    MINION(1),
    MANAGER(2);

    private final int mValue;

    AppMode(int value) {
        mValue = value;
    }

    public int getValue() {
        return mValue;
    }

    public static AppMode fromValue(int value) {
        for (AppMode mode: AppMode.values()) {
            if (mode.mValue == value) {
                return mode;
            }
        }

        throw new IllegalArgumentException();
    }
}
