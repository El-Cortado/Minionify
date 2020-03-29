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
        switch (value) {
            case 1:
                return MINION;
            case 2:
                return MANAGER;
            default:
                throw new IllegalArgumentException("There is no AppMode with the value of " + value);
        }
    }
}
