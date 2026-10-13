package game.scraps.consumable;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.ConsumeAction;
import game.actions.SellAction;
import game.enumerations.Ability;
import game.scraps.Saleable;

/**
 * A class representing a large fruit item that can be consumed by actors in the game.
 * Created by:
 * @author Kok Heng Ng
 */
public class LargeFruit extends Item implements Consumable, Saleable {

    private static final int HEALING_POINT = 2;
    private static final int LARGE_FRUIT_SELLING_PRICE = 30;

    /**
     * Constructor for creating a large fruit item.
     */
    public LargeFruit() {
        super("Large Fruit", 'O', true);
    }

    /**
     * Applies the effect of consuming the large fruit item on the given actor.
     *
     * @param actor the actor consuming the large fruit item
     * @return a message indicating the effect of consuming the large fruit item
     */
    @Override
    public String consumedEffect(Actor actor) {
        actor.heal(HEALING_POINT);
        actor.removeItemFromInventory(this);
        return String.format("consumed %s and %s heals %s by %d points.", this, this, actor, HEALING_POINT);
    }

    /**
     * Applies the effect of selling the Large Fruit item on the given actor which adds credits to the actor's balance and removes it from the inventory in game.
     *
     * @param actor the actor consuming the item
     * @param map the game map where the effect happens
     * @return a message indicating the effect of selling the Large Fruit item
     */
    @Override
    public String soldEffect(Actor actor, GameMap map) {
        actor.addBalance(LARGE_FRUIT_SELLING_PRICE);
        actor.removeItemFromInventory(this);
        return String.format("%s sells %s for %s credits", actor, this, LARGE_FRUIT_SELLING_PRICE);
    }

    /**
     * Overrides the allowableActions method to add a ConsumeAction to the list of actions available to the owner of the LargeFruit.
     *
     * @param owner the actor who owns the large fruit
     * @return a list of allowable actions for the owner of the large fruit
     */
    @Override
    public ActionList allowableActions(Actor owner) {
        ActionList actions = super.allowableActions(owner);
        actions.add(new ConsumeAction(this));
        return actions;
    }

    /**
     * Overrides the allowableActions method to add a SellAction to the list of actions available to the owner of the LargeFruit
     *
     * @param otherActor the other actor the item is sold to
     * @param location the location of the other actor
     * @return a list of allowable actions for the owner of the large fruit
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