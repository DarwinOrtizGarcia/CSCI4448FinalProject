public class EnemyUnit {
    private String name;
    private String type;
    private int hp;
    private int strength;
    private int magic;
    private int defense;
    private int resistance;
    private int range;

    public EnemyUnit() {
        type = "DEFAULT";
        hp = 50;
        strength = 50;
        magic = 50;
        defense = 50;
        resistance = 50;
        range = 1;
    }

    public EnemyUnit(String name, String type) {
        this.name = name;
        this.type = type;

        switch (type) {
            case "Armor":
                hp = 20;
                strength = 8;
                magic = 3;
                defense = 5;
                resistance = 8;
                range = 1;
                break;
            case "Warrior":
                hp = 15;
                strength = 9;
                magic = 5;
                defense = 4;
                resistance = 10;
                range = 1;
                break;
            case "Swordsman":
                hp = 20;
                strength = 8;
                magic = 3;
                defense = 10;
                resistance = 9;
                range = 1;
                break;
            case "Sniper":
                hp = 12;
                strength = 7;
                magic = 4;
                defense = 4;
                resistance = 10;
                range = 2;
                break;
            case "Mage":
                hp = 15;
                strength = 5;
                magic = 15;
                defense = 7;
                resistance = 15;
                range = 2;
                break;
            default:
                // Default values if needed
                break;
        }
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

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

    public int getRange() {
        return range;
    }

    public void setName(String name) {
        this.name = name;
    }

    /*
    Sets an enemy's stats based in the passed in type string.
    */
    public void setTypeStats(String type) {
        this.type = type;

        switch (type) {
            case "Armor":
                // stats are currently placeholders, once I have decided proper stats for balance, they will be updated. These values just give a rough idea. (applies for all types)
                hp = 25;
                strength = 15;
                magic = 3;
                defense = 20;
                resistance = 8;
                break;
            case "Warrior":
                hp = 25;
                strength = 18;
                magic = 5;
                defense = 12;
                resistance = 10;
                break;
            case "Swordsman":
                hp = 20;
                strength = 25;
                magic = 3;
                defense = 10;
                resistance = 9;
                break;
            case "Archer":
                hp = 15;
                strength = 8;
                magic = 4;
                defense = 12;
                resistance = 10;
                break;
            case "Mage":
                hp = 15;
                strength = 5;
                magic = 15;
                defense = 7;
                resistance = 15;
                break;
            default:
                // Default or unknown type handling if needed
                break;
        }
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
