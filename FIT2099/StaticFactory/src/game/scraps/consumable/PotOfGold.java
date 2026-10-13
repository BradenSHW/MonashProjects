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

import java.util.Random;

/**
 * A class representing a pot of gold scrap item that adds 10 credits to the actor's balance when consumed by the actor in game.
 * Created by:
 * @author Kok Heng Ng
 */
public class PotOfGold extends Item implements Consumable, Saleable {

    private static final int CONSUME_CREDIT_POINT = 10;
    private static final int POT_OF_GOLD_SELLING_PRICE = 500;
    private static final int SCAM_CHANCE = 25;
    private Random random = new Random();

    /**
     * Constructor for creating a pot of gold item
     */
    public PotOfGold(){
        super("Pot of Gold", '$', true);
    }

    /**
     * Applies the effect of consuming the Pot of Gold item on the given actor and removes the item from actor's inventory.
     *
     * @param actor the actor consuming the pot of gold item
     * @return a message indicating the effect of consuming the pot of gold item
     */
    @Override
    public String consumedEffect(Actor actor) {
        actor.addBalance(CONSUME_CREDIT_POINT);
        actor.removeItemFromInventory(this);
        return String.format("empties out Pot of Gold and gains %d credits. The rest are withheld as tax by the factory.", CONSUME_CREDIT_POINT);
    }

    /**
     * Applies the effect of selling the Pot of Gold item on the given actor which adds credits to the actor's balance, or the player gets scammed and removes it from the inventory in game.
     *
     * @param actor the actor consuming the item
     * @param map the game map where the effect happens
     * @return a message indicating the effect of selling the Pot of Gold item
     */
    @Override
    public String soldEffect(Actor actor, GameMap map) {
        boolean isScammed = random.nextInt(100) < SCAM_CHANCE;
        actor.removeItemFromInventory(this);
        if (isScammed) {
            return String.format("%s gets scammed.", actor);
        }
        actor.addBalance(POT_OF_GOLD_SELLING_PRICE);
        return String.format("%s sells %s for %s credits", actor, this, POT_OF_GOLD_SELLING_PRICE);
    }

    /**
     * Overrides the allowableActions method to add a ConsumeAction to the list of actions available to the owner of the PotOfGold.
     *
     * @param owner the actor that owns the Pot of Gold
     * @return a list of the allowable actions for the owner of the Pot Of Gold.
     */
    @Override
    public ActionList allowableActions(Actor owner) {
        ActionList actions = super.allowableActions(owner);
        actions.add(new ConsumeAction(this));
        return actions;
    }

    /**
     * Overrides the allowableActions method to add a SellAction to the list of actions available to the owner of the PotOfGold.
     *
     * @param otherActor the other actor
     * @param location the location of the other actor
     * @return a list of the allowable actions for the owner of the Pot Of Gold.
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