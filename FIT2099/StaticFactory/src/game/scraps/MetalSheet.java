package game.scraps;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.SellAction;
import game.enumerations.Ability;

import java.util.Random;

/**
 * A class representing a metal sheet item in the game.
 * Created by:
 * @author Lok Keng Yik
 */
public class MetalSheet extends Item implements Saleable {

    private static final int METAL_SHEET_SELLING_PRICE = 20;
    private static final int DISCOUNTED_METAL_SHEET_SELLING_PRICE = 10;
    private static final int DISCOUNT_CHANCE = 6;
    private Random random = new Random();

    /**
     * Constructor for creating a metal sheet item.
     */
    public MetalSheet() {
        super("Metal Sheet", '%', true);
    }

    /**
     * Applies the effect of selling the Metal Sheet item on the given actor which adds credits depending on the chance to the actor's balance and removes it from the inventory in game.
     *
     * @param actor the actor consuming the item
     * @param map the game map where the effect happens
     * @return a message indicating the effect of selling the MetalSheet item
     */
    @Override
    public String soldEffect(Actor actor, GameMap map) {
        int soldPrice = (random.nextInt(10) < DISCOUNT_CHANCE) ? DISCOUNTED_METAL_SHEET_SELLING_PRICE : METAL_SHEET_SELLING_PRICE;
        actor.addBalance(soldPrice);
        actor.removeItemFromInventory(this);
        return String.format("%s sells %s for %s credits", actor, this, soldPrice);
    }

    /**
     * Overrides the allowableActions method to add a SellAction to the list of actions available to the owner of the MetalSheet.
     *
     * @param otherActor the other actor
     * @param location the location of the other actor
     * @return a list of the allowable actions for the owner of the MetalSheet.
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
