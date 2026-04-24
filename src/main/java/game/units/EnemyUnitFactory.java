package game.units;

import java.util.List;

public class EnemyUnitFactory {
    public Enemy createArmor(String name) {return new Enemy(name);}

    public Enemy createWarrior (String name) {return new Enemy(name);}

    public Enemy createSwordsman (String name) {return new Enemy(name);}

    public Enemy createSniper (String name) {return new Enemy(name);}

    public Enemy createMage (String name) {return new Enemy(name);}

    public Enemy createEnemy (String name, int[] position) {return new Enemy(name, position);}

    //Please create this method, just pick types at random and return a list of them, i think it could be anywhere from 1-5
    public List<Enemy> createRandomEnemies (int numEnemies) {}
}