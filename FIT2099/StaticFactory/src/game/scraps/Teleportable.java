package game.scraps;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;

/**
 * An interface representing a teleportale item in the game.
 * Created by:
 * @author Braden Shiew Hao Wen
 */
public interface Teleportable {

    /**
     * Teleports an actor to a specific point of a map
     * @param actor the actor being teleported
     * @param map the map the actor is being teleported to
     */
    void teleport(Actor actor, GameMap map);
}
