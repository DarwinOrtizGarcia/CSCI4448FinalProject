package game.units;

public class Enemy extends Character {
    private static final Double DEFAULT_INITIAL_HEALTH = 10.0;
    private static final Double DEFAULT_INITIAL_STRENGTH = 6.0;
    private static final Double DEFAULT_INITIAL_MAGIC = 3.0;
    private static final Double DEFAULT_INITIAL_DEFENSE = 5.0;
    private static final Double DEFAULT_INITIAL_RESISTANCE = 8.0;
    private static final int DEFAULT_INITIAL_RANGE = 1;
    private static final int DEFAULT_INITIAL_MOVEMENT = 3;
    private static final int[] DEFAULT_INITIAL_POSITION = new int[] {0, 0};

    private int range;
    public Enemy(String name) {
        this(name, DEFAULT_INITIAL_HEALTH, DEFAULT_INITIAL_STRENGTH, DEFAULT_INITIAL_MAGIC, DEFAULT_INITIAL_DEFENSE, DEFAULT_INITIAL_RESISTANCE, DEFAULT_INITIAL_RANGE, DEFAULT_INITIAL_MOVEMENT, DEFAULT_INITIAL_POSITION);
    }
    public Enemy(String name, int[] position) {
        this(name, DEFAULT_INITIAL_HEALTH, DEFAULT_INITIAL_STRENGTH, DEFAULT_INITIAL_MAGIC, DEFAULT_INITIAL_DEFENSE, DEFAULT_INITIAL_RESISTANCE, DEFAULT_INITIAL_RANGE, DEFAULT_INITIAL_MOVEMENT, position);
    }
    public Enemy(String name, Double initialHealth, Double initialStrength, Double initialMagic, Double initialDefense, Double initialResistance, int initialRange, int initialMovement, int[] position)
    {
        super(name, initialHealth, initialStrength, initialMagic, initialDefense, initialResistance, initialMovement, position);
        this.range = initialRange;
    }
    public int getRange() {
        return range;
    }
    public void setRange(int range)
    {
        this.range = range;
    }
}