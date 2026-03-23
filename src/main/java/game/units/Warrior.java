package game.units;

public class Warrior extends Enemy {
    private static final Double DEFAULT_INITIAL_HEALTH = 15.0;
    private static final Double DEFAULT_INITIAL_STRENGTH = 9.0;
    private static final Double DEFAULT_INITIAL_MAGIC = 5.0;
    private static final Double DEFAULT_INITIAL_DEFENSE = 4.0;
    private static final Double DEFAULT_INITIAL_RESISTANCE = 10.0;
    private static final Double DEFAULT_INITIAL_RANGE = 1.0;

    public Warrior (String name) {
        super(name, DEFAULT_INITIAL_HEALTH, DEFAULT_INITIAL_STRENGTH, DEFAULT_INITIAL_MAGIC, DEFAULT_INITIAL_DEFENSE, DEFAULT_INITIAL_RESISTANCE, DEFAULT_INITIAL_RANGE);
    }
}