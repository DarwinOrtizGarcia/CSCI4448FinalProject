import game.Item;
import game.shop.ShopUI;
import game.units.Allied;
import game.units.AlliedUnitFactory;
import game.shop.ShopFacade;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ShopTest {
    AlliedUnitFactory alliedUnitFactory = new AlliedUnitFactory();

    @Test
    void testShop() {
        String testInput = "4\n5\n";
        //this simulates input 4 to buy a Potion, and then 5 to quit the shop
        Scanner testScanner = new Scanner(testInput);

        ShopUI testUI = new ShopUI(testScanner);
        ShopFacade shopFacade = new ShopFacade(testUI);
        Allied joe = alliedUnitFactory.createAlly("joe");

        List<Item> items = new ArrayList<>();
        items.add(new Item("Steel Bow"));
        items.add(new Item("Steel Sword"));
        items.add(new Item("Thunder Magic"));
        items.add(new Item("Potion"));

        int startingGold = 1000;

        int finalGold = shopFacade.enterShop(startingGold, items, joe);

        //1000 - 500
        int expectedGold = startingGold - items.get(3).getCost();

        assertEquals(expectedGold, finalGold);

    }
    @Test
    void testTooPoorShop() {
        String testInput = "4\n5\n";
        //this simulates input 4 to buy a Potion, and then 5 to quit the shop
        Scanner testScanner = new Scanner(testInput);

        ShopUI testUI = new ShopUI(testScanner);
        ShopFacade shopFacade = new ShopFacade(testUI);
        Allied joe = alliedUnitFactory.createAlly("joe");

        List<Item> items = new ArrayList<>();
        items.add(new Item("Steel Bow"));
        items.add(new Item("Steel Sword"));
        items.add(new Item("Thunder Magic"));
        items.add(new Item("Potion"));

        int startingGold = 400;

        int finalGold = shopFacade.enterShop(startingGold, items, joe);

        //400 - 500 will reject the transaction and keep original gold

        assertEquals(startingGold, finalGold);

    }

}
