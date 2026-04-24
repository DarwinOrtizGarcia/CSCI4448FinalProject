package game.units;
import game.Map;
import game.Weapon;
import game.Item;
import game.Strategy.*;


public class Allied extends Character {
    private static final Double DEFAULT_INITIAL_HEALTH = 50.0;
    private static final Double DEFAULT_INITIAL_STRENGTH = 50.0;
    private static final Double DEFAULT_INITIAL_MAGIC = 50.0;
    private static final Double DEFAULT_INITIAL_DEFENSE = 50.0;
    private static final Double DEFAULT_INITIAL_RESISTANCE = 50.0;
    private static final int DEFAULT_INITIAL_MOVEMENT = 2;
    private static final int[] DEFAULT_INITIAL_POSITION = new int[] {0, 0};
    private static final String DEFAULT_INITIAL_EQUIPPEDWEAPON = "";
    private static AttackStrategy strategy = new PhysicalAttackStrategy();
    private String equippedWeapon;
    public Allied(String name) {
        this(name, DEFAULT_INITIAL_HEALTH, DEFAULT_INITIAL_STRENGTH, DEFAULT_INITIAL_MAGIC, DEFAULT_INITIAL_DEFENSE, DEFAULT_INITIAL_RESISTANCE, DEFAULT_INITIAL_MOVEMENT, DEFAULT_INITIAL_POSITION, DEFAULT_INITIAL_EQUIPPEDWEAPON,strategy);
    }
    public Allied(String name, int[] position) {
        this(name, DEFAULT_INITIAL_HEALTH, DEFAULT_INITIAL_STRENGTH, DEFAULT_INITIAL_MAGIC, DEFAULT_INITIAL_DEFENSE, DEFAULT_INITIAL_RESISTANCE, DEFAULT_INITIAL_MOVEMENT, position, DEFAULT_INITIAL_EQUIPPEDWEAPON,strategy);
    }
    public Allied(String name, Double initialHealth, Double initialStrength, Double initialMagic, Double initialDefense, Double initialResistance, int initialMovement,int[] initialPosition, String initialequippedWeapon, AttackStrategy strategy)
    {
        super(name, initialHealth, initialStrength, initialMagic, initialDefense, initialResistance, initialMovement, initialPosition, strategy);
        this.equippedWeapon = initialequippedWeapon;
        Allied.strategy = null;
    }
    public String getEquippedWeapon() {
        return equippedWeapon;
    }
    public void setEquippedWeapon(String equippedWeapon) {
        this.equippedWeapon = equippedWeapon;
    }

    public void setUnitWeapon (Weapon weapon){
        this.equippedWeapon = weapon.getWeapon();
        if(weapon.getWeapon().contains("Magic")){
            this.setStrategy(new MagicAttackStrategy());
        }
        else{
            this.setStrategy(new PhysicalAttackStrategy());
        }
    }
    public AttackStrategy getStrategy() {
        return strategy;
    }
    public void setStrategy(AttackStrategy strategy) {
        this.strategy = strategy;
    }

    public void attack(Character target, Weapon weapon){
        AttackStrategy attackStrategy = target.getStrategy();
        double damage = attackStrategy.attackDamage(this, target, weapon);
        target.setHealth(target.getHealth() - damage);
    }
    public void setUnitItem(Item item) {
        this.setHealth(this.getHealth() + item.getHealing());
    }

//    public Enemy checkForTargets(Map map){
//        if (map.getMainUnitColPosition() == map.getEnemy1ColPosition() || map.getMainUnitColPosition() == map.getEnemy2ColPosition())
//    }
}