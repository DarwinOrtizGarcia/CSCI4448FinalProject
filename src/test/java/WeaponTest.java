import game.Weapon;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WeaponTest {
    @Test
    public void testGetAndSetMight() {
        Weapon fireMagic = new Weapon("Fire Magic");
        int expectedMight = 2;
        assertEquals(expectedMight,fireMagic.getMight() );

        fireMagic.setMight(3);
        expectedMight = 3;
        assertEquals(expectedMight,fireMagic.getMight());
    }
    @Test
    public void testGetAndSetRange() {
        Weapon ironBow = new Weapon("Iron Bow");
        int expectedRange = 2;
        assertEquals(expectedRange, ironBow.getRange());

        ironBow.setRange(3);
        expectedRange = 3;
        assertEquals(expectedRange,ironBow.getRange());
    }

    @Test
    public void testGetCost() {
        Weapon steelBow = new Weapon("Steel Bow");
        int expectedCost = 400;
        assertEquals(expectedCost, steelBow.getCost());

    }




}
