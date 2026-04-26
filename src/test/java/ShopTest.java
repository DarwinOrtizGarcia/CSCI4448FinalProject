import game.Weapon;
import game.shop.PurchaseWeapon;
import game.shop.ShopUI;
import game.units.Allied;
import game.units.AlliedUnitFactory;
import game.shop.ShopFacade;
import org.junit.jupiter.api.Test;


import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ShopTest {
    AlliedUnitFactory alliedUnitFactory = new AlliedUnitFactory();

    @Test
    void testShop() {
        String testInput = "5\n6\n";
        //this simulates input 4 to buy a Potion, and then 5 to quit the shop
        Scanner testScanner = new Scanner(testInput);

        ShopUI testUI = new ShopUI(testScanner);
        ShopFacade shopFacade = new ShopFacade(testUI);
        Allied joe = alliedUnitFactory.createAlly("joe");

        int startingGold = 1000;

        int finalGold = shopFacade.enterShop(startingGold, joe);

        //1000 - 500
        int potionCost = 500;
        int expectedGold = startingGold - potionCost;

        assertEquals(expectedGold, finalGold);

    }
    @Test
    void testTooPoorShop() {
        String testInput = "5\n6\n";
        //this simulates input 5 to buy a Potion, and then 6 to quit the shop
        Scanner testScanner = new Scanner(testInput);

        ShopUI testUI = new ShopUI(testScanner);
        ShopFacade shopFacade = new ShopFacade(testUI);
        Allied joe = alliedUnitFactory.createAlly("joe");


        int startingGold = 400;

        int finalGold = shopFacade.enterShop(startingGold, joe);

        //400 - 500 will reject the transaction and keep original gold

        assertEquals(startingGold, finalGold);

    }
    @Test
    public void testBuyWeapon(){
        PurchaseWeapon purchaseWeapon = new PurchaseWeapon();
        Allied joe = alliedUnitFactory.createAlly("joe");
        int startingGold = 500;
        Weapon thunderMagic = new Weapon("Thunder Magic");

        int remainingGold = purchaseWeapon.buy(startingGold, thunderMagic, joe);
        int expectedGold =  startingGold - thunderMagic.getCost();
        assertEquals(expectedGold, remainingGold);
    }

}
