package game.units;

import game.Map;
import game.Strategy.AttackStrategy;
import game.Strategy.PhysicalAttackStrategy;
import game.Weapon;

public class Enemy extends Character {
    private static final int DEFAULT_INITIAL_HEALTH = 10;
    private static final int DEFAULT_INITIAL_STRENGTH = 4;
    private static final int DEFAULT_INITIAL_MAGIC = 4;
    private static final int DEFAULT_INITIAL_DEFENSE = 3;
    private static final int DEFAULT_INITIAL_RESISTANCE = 3;
    private static final int DEFAULT_INITIAL_RANGE = 1;
    private static final int DEFAULT_INITIAL_MOVEMENT = 3;
    private static final int[] DEFAULT_INITIAL_POSITION = new int[] {0, 0};
    private AttackStrategy strategy;
    private int range;
    public Enemy(String name) {
        this(name, DEFAULT_INITIAL_HEALTH, DEFAULT_INITIAL_STRENGTH, DEFAULT_INITIAL_MAGIC, DEFAULT_INITIAL_DEFENSE, DEFAULT_INITIAL_RESISTANCE, DEFAULT_INITIAL_RANGE, DEFAULT_INITIAL_MOVEMENT, DEFAULT_INITIAL_POSITION, new PhysicalAttackStrategy());
    }
    public Enemy(String name, int[] position) {
        this(name, DEFAULT_INITIAL_HEALTH, DEFAULT_INITIAL_STRENGTH, DEFAULT_INITIAL_MAGIC, DEFAULT_INITIAL_DEFENSE, DEFAULT_INITIAL_RESISTANCE, DEFAULT_INITIAL_RANGE, DEFAULT_INITIAL_MOVEMENT, position, new PhysicalAttackStrategy());
    }
    public Enemy(String name, int initialHealth, int initialStrength, int initialMagic, int initialDefense, int initialResistance, int initialRange, int initialMovement, int[] position, AttackStrategy strategy)
    {
        super(name, initialHealth, initialStrength, initialMagic, initialDefense, initialResistance, initialMovement, position);
        this.range = initialRange;
        this.strategy = strategy;
    }
    public int getRange() {
        return range;
    }
    public void setRange(int range)
    {
        this.range = range;
    }
    public AttackStrategy getStrategy() {
        return strategy;
    }
    public void setStrategy(AttackStrategy strategy) {
        this.strategy = strategy;
    }

    public void takeTurn(Map map) {
        Character AlliedCharacter = map.getMainCharacter();
        int[] AlliedLocation = AlliedCharacter.getPosition();
        int[] CharacterLocation = this.getPosition();
        if(isInRange(CharacterLocation, AlliedLocation, this.range))
        {
            this.attack(AlliedCharacter);
            return;
        }
        moveToward(AlliedCharacter, map);
        CharacterLocation = this.getPosition();
        if (isInRange(CharacterLocation, AlliedLocation, this.range)
        ) {
            this.attack(AlliedCharacter);
        }
    }
    private void moveToward(Character target, Map map) {
        int[] myLocation = this.getPosition();
        int targetRow = target.getPosition()[0];
        int targetColumn = target.getPosition()[1];
        int optimalRow = myLocation[0];
        int optimalColumn = myLocation[1];
        int optimalDistance = Integer.MAX_VALUE;
        int movement = this.getMovement();
        for (int Row = -movement; Row <= movement; Row++) {
            for( int Column = -movement; Column <= movement; Column++) {
                if( Math.abs(Row) + Math.abs(Column) > movement ) {
                    continue;
                }
                if(Row == 0 && Column == 0) {
                    continue;
                }
                int newRow = Row + myLocation[0];
                int newColumn = Column + myLocation[1];
                if (newRow < 0 || newRow >= map.getNumRows())
                {
                    continue;
                }
                if (newColumn < 0 || newColumn >= map.getNumColumns())
                {
                    continue;
                }
                if(map.isPositionOccupiedByEnemy(newRow, newColumn))
                {
                    continue;
                }
                if (map.isPositionOccupiedByAlly(newRow, newColumn)) {
                    continue;
                }
                int distance = Math.abs(newRow - targetRow) + Math.abs(newColumn - targetColumn);
                if (distance < optimalDistance) {
                    optimalDistance = distance;
                    optimalRow = newRow;
                    optimalColumn = newColumn;
                }
            }
        }
        this.setPosition(new int[] {optimalRow, optimalColumn});
    }
    @Override
    public void attack(Character target) {
        //To-DO weapon based on character
        //int damage = strategy.attackDamage(this,target, Weapon);
        //damage = Math.max(damage, 0);
        int damage = 1;
        target.setHealth(target.getHealth() - damage);
    }
}