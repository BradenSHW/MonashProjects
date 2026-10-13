package game.scraps;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.SellAction;
import game.enumerations.Ability;

/**
 * A class representing a large bolt item in the game.
 * Created by:
 * @author Lok Keng Yik
 */
public class LargeBolt extends Item implements Saleable {

    private static final int LARGE_BOLT_SELLING_PRICE = 25;

    /**
     * Constructor for creating a large bolt item.
     */
    public LargeBolt() {
        super("Large Bolt", '+', true);
    }

    /**
     * Applies the effect of selling Large Bolt item on the given actor which adds credits to the actor's balance in the game
     *
     * @param actor the actor consuming the item
     * @param map the game map where the effect happens
     * @return a message indicating the effect of selling Large Bolt item
     */
    @Override
    public String soldEffect(Actor actor, GameMap map) {
        actor.addBalance(LARGE_BOLT_SELLING_PRICE);
        actor.removeItemFromInventory(this);
        return String.format("%s sells %s for %s credits", actor, this, LARGE_BOLT_SELLING_PRICE);
    }

    /**
     * Overrides the allowableActions method to add a SellAction to the list of actions available to the owner of the LargeBolt.
     *
     * @param otherActor the other actor
     * @param location the location of the other actor
     * @return a list of the allowable actions for the owner of the LargeBolt.
     */
    @Override
    public ActionList allowableActions(Actor otherActor, Location location) {
        ActionList actions = super.allowableActions(otherActor, location);
        if (otherActor.hasCapability(Ability.CAN_TRADE)) {
            actions.add(new SellAction(this));
        }
        return actions;
    }
}
