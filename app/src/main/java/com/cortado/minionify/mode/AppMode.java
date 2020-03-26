package com.cortado.minionify.mode;

public enum AppMode {
    MINION("MINION"),
    MANAGER("MANAGER");

    private final String mValue;

    AppMode(String value) {
        mValue = value;
    }

    public String getValue() {
        return mValue;
    }
}
