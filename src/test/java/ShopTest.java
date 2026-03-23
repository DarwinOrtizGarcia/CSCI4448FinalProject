import game.Item;
import game.units.Allied;
import game.units.AlliedUnitFactory;
import game.shop.ShopFacade;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ShopTest {
    AlliedUnitFactory alliedUnitFactory = new AlliedUnitFactory();

    @Test
    void testRoll() {
        Allied joe = alliedUnitFactory.createAlly("joe")
        ShopFacade shopFacade = new ShopFacade();
        List<Item> items = new ArrayList<>();
        items.add(new Item("Steel Bow"));
        items.add(new Item("Steel Sword"));
        items.add(new Item("Thunder Magic"));
        items.add(new Item("Potion"));
        shopFacade.enterShop(1000, items, joe);
    }
}
