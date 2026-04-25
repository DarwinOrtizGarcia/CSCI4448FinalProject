package game.Strategy;
import game.Weapon;
import game.units.Character;

public class PhysicalAttackStrategy implements AttackStrategy{
    @Override
    public int attackDamage(Character attacker, Character target)
    {
        return attacker.getMagic() - target.getResistance();
    }

}
