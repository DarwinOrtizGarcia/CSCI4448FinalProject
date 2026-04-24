package game.shop;

import game.Item;
import game.Weapon;
import game.units.Allied;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PurchaseItem {
    private static final Logger logger = LoggerFactory.getLogger(PurchaseItem.class);

    public int buy(int gold, Item item, Allied unit) {

        if (item == null) {
            logger.info("Item unavailable.");
            return gold;
        }

        if (gold < item.getCost()) {
            logger.info("Not enough gold.");
            return gold;
        }

        gold -= item.getCost();
        logger.info("Purchased " + item.getItemName());


        unit.setUnitItem(item);


        return gold;
    }
}
