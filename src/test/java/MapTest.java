import game.Map;
import game.units.Allied;
import game.units.AlliedUnitFactory;
import game.units.Enemy;
import game.units.EnemyUnitFactory;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

public class MapTest {
    @Test
    public void testConstructor() {
        AlliedUnitFactory aFactory = new AlliedUnitFactory();
        EnemyUnitFactory eFactory = new EnemyUnitFactory();
        Allied arthur = aFactory.createAllyWithPos("Arthur", new int[]{0, 0});
        Enemy joe = eFactory.createEnemy("Joe", new int[]{1, 1});
        Map map = Map.getNewBuilder().setDimensions(4,4).addAlly(arthur).addEnemy(joe).build();
        assertNotNull(map);

        map.displayMap();
        assert(map.getNumColumns()==4);
        assert(map.getNumRows()==4);

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
        assert !Objects.equals(joe.getPosition(), new int[]{1, 1});

    }
    @Test
    public void testGetCharacter(){
        AlliedUnitFactory aFactory = new AlliedUnitFactory();
        Allied arthur = aFactory.createAllyWithPos("Mike", new int[]{0, 0});

        Map map = Map.getNewBuilder().addAlly(arthur).build();
        assertEquals(map.getMainCharacter(), arthur);
    }

    @Test
    public void testGetEnemies(){
        EnemyUnitFactory eFactory = new EnemyUnitFactory();
        Enemy joe = eFactory.createEnemy("Joe", new int[]{1, 1});
        Enemy schmoe = eFactory.createEnemy("Schmoe", new int[]{2, 2});
        Map map = Map.getNewBuilder().addEnemy(joe).addEnemy(schmoe).build();
        List<Enemy> expectedEnemyList = new ArrayList<>();
        expectedEnemyList.add(joe);
        expectedEnemyList.add(schmoe);
        List<Enemy> actualEnemyList = new ArrayList<>();
        actualEnemyList = map.getEnemies();
        assertEquals(actualEnemyList,expectedEnemyList);

    }

    @Test
    public void testAddEnemiesRandom(){
        EnemyUnitFactory enemyUnitFactory = new EnemyUnitFactory();
        Enemy joe = enemyUnitFactory.createEnemy("Joe", new int[]{1, 1});
        Enemy schmoe = enemyUnitFactory.createEnemy("Schmoe", new int[]{1, 1});
        List<Enemy> enemyList = new ArrayList<>();
        enemyList.add(joe);
        enemyList.add(schmoe);
        Map map = Map.getNewBuilder().addMultipleEnemiesRandomPosition(enemyList).build();
        assert(map.getEnemies().size() == 2);

    }


}
