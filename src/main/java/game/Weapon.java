package game;

public class Weapon {
    private String weaponName;
    private int might;
    private int range;
    private final boolean isWeapon = true;
    private int cost = 200;



    public String getWeaponName() {
        return weaponName;
    }

    public Weapon (String weaponName){
        switch (weaponName) {
            case "Iron Bow" -> {
                this.weaponName = weaponName;
                this.might = 1;
                this.range = 2;
            }
            case "Steel Bow" -> {
                this.weaponName = weaponName;
                this.might = 3;
                this.range = 2;
                this.cost = 400;
            }
            case "Iron Sword" -> {
                this.weaponName = weaponName;
                this.might = 2;
                this.range = 1;
            }
            case "Steel Sword" -> {
                this.weaponName = weaponName;
                this.might = 4;
                this.range = 1;
                this.cost = 400;
            }
            case "Fire Magic" -> {
                this.weaponName = weaponName;
                this.might = 2;
                this.range = 2;
            }
            case "Thunder Magic" -> {
                this.weaponName = weaponName;
                this.might = 4;
                this.range = 2;
                this.cost = 400;
            }
        }
    }

    public int getMight() {
        return might;
    }

    public int getRange() {
        return range;
    }

    // Setter for Weapon Name (includes logic to set stats based on name)
    public void setWeapon(String weaponName) {
        this.weaponName = weaponName;

        switch (weaponName) {
            case "Iron Bow" -> {
                this.might = 1;
                this.range = 2;
            }
            case "Steel Bow" -> {
                this.might = 3;
                this.range = 2;
            }
            case "Iron Sword" -> {
                this.might = 2;
                this.range = 1;
            }
            case "Steel Sword" -> {
                this.might = 4;
                this.range = 1;
            }
            case "Fire Magic" -> {
                this.might = 2;
                this.range = 2;
            }
            case "Thunder Magic" -> {
                this.might = 4;
                this.range = 2;
            }
        }
    }

    public void setMight(int might) {
        this.might = might;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public int getCost() {
        return this.cost;
    }
}

