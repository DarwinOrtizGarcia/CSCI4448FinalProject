package game.shop;

import game.Item;
import game.Weapon;

public class PurchaseItem {

    public int buy(int gold, Item item, Allied unit) {

        if (item == null) {
            System.out.println("Item unavailable.");
            return gold;
        }

        if (gold < item.getCost()) {
            System.out.println("Not enough gold.");
            return gold;
        }

        gold -= item.getCost();
        System.out.println("Purchased " + item.getItemName());

        if (item.isWeapon()) {
            unit.setUnitWeapon((Weapon) item);

            System.out.println(unit.getName() + " equipped " + item.getItemName());
        }
        else{
            unit.setUnitItem(item);
        }

        return gold;
    }
}
