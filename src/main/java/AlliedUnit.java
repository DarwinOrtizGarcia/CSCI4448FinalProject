public class AlliedUnit {
    private String name;
    private int hp;
    private int strength;
    private int magic;
    private int defense;
    private int resistance;
    private int movement;
    private Weapon equippedWeapon;
    private Item heldItem;

    public AlliedUnit() {
        name = "DEFAULT";
        hp = 50;
        strength = 50;
        magic = 50;
        defense = 50;
        resistance = 50;
        movement = 2;
        equippedWeapon = null;
        this.heldItem = null;
    }

    public AlliedUnit(String name, int hp, int strength, int magic, int defense, int resistance, int movement) {
        this.name = name;
        this.hp = hp;
        this.strength = strength;
        this.magic = magic;
        this.defense = defense;
        this.resistance = resistance;
        this.movement = movement;
        this.equippedWeapon = null;
        this.heldItem = null;
    }

    public String getName() {
        return name;
    }

    public Weapon getUnitWeapon() {
        return equippedWeapon;
    }

    public Item getUnitItem() {return heldItem;}

    public int getHP() {
        return hp;
    }

    public int getStrength() {
        return strength;
    }

    public int getMagic() {
        return magic;
    }

    public int getDefense() {
        return defense;
    }

    public int getResistance() {
        return resistance;
    }

    public int getMovement() {
        return movement;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUnitWeapon(Weapon newWeapon) {
        equippedWeapon = newWeapon;
    }

    public  void setUnitItem(Item newItem) {
        heldItem = newItem;
    }

    public void setHP(int hp) {
        this.hp = hp;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setMagic(int magic) {
        this.magic = magic;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public void setResistance(int resistance) {
        this.resistance = resistance;
    }
}
