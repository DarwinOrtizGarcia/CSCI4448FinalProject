import game.units.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CharacterTest {
    @Test
    public void testEnemyDefault() {
        Enemy ogre = new Enemy("Ogre");
        assertEquals(10.0, ogre.getHealth());
        assertEquals(1.0, ogre.getRange());
    }
    @Test
    public void testAlliedDefaultStats() {
        Allied ally = new Allied("Hero");
        assertEquals(10, ally.getHealth());
        assertEquals(4, ally.getMovement());
        assertEquals("", ally.getEquippedWeapon());
    }
    @Test
    public void testEnemyFromFactory() {
        EnemyUnitFactory factory = new EnemyUnitFactory();
        Enemy mage = factory.createMage(null);
        assertEquals(8, mage.getHealth());
        assertEquals(1, mage.getRange());
     }
     @Test
    public void testSetHealthUpdates() {
        Enemy goblin = new Enemy("Goblin");
        goblin.setHealth(5);
        assertEquals(5, goblin.getHealth());
     }
    @Test
    public void testAlliedFactoryCreatesCorrectName() {
        AlliedUnitFactory factory = new AlliedUnitFactory();
        Allied ally = factory.createAlly("Arthur");
        assertEquals("Arthur", ally.getName());
    }
}