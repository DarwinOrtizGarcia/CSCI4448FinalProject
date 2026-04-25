package game.units;

import game.Map;
import game.Strategy.MagicAttackStrategy;
import game.Strategy.PhysicalAttackStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EnemyUnitFactory {
    Random rand = new Random();
    MagicAttackStrategy magicAttackStrategy = new MagicAttackStrategy();
    PhysicalAttackStrategy physicalAttackStrategy = new PhysicalAttackStrategy();

    public Enemy createArmored(int[] position) {return new Enemy("Armored", 12, 5, 2, 3, 1, 1, 2, position, physicalAttackStrategy);}

    public Enemy createWarrior (int[] position) {return new Enemy("Warrior", 10, 4, 2, 2, 2, 1, 3, position, physicalAttackStrategy);}

    public Enemy createSniper (int[] position) {return new Enemy("Sniper", 10, 3, 2, 2, 2, 2, 3, position, physicalAttackStrategy);}

    public Enemy createMage (int[] position) {return new Enemy("Mage", 8, 1, 3, 1, 4, 2, 3, position, magicAttackStrategy);}

    public Enemy createEnemy (String name, int[] position) {return new Enemy(name, position);}

    public List<Enemy> createRandomEnemies (int numEnemies) {
        List<Enemy> enemies = new ArrayList<>();
        for (int i = 0; i < numEnemies; i++) {
            int randomZeroToThree = rand.nextInt(4);
            switch(randomZeroToThree) {
                case 0: enemies.add(createArmored(null)); break;
                case 1: enemies.add(createWarrior(null)); break;
                case 2: enemies.add(createSniper(null)); break;
                case 3: enemies.add(createMage(null)); break;
            }
        }
        return enemies;



    }
}