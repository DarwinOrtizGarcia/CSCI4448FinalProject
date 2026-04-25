package game.shop;

import game.Item;
import game.Weapon;
import game.units.Allied;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PurchaseWeapon {
    private static final Logger logger = LoggerFactory.getLogger(PurchaseWeapon.class);

    public int buy(int gold, Weapon weapon, Allied unit) {

        if (weapon == null) {
            logger.info("Item unavailable.");
            return gold;
        }

        if (gold < weapon.getCost()) {
            logger.info("Not enough gold.");
            return gold;
        }

        gold -= weapon.getCost();
        logger.info("Purchased " + weapon.getWeaponName());


        unit.setUnitWeapon(weapon);


        return gold;
    }
}
