package game.shop;

import game.Item;
import game.units.Allied;

import java.util.List;

public class ShopFacade {

    private ShopUI ui;
    private PurchaseItem purchaseItem;

    public ShopFacade() {
        this.ui = new ShopUI();
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
                    System.out.println("Invalid option.");
            }
        }

        return gold;
    }
}
