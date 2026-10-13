package game.scraps.purchasableitems;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import game.scraps.Saleable;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.SellAction;
import game.enumerations.Ability;
import game.scraps.Saleable;

import java.util.Random;

/**
 * Class representing a ToiletPaperRoll.
 * Created by:
 * @author Braden Shiew Hao Wen
 */
public class ToiletPaperRoll extends Item implements Purchasable, Buggable, Saleable {

    /**
     * The chance of bug when purchasing a ToiletPaperRoll.
     */
    private static final int BUG_CHANCE = 75;

    /**
     * The cost of a ToiletPaperRoll.
     */
    private static final int COST = 5;
    private Random rand = new Random();

    private static final int TOILET_PAPER_ROLL_SELLING_PRICE = 1;
    private static final int MURDER_CHANCE = 5;
    private static final int INSTANT_KILL_DAMAGE = Integer.MAX_VALUE;

    /**
     * Constructor of a ToiletPaperRoll.
     */
    public ToiletPaperRoll() {
        super("Toilet Paper Roll", 's', true);
    }

    /**
     * Obtains the cost of a ToiletPaperRoll.
     * @return the cost of a ToiletPaperRoll.
     */
    @Override
    public int getCost() {
        return COST;
    }

    /**
     * The chance of the bug occurring when purchasing a ToiletPaperRoll.
     * @return the chance of the bug occurring when purchasing a ToiletPaperRoll.
     */
    @Override
    public boolean bugChance() {
        return rand.nextInt(100) < BUG_CHANCE;
    }

    /**
     *The new cost of the ToiletPaperRoll after the bug.
     * @return the new cost of the ToiletPaperRoll after the bug.
     */
    @Override
    public int bug() {
        int bugCost = 1;
        System.out.println("The system bugged and Toilet Paper Roll costs only $1");
        return bugCost;
    }

    /**
     * Applies the effect of the actor purchasing a ToiletPaperRoll.
     * @param actor the actor purchasing a ToiletPaperRoll.
     * @return the cost of the ToiletPaperRoll.
     */
    @Override
    public int purchaseEffect(Actor actor) {
        int cost = COST;
        if (bugChance())
            cost = bug();
        if (cost <= actor.getBalance()){
            actor.addItemToInventory(this);
        }
        return cost;
    }

    /**
     * Applies the effect of selling Toilet Paper Roll item on the given actor which adds 1 credit to the actor's balance or the actor gets instantly killed out of the game.
     *
     * @param actor the actor consuming the item
     * @param map the game map where the effect happens
     * @return a message indicating the effect of selling Toilet Paper Roll item
     */
    @Override
    public String soldEffect(Actor actor, GameMap map) {
        boolean isMurdered = rand.nextInt(10) < MURDER_CHANCE;
        actor.removeItemFromInventory(this);
        if (isMurdered) {
            actor.hurt(INSTANT_KILL_DAMAGE);
            return actor.unconscious(map);
        }
        actor.addBalance(TOILET_PAPER_ROLL_SELLING_PRICE);
        return String.format("%s sells %s for %s credits", actor, this, TOILET_PAPER_ROLL_SELLING_PRICE);
    }

    /**
     * Overrides the allowableActions method to add a SellAction to the list of actions available to the owner of the ToiletPaperRoll.
     *
     * @param otherActor the other actor
     * @param location the location of the other actor
     * @return a list of the allowable actions for the owner of the Toilet Paper Roll.
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
