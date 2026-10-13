package game.actors;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.behaviours.AttackBehaviour;

/**
 * A class representing a hostile creature, Suspicious Astronaut, in the game.
 * Suspicious Astronauts are capable of attacking other actors and will instant kill them
 * Created by:
 * @author Cheng Shun Yi
 * @author Go Wei Zheng
 */
public class SuspiciousAstronaut extends HostileCreature {
    /**
     * Constructor for SuspiciousAstronaut.
     * Suspicious Astronauts have a default hit points of 99 and an intrinsic weapon that susses with damage equivalent to java's maximum value
     * They also have a WandererBehaviour by default
     */
    public SuspiciousAstronaut() {
        super("Suspicious Astronaut", 'ඞ', 99);
        this.behaviours.put(0, new AttackBehaviour());
    }

    /**
     * Retrieves the intrinsic weapon of the Suspicious Astronaut.
     *
     * @return the intrinsic weapon of the Suspicious Astronaut.
     */
    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(Integer.MAX_VALUE, "susses", 100);
    }
}