package game.scraps.consumable;

import edu.monash.fit2099.engine.actors.Actor;

/**
 * An interface representing a consumable item in the game.
 * Created by:
 * @author Kok Heng Ng
 */
public interface Consumable {

    /**
     * Applies the effect of consuming the item on the given actor.
     *
     * @param actor the actor consuming the item
     * @return a message indicating the effect of consuming the item
     */
    public String consumedEffect(Actor actor);
}
