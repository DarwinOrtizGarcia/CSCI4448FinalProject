package game.units;

public class AlliedUnitFactory {
    public Allied createAlly(String name) {return new Allied(name);}
    public Allied createAllyWithPos(String name, int[] position) {return new Allied(name, position);}
}