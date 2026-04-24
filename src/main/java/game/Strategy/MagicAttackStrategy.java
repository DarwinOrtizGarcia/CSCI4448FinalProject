package game.Strategy;
import game.Weapon;
import game.units.Character;

public class MagicAttackStrategy implements AttackStrategy{
    @Override
    public double attackDamage(Character attacker, Character target, Weapon weapon)
    {
        return attacker.getMagic() + weapon.getMight() - target.getResistance();
    }
}
