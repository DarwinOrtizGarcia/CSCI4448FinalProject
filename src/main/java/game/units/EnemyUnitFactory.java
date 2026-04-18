package game.units;

public class EnemyUnitFactory {
    public Enemy createArmor(String name) {return new Enemy(name);}

    public Enemy createWarrior (String name) {return new Enemy(name);}

    public Enemy createSwordsman (String name) {return new Enemy(name);}

    public Enemy createSniper (String name) {return new Enemy(name);}

    public Enemy createMage (String name) {return new Enemy(name);}

    public Enemy createEnemy (String name, int[] position) {return new Enemy(name, position);}
}