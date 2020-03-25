package com.cortado.minionify.mode;

public enum AppMode {
    MINION,
    MANAGER;

    public static int toInteger(AppMode appMode) {
        switch (appMode) {
            case MINION:
                return 0;
            case MANAGER:
                return 1;
            default:
                throw new IllegalArgumentException();
        }
    }

    public static AppMode fromInteger(int appModeInteger) {
        switch (appModeInteger) {
            case 0:
                return MINION;
            case 1:
                return MANAGER;
            default:
                throw new IllegalArgumentException();
        }
    }
}
