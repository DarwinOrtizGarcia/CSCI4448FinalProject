package game;

public class Weapon extends Item {
    private String weaponName;
    private int might;
    private int range;
    private final boolean isWeapon = true;

    public Weapon() {
        this.weaponName = "UNARMED";
        this.might = 0;
        this.range = 1;
    }

    public Weapon(String wpnName) {
        this.setWeapon(wpnName);
    }

    public String getWeapon() {
        return weaponName;
    }

    public int getMight() {
        return might;
    }

    public int getRange() {
        return range;
    }

    // Setter for Weapon Name (includes logic to set stats based on name)
    public void setWeapon(String weaponNamepnName) {
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
}

