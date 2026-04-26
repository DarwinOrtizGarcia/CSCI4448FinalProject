package game;

public class Item {
    private String itemName;
    private int healing;
    private int stat;// stat is for if I am able to get the basics working, I would like to add an extra feature of Items that permanently increase a Unit's Stats (ex: +1 to strength)
    private int cost;
    private final boolean isWeapon = false;

    public Item(String itemName) {
        this.itemName = itemName;

        if (itemName.equals("Potion")) {
            healing = 10;
            cost = 500;
        } else if (itemName.equals("Elixir")) {
            healing = 30;
            cost = 1000;
        }
    }

    public String getItemName() {
        return itemName;
    }

    public int getHealing() {
        return healing;
    }

    public int getCost() {return cost;}

    public boolean isWeapon() {
        return isWeapon;
    }

}
