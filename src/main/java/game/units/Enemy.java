package game.units;

import game.Strategy.AttackStrategy;
import game.Strategy.PhysicalAttackStrategy;

public class Enemy extends Character {
    private static final int DEFAULT_INITIAL_HEALTH = 10;
    private static final int DEFAULT_INITIAL_STRENGTH = 4;
    private static final int DEFAULT_INITIAL_MAGIC = 4;
    private static final int DEFAULT_INITIAL_DEFENSE = 3;
    private static final int DEFAULT_INITIAL_RESISTANCE = 3;
    private static final int DEFAULT_INITIAL_RANGE = 1;
    private static final int DEFAULT_INITIAL_MOVEMENT = 3;
    private static final int[] DEFAULT_INITIAL_POSITION = new int[] {0, 0};
    private static final AttackStrategy strategy = new PhysicalAttackStrategy();
    private int range;
    public Enemy(String name) {
        this(name, DEFAULT_INITIAL_HEALTH, DEFAULT_INITIAL_STRENGTH, DEFAULT_INITIAL_MAGIC, DEFAULT_INITIAL_DEFENSE, DEFAULT_INITIAL_RESISTANCE, DEFAULT_INITIAL_RANGE, DEFAULT_INITIAL_MOVEMENT, DEFAULT_INITIAL_POSITION, strategy);
    }
    public Enemy(String name, int[] position) {
        this(name, DEFAULT_INITIAL_HEALTH, DEFAULT_INITIAL_STRENGTH, DEFAULT_INITIAL_MAGIC, DEFAULT_INITIAL_DEFENSE, DEFAULT_INITIAL_RESISTANCE, DEFAULT_INITIAL_RANGE, DEFAULT_INITIAL_MOVEMENT, position, strategy);
    }
    public Enemy(String name, int initialHealth, int initialStrength, int initialMagic, int initialDefense, int initialResistance, int initialRange, int initialMovement, int[] position, AttackStrategy strategy)
    {
        super(name, initialHealth, initialStrength, initialMagic, initialDefense, initialResistance, initialMovement, position, strategy);
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