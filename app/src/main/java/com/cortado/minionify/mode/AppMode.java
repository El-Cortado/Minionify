package com.cortado.minionify.mode;

public enum AppMode {
    MINION("MINION"),
    MANAGER("MANAGER");

    private String mValue;

    AppMode(String value) {
        mValue = value;
    }

    public String getValue() {
        return mValue;
    }
}
