package game.scraps.purchasableitems;

import edu.monash.fit2099.engine.actors.Actor;

import java.util.ArrayList;

/**
 * An interface for actor/item/ground that have monologue.
 * Created by:
 *
 * @author Lok Keng Yik
 */

public interface Monologue {
    /**
     * Get the monologues in arraylist.
     *
     * @param actor the actor that wants to listen to the monologue
     * @return an arraylist of string that consist of the monologues
     */
    ArrayList<String> getMonologue(Actor actor);
}
