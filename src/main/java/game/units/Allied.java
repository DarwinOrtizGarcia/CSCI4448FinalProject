package game.units;
import game.Weapon;
import game.Item;

public class Allied extends Character {
    private static final Double DEFAULT_INITIAL_HEALTH = 50.0;
    private static final Double DEFAULT_INITIAL_STRENGTH = 50.0;
    private static final Double DEFAULT_INITIAL_MAGIC = 50.0;
    private static final Double DEFAULT_INITIAL_DEFENSE = 50.0;
    private static final Double DEFAULT_INITIAL_RESISTANCE = 50.0;
    private static final Double DEFAULT_INITIAL_MOVEMENT = 2.0;
    private static final String DEFAULT_INITIAL_EQUIPPEDWEAPON = "";
    private Double movement;
    private String equippedWeapon;
    public Allied(String name) {
        this(name, DEFAULT_INITIAL_HEALTH, DEFAULT_INITIAL_STRENGTH, DEFAULT_INITIAL_MAGIC, DEFAULT_INITIAL_DEFENSE, DEFAULT_INITIAL_RESISTANCE, DEFAULT_INITIAL_MOVEMENT, DEFAULT_INITIAL_EQUIPPEDWEAPON);
    }
    public Allied(String name, Double initialHealth, Double initialStrength, Double initialMagic, Double initialDefense, Double initialResistance, Double initialMovement, String initialequippedWeapon)
    {
        super(name, initialHealth, initialStrength, initialMagic, initialDefense, initialResistance);
        this.movement = initialMovement;
        this.equippedWeapon = initialequippedWeapon;
    }

    public String getEquippedWeapon() {
        return equippedWeapon;
    }
    public void setEquippedWeapon(String equippedWeapon) {
        this.equippedWeapon = equippedWeapon;
    }

    public Double getMovement() {
        return movement;
    }
    public void setMovement(Double movement) {
        this.movement = movement;
    }

    public void setUnitWeapon (Weapon weapon){
        this.equippedWeapon = weapon.getWeapon();
    }
    public void setUnitItem(Item item) {
        this.setHealth(this.getHealth() + item.getHealing());
    }
}