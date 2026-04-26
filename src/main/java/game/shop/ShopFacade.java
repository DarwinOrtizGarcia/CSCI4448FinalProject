package game.shop;

import game.Item;
import game.Weapon;
import game.units.Allied;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ShopFacade {

    private ShopUI ui;
    private PurchaseItem purchaseItem;
    private PurchaseWeapon purchaseWeapon;
    private static final Logger logger = LoggerFactory.getLogger(ShopFacade.class);

    public ShopFacade(ShopUI ui) {
        this.ui = ui;
        this.purchaseItem = new PurchaseItem();
        this.purchaseWeapon = new PurchaseWeapon();
    }

    public int enterShop(int gold, Allied unit) {

        boolean running = true;
        logger.info("Welcome to the shop! You can purchase any weapon but be aware that your character is more effective with weapons suited for their class!");
        logger.info("Any weapons here are stronger than their default counterparts.");

        Weapon steelSword = new Weapon("Steel Sword");
        Weapon steelBow = new Weapon("Steel Bow");
        Weapon thunderMagic = new Weapon("Thunder Magic");
        Weapon ruinMagic = new Weapon("Ruin Magic");
        Item potion = new Item("Potion");

        while (running) {
            ui.displayMenu(gold);
            int option = ui.getInput();

            switch (option) {
                case 1:
                    gold = purchaseWeapon.buy(gold, steelBow, unit);
                    break;
                case 2:
                    gold = purchaseWeapon.buy(gold, steelSword, unit);
                    break;
                case 3:
                    gold = purchaseWeapon.buy(gold, thunderMagic, unit);
                    break;
                case 4:
                    gold = purchaseWeapon.buy(gold, ruinMagic, unit);
                    break;
                case 5:
                    gold = purchaseItem.buy(gold, potion, unit);
                    break;
                case 6:
                    running = false;
                    break;
                default:
                    logger.info("Invalid option.");
            }
        }

        return gold;
    }
}
