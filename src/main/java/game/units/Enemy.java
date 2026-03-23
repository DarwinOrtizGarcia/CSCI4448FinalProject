package game.units;

public class Enemy extends Character {
    private static final Double DEFAULT_INITIAL_HEALTH = 10.0;
    private static final Double DEFAULT_INITIAL_STRENGTH = 6.0;
    private static final Double DEFAULT_INITIAL_MAGIC = 3.0;
    private static final Double DEFAULT_INITIAL_DEFENSE = 5.0;
    private static final Double DEFAULT_INITIAL_RESISTANCE = 8.0;
    private static final Double DEFAULT_INITIAL_RANGE = 1.0;
    private Double range;
    public Enemy(String name) {
        this(name, DEFAULT_INITIAL_HEALTH, DEFAULT_INITIAL_STRENGTH, DEFAULT_INITIAL_MAGIC, DEFAULT_INITIAL_DEFENSE, DEFAULT_INITIAL_RESISTANCE, DEFAULT_INITIAL_RANGE);
    }
    public Enemy(String name, Double initialHealth, Double initialStrength, Double initialMagic, Double initialDefense, Double initialResistance, Double initialRange)
    {
        super(name, initialHealth, initialStrength, initialMagic, initialDefense, initialResistance);
        this.range = initialRange;
    }
    public Double getRange() {
        return range;
    }
    public void setRange(Double range)
    {
        this.range = range;
    }
}