public class Item {
    private String itemName;
    private int healing;
    private int stat; // stat is for if I am able to get the basics working, I would like to add an extra feature of Items that permanently increase a Unit's Stats (ex: +1 to strength)

    public Item() {
        itemName = "DEFAULT";
        healing = 0;
        stat = 0;
    }

    public Item(String itemName) {
        this.itemName = itemName;

        if (itemName.equals("Vulnerary")) {
            healing = 10;
        } else if (itemName.equals("Elixir")) {
            healing = 30;
        }
    }

    public String getItem() {
        return itemName;
    }

    public int getHealing() {
        return healing;
    }

    public void setItem(String itemName) {
        this.itemName = itemName;

        if (itemName.equals("Vulnerary")) {
            healing = 10;
        } else if (itemName.equals("Elixir")) {
            healing = 30;
        }
    }
}
