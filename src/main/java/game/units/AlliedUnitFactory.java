package game.units;

import game.Weapon;

public class AlliedUnitFactory {
    public Allied createAlly(String name) {return new Allied(name);}
    //(String name, int initialHealth, int initialStrength, int initialMagic, int initialDefense, int initialResistance, int initialMovement,int[] initialPosition, String initialequippedWeapon)
    public Allied createToughAlly(String name) {return new Allied(name, 12, 3, 2, 5, 2, 3, new int[]{0, 0}, new Weapon("Iron Sword"));}
    public Allied createArcherAlly(String name) {return new Allied(name, 10, 2, 2, 2, 3, 4, new int[]{0, 0}, new Weapon ("Iron Bow"));}
    public Allied createFighterAlly(String name) {return new Allied(name, 10, 3, 2, 3, 2, 4, new int[]{0, 0}, new Weapon("Iron Sword"));}
    public Allied createMageAlly(String name) {return new Allied(name, 8, 1, 4, 2, 5, 4, new int[]{0, 0}, new Weapon("Fire Magic"));}

    public Allied createAllyWithPos(String name, int[] position) {return new Allied(name, position);}
}