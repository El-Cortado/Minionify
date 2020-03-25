package com.cortado.minionify.mode;

public enum AppMode {
    MINION("Minion"),
    MANAGER("Manager");

    private String mValue;

    AppMode(String value) {
        mValue = value;
    }

    public String getValue() {
        return mValue;
    }
}
