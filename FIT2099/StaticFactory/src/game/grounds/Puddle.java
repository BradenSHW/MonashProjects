package game.grounds;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.attributes.ActorAttributeOperations;
import edu.monash.fit2099.engine.actors.attributes.BaseActorAttributes;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.ConsumeAction;
import game.scraps.consumable.Consumable;

/**
 * A class that represents a puddle which increases the maximum health of the actor when consumed the water from puddle by the actor.
 * Created by:
 * @author Kok Heng Ng
 */
public class Puddle extends Ground implements Consumable {

    /**
     * Constructor for creating Puddle ground
     */
    public Puddle() {
        super('~');
    }

    /**
     * Applies the effect of consuming the water from the puddle on the given actor.
     *
     * @param actor the actor consuming the water from the puddle
     * @return a message indicating the effect of consuming the water from the puddle
     */
    @Override
    public String consumedEffect(Actor actor) {
        actor.modifyAttributeMaximum(BaseActorAttributes.HEALTH, ActorAttributeOperations.INCREASE, 1);
        return String.format("drinks from %s. %s feels invigorated", this, actor);
    }

    /**
     * Textual representation of the object
     *
     * @return a string indicating the representation of the object
     */
    @Override
    public String toString() {
        return "A random puddle of water";
    }

    /**
     * Overrides the allowableActions method to add a ConsumeAction to the list of actions available to the actor which currently stays exactly at the Puddle.
     *
     * @param actor the actor that stays at the Puddle
     * @param location the current location where Puddle is located
     * @param direction the direction of the Puddle from the Actor
     * @return a list of the allowable actions for the actor which currently stays exactly on the Puddle ground
     */
    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction) {
        ActionList actions = new ActionList();
        if (location.getActor() == actor) {
            actions.add(new ConsumeAction(this));
        }
        return actions;
    }
}
