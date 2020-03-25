package com.cortado.minionify.accumulators;

public interface IAccumulator {
    void set(String key, String value);
    String get(String key);
    boolean exists(String key);
}
