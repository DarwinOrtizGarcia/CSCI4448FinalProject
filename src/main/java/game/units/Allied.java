package game.units;
import game.Weapon;
import game.Item;
import game.Strategy.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Allied extends Character {
    private static final Logger logger = LoggerFactory.getLogger(Allied.class);
    private static final int DEFAULT_INITIAL_HEALTH = 10;
    private static final int DEFAULT_INITIAL_STRENGTH = 2;
    private static final int DEFAULT_INITIAL_MAGIC = 2;
    private static final int DEFAULT_INITIAL_DEFENSE = 2;
    private static final int DEFAULT_INITIAL_RESISTANCE = 2;
    private static final int DEFAULT_INITIAL_MOVEMENT = 4;
    private static final int[] DEFAULT_INITIAL_POSITION = new int[] {0, 0};
    private Weapon equippedWeapon;
    private Item heldItem = null;
    public Allied(String name) {
        this(name, DEFAULT_INITIAL_HEALTH, DEFAULT_INITIAL_STRENGTH, DEFAULT_INITIAL_MAGIC, DEFAULT_INITIAL_DEFENSE, DEFAULT_INITIAL_RESISTANCE, DEFAULT_INITIAL_MOVEMENT, DEFAULT_INITIAL_POSITION, new Weapon("Iron Sword"));
    }
    public Allied(String name, int[] position) {
        this(name, DEFAULT_INITIAL_HEALTH, DEFAULT_INITIAL_STRENGTH, DEFAULT_INITIAL_MAGIC, DEFAULT_INITIAL_DEFENSE, DEFAULT_INITIAL_RESISTANCE, DEFAULT_INITIAL_MOVEMENT, position, new Weapon("Iron Sword"));
    }
    public Allied(String name, int initialHealth, int initialStrength, int initialMagic, int initialDefense, int initialResistance, int initialMovement,int[] initialPosition, Weapon initialequippedWeapon)
    {
        super(name, initialHealth, initialStrength, initialMagic, initialDefense, initialResistance, initialMovement, initialPosition);
        this.equippedWeapon = initialequippedWeapon;
    }
    public Weapon getEquippedWeapon() {
        return equippedWeapon;
    }
    public void setEquippedWeapon(Weapon equippedWeapon) {
        this.equippedWeapon = equippedWeapon;
    }

    public void setUnitWeapon (Weapon weapon){
        this.equippedWeapon = weapon;
    }
    public void setUnitItem(Item item) {
        this.heldItem = item;
    }
    @Override
    public void attack(Character target) {
        int damage;
        if(this.getEquippedWeapon().getWeaponName().contains("Magic"))
        {
             damage = this.getMagic() + this.getEquippedWeapon().getMight() - target.getResistance();
        }
        else
        {
             damage = this.getStrength() + this.getEquippedWeapon().getMight() - target.getDefense();
        }
        damage = Math.max(damage, 0);
        target.setHealth(target.getHealth() - damage);
        logger.info(this.getName() + " attacked " + target.getName() + " for " + damage + " damage. " + target.getName() + " remaining HP: " + target.getHealth());
    }
    public boolean hasPotion() {
        return heldItem != null;
    }

    public void usePotion() {
        if (hasPotion()) {
            int newHealth = this.getHealth() + heldItem.getHealing();
            this.setHealth(newHealth);
            logger.info(this.getName() + " used a Potion and healed " + heldItem.getHealing() + " HP. Current  HP: " + this.getHealth());
            heldItem = null;
        }
    }
}