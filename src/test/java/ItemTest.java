import game.Item;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {

    @Test
    void getHealing() {
        Item elixir = new Item("Elixir");
        int expectedHeals = 30;
        assertEquals(expectedHeals, elixir.getHealing());
    }

    @Test
    void testIsWeapon() {
        Item potion = new Item("Potion");
        assertFalse(potion.isWeapon());
    }
}