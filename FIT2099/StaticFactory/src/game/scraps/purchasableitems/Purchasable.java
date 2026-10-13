package game.scraps.purchasableitems;

import edu.monash.fit2099.engine.actors.Actor;

/**
 * An interface representing a purchasable item in the game.
 * Created by:
 * @author Braden Shiew Hao Wen
 */
public interface Purchasable {

    /**
     * Obtains the cost of the item.
     * @return the cost of the item.
     */
    int getCost();

    /**
     * Applies the effect of the actor purchasing an item.
     * @param actor the actor purchasing an item.
     * @return the cost of the item.
     */
    int purchaseEffect(Actor actor);
}
