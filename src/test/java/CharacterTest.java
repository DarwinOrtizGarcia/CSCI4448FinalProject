
import game.units.*;
import game.units.Character;
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
        assertEquals("Iron Sword", ally.getEquippedWeapon().getWeaponName());
    }
    @Test
    public void testEnemyFromFactory() {
        EnemyUnitFactory factory = new EnemyUnitFactory();
        Enemy mage = factory.createMage(null);
        assertEquals(8, mage.getHealth());
        assertEquals(2, mage.getRange());
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
    @Test
    public void testIsInRange(){

        int[] characterPosition = {1,1};
        int[] targetPosition = {2,1};
        Character arthur = new Character("Arthur",1,1,1,1,1,1,characterPosition);

        assertTrue(arthur.isInRange(characterPosition,targetPosition,2));


    }
    @Test
    public void testAttack(){
        int[] characterPosition = {1,1};
        int[] targetPosition = {2,1};
        Character arthur = new Character("Arthur",5,5,5,5,5,5,characterPosition);
        Enemy punk = new Enemy("Punk", targetPosition);
        int defaultEnemyHP = punk.getHealth();
        arthur.attack(punk);
        assert(punk.getHealth()<defaultEnemyHP);
    }
    @Test
    public void testSetStats(){
        int[] characterPosition = {1,1};
        Character arthur = new Character("Arthur",1,1,1,1,1,1,characterPosition);
        arthur.setHealth(5);
        arthur.setDefense(6);
        arthur.setMagic(7);
        arthur.setStrength(8);
        arthur.setResistance(9);
        arthur.setMovement(4);
        assertEquals(5, arthur.getHealth());
        assertEquals(6, arthur.getDefense());
        assertEquals(7, arthur.getMagic());
        assertEquals(8, arthur.getStrength());
        assertEquals(9, arthur.getResistance());
        assertEquals(4, arthur.getMovement());
    }
}