import game.units.Allied;
import game.units.AlliedUnitFactory;
import game.units.Enemy;
import game.units.EnemyUnitFactory;
import org.junit.jupiter.api.Test;

public class StrategyTest {
    AlliedUnitFactory alliedUnitFactory = new AlliedUnitFactory();
    EnemyUnitFactory enemyUnitFactory = new EnemyUnitFactory();

    @Test
    public void testMagicStrategy() {
        Allied joe = alliedUnitFactory.createAlly("joe");
        Enemy ron = enemyUnitFactory.createWarrior(new int[]{1, 1});
        int damage = ron.getStrategy().attackDamage(ron,joe);
        assert(damage >= 1);
    }
    @Test
    public void testPhysicalStrategy() {
        Allied karol = alliedUnitFactory.createAlly("Karol");
        Enemy ragou = enemyUnitFactory.createMage(new int[]{1, 1});
        int damage = ragou.getStrategy().attackDamage(ragou,karol);
        assert(damage >= 1);
    }
}
