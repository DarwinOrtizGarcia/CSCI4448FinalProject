package game.Strategy;
import game.units.Character;
import game.Weapon;

public interface AttackStrategy {
    int attackDamage(Character attacker, Character target);
}
