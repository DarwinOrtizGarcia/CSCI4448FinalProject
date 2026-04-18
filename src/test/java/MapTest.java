import game.Map;
import game.units.Allied;
import game.units.AlliedUnitFactory;
import game.units.Enemy;
import game.units.EnemyUnitFactory;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MapTest {
    @Test
    public void testConstructor() {
        AlliedUnitFactory aFactory = new AlliedUnitFactory();
        EnemyUnitFactory eFactory = new EnemyUnitFactory();
        Allied arthur = aFactory.createAllyWithPos("Arthur", new int[]{0, 0});
        Enemy joe = eFactory.createEnemy("Joe", new int[]{1, 1});
        Map map = Map.getNewBuilder().addAlly(arthur).addEnemy(joe).build();
        assertNotNull(map);
        map.displayMap();

    }
    @Test
    public void testMovement() {
        AlliedUnitFactory aFactory = new AlliedUnitFactory();
        EnemyUnitFactory eFactory = new EnemyUnitFactory();
        Allied arthur = aFactory.createAllyWithPos("Arthur", new int[]{0, 0});
        Enemy joe = eFactory.createEnemy("Joe", new int[]{1, 1});
        Map map = Map.getNewBuilder().addAlly(arthur).addEnemy(joe).build();
        map.displayMap();
        joe.MoveOnMap(map);
        map.displayMap();

    }


}
