package com.cortado.minionify.accumulators;

public interface Accumulator {
    void set(String key, String value);
    String get(String key);
    boolean exists(String key);
}
