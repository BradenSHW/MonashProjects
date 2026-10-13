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
 * A class that represents a jar of pickle scrap item that heals/hurts the actor depends on the expiry date when consumed by the actors in the game
 * Created By:
 * @author Kok Heng Ng
 */
public class JarOfPickles extends Item implements Consumable, Saleable {

    private static final int HEALING_POINT = 1;
    private static final int EXPIRY_CHANCE = 5;
    private Random random = new Random();
    private boolean isExpired;
    private static final int JAR_OF_PICKLES_PRICE = 25;
    private static final int JAR_OF_PICKLES_SPECIAL_PRICE = 50;
    private static final int SPECIAL_PRICE_CHANCE = 5;

    /**
     * Constructor for creating a Jar of Pickles item.
     */
    public JarOfPickles() {
        super("Jar of Pickles", 'n', true);
        this.isExpired = random.nextInt(10) < EXPIRY_CHANCE;
    }

    /**
     * Applies the effect of consuming the Jar of Pickles item on the given actor depending on the expiry state and removes the item from actor's inventory. Hurts the actor if it is expired, heals otherwise.
     *
     * @param actor the actor consuming the Jar of Pickles item
     * @return a message indicating the effect of consuming the Jar of Pickles item
     */
    @Override
    public String consumedEffect(Actor actor) {
        String result = "";
        if (isExpired) {
            actor.hurt(HEALING_POINT);
            result += String.format("consumed an expired %s. %s feels sick.", this, actor);
        }
        else {
            actor.heal(HEALING_POINT);
            result += String.format("consumed %s and %s heals %s by %d points.", this, this, actor, HEALING_POINT);
        }
        actor.removeItemFromInventory(this);
        return result;
    }

    /**
     * Applies the effect of selling the Jar of Pickles item on the given actor which adds credits depending on the chance to the actor's balance and removes it from the inventory in game.
     *
     * @param actor the actor consuming the item
     * @param map the game map where the effect happens
     * @return a message indicating the effect of selling the Jar of Pickles item
     */
    @Override
    public String soldEffect(Actor actor, GameMap map) {
        int soldPrice = (random.nextInt(10) < SPECIAL_PRICE_CHANCE) ? JAR_OF_PICKLES_SPECIAL_PRICE : JAR_OF_PICKLES_PRICE;
        actor.addBalance(soldPrice);
        actor.removeItemFromInventory(this);
        return String.format("%s sells %s for %s credits", actor, this, soldPrice);
    }

    /**
     * Overrides the allowableActions method to add a ConsumeAction to the list of actions available to the owner of the JarOfPickles.
     *
     * @param owner the actor that owns the Jar of Pickles
     * @return a list of the allowable actions for the owner of the Jar of Pickles
     */
    @Override
    public ActionList allowableActions(Actor owner) {
        ActionList actions = super.allowableActions(owner);
        actions.add(new ConsumeAction(this));
        return actions;
    }

    /**
     * Overrides the allowableActions method to add a SellAction to the list of actions available to the owner of the JarOfPickles
     *
     * @param otherActor the other actor the item is sold to
     * @param location the location of the other actor
     * @return a list of allowable actions for the owner of the Jar Of Pickles
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