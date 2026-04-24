package game.Strategy;
import game.units.Character;
import game.Weapon;

public interface AttackStrategy {
    double attackDamage(Character attacker, Character target, Weapon weapon);
}
