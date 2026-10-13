package game.scraps;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;

/**
 * An interface representing item that can be sold by the Player in the game.
 * Created by:
 * @author Kok Heng Ng
 */
public interface Saleable {

    /**
     * Applies the effect after selling the item on the given actor.
     *
     * @param actor the actor consuming the item
     * @param map the game map where the effect happens
     * @return a message indicating the effect of selling the item
     */
    public String soldEffect(Actor actor, GameMap map);

}
