package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.Weapon;
import game.enumerations.Status;

import java.util.Random;

/**
 * An action that represents an attack performed by an actor against another actor using a weapon.
 * Created by:
 * @author Kok Heng Ng
 */
public class AttackAction extends Action {

    /**
     * The Actor that is to be attacked.
     */
    private Actor target;

    /**
     * The direction of the attack (only used for display purposes).
     */
    private String direction;

    /**
     * Random number generator.
     */
    private Random rand = new Random();

    /**
     * The weapon used for the attack.
     */
    private Weapon weapon;

    /**
     * Constructor for creating an AttackAction with a specific weapon.
     *
     * @param target    the Actor to attack
     * @param direction the direction where the attack should be performed (only used for display purposes)
     * @param weapon    the weapon used for the attack
     */
    public AttackAction(Actor target, String direction, Weapon weapon) {
        this.target = target;
        this.direction = direction;
        this.weapon = weapon;
    }

    /**
     * Constructor for creating an AttackAction with the actor's intrinsic weapon as default.
     *
     * @param target    the Actor to attack
     * @param direction the direction where the attack should be performed (only used for display purposes)
     */
    public AttackAction(Actor target, String direction) {
        this.target = target;
        this.direction = direction;
    }

    /**
     * Executes the attack action.
     *
     * @param actor the actor performing the attack
     * @param map   the game map where the attack is executed
     * @return a description of the outcome of the attack
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        String result = "";
        if (!target.hasCapability(Status.PROTECTED_BY_FACTORY)) {
            if (weapon == null) {
                weapon = actor.getIntrinsicWeapon();
            }

            if (!(rand.nextInt(100) <= weapon.chanceToHit())) {
                return actor + " misses " + target + ".";
            }

            int damage = weapon.damage();
            result += actor + " " + weapon.verb() + " " + target + " for " + damage + " damage.";
            target.hurt(damage);
            if (!target.isConscious()) {
                result += "\n" + target.unconscious(actor, map);
            }
        }
        else {
            result += target + " is unable to be attacked.";
        }
        return result;
    }

    /**
     * Provides a description of the attack action for display in the menu.
     *
     * @param actor the actor performing the attack
     * @return a description of the attack action
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " attacks " + target + " at " + direction + " with " + (weapon != null ? weapon : actor.getIntrinsicWeapon().toString());
    }
}
