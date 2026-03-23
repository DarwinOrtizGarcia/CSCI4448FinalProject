package com.character;

public class Sniper extends Enemy {
    private static final Double DEFAULT_INITIAL_HEALTH = 12.0;
    private static final Double DEFAULT_INITIAL_STRENGTH = 7.0;
    private static final Double DEFAULT_INITIAL_MAGIC = 4.0;
    private static final Double DEFAULT_INITIAL_DEFENSE = 4.0;
    private static final Double DEFAULT_INITIAL_RESISTANCE = 10.0;
    private static final Double DEFAULT_INITIAL_RANGE = 2.0;

    public Sniper (String name) {
        super(name, DEFAULT_INITIAL_HEALTH, DEFAULT_INITIAL_STRENGTH, DEFAULT_INITIAL_MAGIC, DEFAULT_INITIAL_DEFENSE, DEFAULT_INITIAL_RESISTANCE, DEFAULT_INITIAL_RANGE);
    }
}