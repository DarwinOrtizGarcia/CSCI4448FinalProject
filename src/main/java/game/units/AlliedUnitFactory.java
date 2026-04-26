package game.units;

import game.Weapon;

public class AlliedUnitFactory {
    public Allied createAlly(String name) {return new Allied(name);}
    //(String name, int initialHealth, int initialStrength, int initialMagic, int initialDefense, int initialResistance, int initialMovement,int[] initialPosition, String initialequippedWeapon)
    public Allied createToughAlly(String name) {return new Allied(name, 15, 4, 2, 4, 1, 3, new int[]{0, 0}, new Weapon("Iron Sword"));}
    public Allied createArcherAlly(String name) {return new Allied(name, 12, 2, 2, 2, 3, 5, new int[]{0, 0}, new Weapon ("Iron Bow"));}
    public Allied createFighterAlly(String name) {return new Allied(name, 14, 3, 2, 3, 2, 4, new int[]{0, 0}, new Weapon("Iron Sword"));}
    public Allied createMageAlly(String name) {return new Allied(name, 10, 1, 4, 2, 4, 4, new int[]{0, 0}, new Weapon("Fire Magic"));}

    public Allied createAllyWithPos(String name, int[] position) {return new Allied(name, position);}
}