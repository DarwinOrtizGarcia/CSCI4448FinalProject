package game.Strategy;
import game.Weapon;
import game.units.Character;

public class PhysicalAttackStrategy implements AttackStrategy{
    @Override
    public double attackDamage(Character attacker, Character target, Weapon weapon) {
        return attacker.getStrength() + weapon.getMight() - target.getDefense();
    }

}
