import game.Strategy.MagicAttackStrategy;
import game.Weapon;
import game.units.Allied;
import game.units.AlliedUnitFactory;
import game.units.Enemy;
import game.units.EnemyUnitFactory;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AlliedEnemyTest {
    AlliedUnitFactory alliedUnitFactory = new AlliedUnitFactory();
    EnemyUnitFactory enemyUnitFactory = new EnemyUnitFactory();

    @Test
    public void testAttack() {

        Allied joe = alliedUnitFactory.createAlly("joe");
        Enemy yuri = enemyUnitFactory.createEnemy("yuri", new int[]{1, 1});
        Weapon bow = new Weapon("Steel Bow");
        joe.setEquippedWeapon(bow);
        int initialEnemyHealth = yuri.getHealth();
        joe.attack(yuri);
        assert (yuri.getHealth()<initialEnemyHealth);

        int beforeHitPlayerHealth = joe.getHealth();
        yuri.attack(joe);
        assert (joe.getHealth()<beforeHitPlayerHealth);
    }

    @Test
    public void testSetEnemyRange(){
        Enemy ron = enemyUnitFactory.createEnemy("ron", new int[]{1, 1});
        ron.setRange(4);
        assert ron.getRange()==4;
        MagicAttackStrategy magicAttackStrategy = new MagicAttackStrategy();
        ron.setStrategy(magicAttackStrategy);
        assertEquals(magicAttackStrategy, ron.getStrategy());
    }

    @Test
    public void testFactories(){
        Allied joe = alliedUnitFactory.createArcherAlly("Joe");
        Allied jude = alliedUnitFactory.createFighterAlly("Jude");
        Allied milla = alliedUnitFactory.createToughAlly("Milla");
        Allied sophie  = alliedUnitFactory.createMageAlly("Sophie");

        Enemy rah = enemyUnitFactory.createArmorKnight(new int[]{1, 1});
        Enemy yuu = enemyUnitFactory.createSniper(new int[]{2, 1});
        Enemy doy = enemyUnitFactory.createWarrior(new int[]{3, 1});

        assertEquals(10, joe.getHealth());
        assertEquals(3, jude.getStrength());
        assertEquals(3, milla.getStrength());
        assertEquals(4, sophie.getMagic());

        assertEquals(12, rah.getHealth());
        assertEquals(4, doy.getStrength());
        assertEquals(2, yuu.getRange());

        List<Enemy> enemyList = enemyUnitFactory.createRandomEnemies(2);
        assertEquals(2, enemyList.size());

    }






}
