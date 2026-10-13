package game.behaviours;

import java.util.ArrayList;
import java.util.Random;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.actors.Behaviour;

/**
 * A behaviour representing the action of wandering around randomly.
 *
 * Created by:
 * @author Kok Heng Ng
 * @author Lok Keng Yik
 */
public class WanderBehaviour implements Behaviour {

    private final Random random = new Random();

    /**
     * Determines the action to be performed by the actor (usually a creature) to wander to a random adjacent location,
     * if possible. If no movement is possible, returns null.
     *
     * @param actor the actor performing the behaviour
     * @param map   the map containing the actor
     * @return a MoveAction to wander to a random location, or null if no movement is possible
     */
    @Override
    public Action getAction(Actor actor, GameMap map) {
        // Create a list to store possible movement actions
        ArrayList<Action> actions = new ArrayList<>();

        // Iterate over exits from the actor's current location
        for (Exit exit : map.locationOf(actor).getExits()) {
            Location destination = exit.getDestination();
            // If the destination is valid for the actor to enter, add a move action to the list of actions
            if (destination.canActorEnter(actor)) {
                actions.add(exit.getDestination().getMoveAction(actor, "around", exit.getHotKey()));
            }
        }

        // If there are possible movement actions, randomly select one
        if (!actions.isEmpty()) {
            return actions.get(random.nextInt(actions.size()));
        } else {
            // If no movement action is possible, return null
            return null;
        }
    }
}
