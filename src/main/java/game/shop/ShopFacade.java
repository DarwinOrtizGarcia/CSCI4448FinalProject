package game.shop;

import game.Item;
import game.units.Allied;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ShopFacade {

    private ShopUI ui;
    private PurchaseItem purchaseItem;
    private static final Logger logger = LoggerFactory.getLogger(ShopFacade.class);

    public ShopFacade(ShopUI ui) {
        this.ui = ui;
        this.purchaseItem = new PurchaseItem();
    }

    public int enterShop(int gold, List<Item> items, Allied units) {

        boolean running = true;

        while (running) {
            ui.displayMenu(gold);
            int option = ui.getInput();

            switch (option) {
                case 1:
                    gold = purchaseItem.buy(gold, items.get(0), units);
                    break;
                case 2:
                    gold = purchaseItem.buy(gold, items.get(1), units);
                    break;
                case 3:
                    gold = purchaseItem.buy(gold, items.get(2), units);
                    break;
                case 4:
                    gold = purchaseItem.buy(gold, items.get(3), units);
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    logger.info("Invalid option.");
            }
        }

        return gold;
    }
}
