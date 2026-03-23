package game.units;

public class EnemyUnitFactory {
    public Enemy createArmor(String name) {return new Armor(name);}

    public Enemy createWarrior (String name) {return new Warrior(name);}

    public Enemy createSwordsman (String name) {return new Swordsman(name);}

    public Enemy createSniper (String name) {return new Sniper(name);}

    public Enemy createMage (String name) {return new Mage(name);}

    public Enemy createEnemy (String name) {return new Enemy(name);}
}