package game.scraps.weaponscraps;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.SellAction;
import game.enumerations.Ability;
import game.scraps.Saleable;

/**
 * A class representing a metal pipe, a type of weapon scraps that can be used as a weapon by actors in the game.
 * Created by:
 * @author Kok Heng Ng
 */
public class MetalPipe extends WeaponScraps implements Saleable {

    private static final int METAL_PIPE_SELLING_PRICE = 35;

    /**
     * Constructor for creating a metal pipe.
     */
    public MetalPipe() {
        super("Metal Pipe", '!', 1, "struck", 20);
    }

    /**
     * Applies the effect of selling Metal Pipe item on the given actor which adds credits to the actor's balance in the game
     *
     * @param actor the actor consuming the item
     * @param map the game map where the effect happens
     * @return a message indicating the effect of selling Metal Pipe item
     */
    @Override
    public String soldEffect(Actor actor, GameMap map) {
        actor.addBalance(METAL_PIPE_SELLING_PRICE);
        actor.removeItemFromInventory(this);
        return String.format("%s sells %s for %s credits", actor, this, METAL_PIPE_SELLING_PRICE);
    }

    /**
     * Overrides the allowableActions method to add a SellAction to the list of actions available to the owner of the MetalPipe.
     *
     * @param otherActor the other actor
     * @param location the location of the other actor
     * @return a list of the allowable actions for the owner of the MetalPipe.
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
