package com.cortado.minionify.accumulators;

public interface Accumulator {
    void set(String key, int value);
    int get(String key);
    boolean exists(String key);
}

class KeyDoesNotExists extends RuntimeException {}
