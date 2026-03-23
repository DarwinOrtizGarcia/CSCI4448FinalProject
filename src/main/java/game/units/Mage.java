package game.units;

public class Mage extends Enemy {
    private static final Double DEFAULT_INITIAL_HEALTH = 15.0;
    private static final Double DEFAULT_INITIAL_STRENGTH = 5.0;
    private static final Double DEFAULT_INITIAL_MAGIC = 15.0;
    private static final Double DEFAULT_INITIAL_DEFENSE = 7.0;
    private static final Double DEFAULT_INITIAL_RESISTANCE = 15.0;
    private static final Double DEFAULT_INITIAL_RANGE = 2.0;

    public Mage (String name) {
        super(name, DEFAULT_INITIAL_HEALTH, DEFAULT_INITIAL_STRENGTH, DEFAULT_INITIAL_MAGIC, DEFAULT_INITIAL_DEFENSE, DEFAULT_INITIAL_RESISTANCE, DEFAULT_INITIAL_RANGE);
    }
}