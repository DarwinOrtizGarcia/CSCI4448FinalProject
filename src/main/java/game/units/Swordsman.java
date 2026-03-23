package game.units;

public class Swordsman extends Enemy {
    private static final Double DEFAULT_INITIAL_HEALTH = 20.0;
    private static final Double DEFAULT_INITIAL_STRENGTH = 8.0;
    private static final Double DEFAULT_INITIAL_MAGIC = 3.0;
    private static final Double DEFAULT_INITIAL_DEFENSE = 10.0;
    private static final Double DEFAULT_INITIAL_RESISTANCE = 9.0;
    private static final Double DEFAULT_INITIAL_RANGE = 1.0;

    public Swordsman (String name) {
        super(name, DEFAULT_INITIAL_HEALTH, DEFAULT_INITIAL_STRENGTH, DEFAULT_INITIAL_MAGIC, DEFAULT_INITIAL_DEFENSE, DEFAULT_INITIAL_RESISTANCE, DEFAULT_INITIAL_RANGE);
    }
}