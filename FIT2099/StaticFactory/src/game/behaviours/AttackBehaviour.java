package game.behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.Behaviour;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.AttackAction;
import game.enumerations.Status;

/**
 * A behaviour representing the action of attacking a hostile actor within the vicinity.
 * Created by:
 * @author Kok Heng Ng
 * @author Lok Keng Yik
 */
public class AttackBehaviour implements Behaviour {

    /**
     * Determines the action to be performed by the actor (usually a hostile creature) if there is a hostile actor nearby.
     *
     * @param actor the actor performing the behaviour
     * @param map   the map containing the actor
     * @return an AttackAction targeting a nearby hostile actor if one is found, otherwise null
     */
    @Override
    public Action getAction(Actor actor, GameMap map) {
        // Iterate over exits from the actor's current location
        for (Exit exit : map.locationOf(actor).getExits()) {
            Location destination = exit.getDestination();
            Actor target = destination.getActor();
            // If a hostile actor is found, return an AttackAction targeting that actor
            if (target != null && target.hasCapability(Status.HOSTILE_TO_ENEMY)) {
                return new AttackAction(target, destination.toString());
            }
        }
        // If no hostile actor is found nearby, return null
        return null;
    }
}
