package game.scraps.purchasableitems;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import game.actions.ConsumeAction;
import game.scraps.consumable.Consumable;

import java.util.Random;

/**
 * Class representing an EnergyDrink.
 * Created by:
 * @author Braden Shiew Hao Wen
 */
public class EnergyDrink extends Item implements Consumable, Purchasable, Buggable {

    /**
     * The amount of healing an EnergyDrink provides.
     */
    private static final int HEALING_POINT = 1;

    /**
     * The chance of bug when purchasing an EnergyDrink.
     */
    private static final int BUGCHANCE = 20;

    /**
     * The cost of an EnergyDrink.
     */
    private static final int COST = 10;

    private Random rand = new Random();

    /**
     * Constructor of an EnergyDrink.
     */
    public EnergyDrink(){
        super("Energy Drink", '*', true);
    }

    /**
     * Obtains the cost of an EnergyDrink.
     * @return the cost of an EnergyDrink.
     */
    @Override
    public int getCost() {
        return COST;
    }

    /**
     * Applies the effect of the actor consuming the EnergyDrink.
     * @param actor the actor consuming the item
     * @return the message indicating the effect of consuming the EnergyDrink.
     */
    @Override
    public String consumedEffect(Actor actor) {
        actor.heal(HEALING_POINT);
        actor.removeItemFromInventory(this);
        return String.format("%s heals %s by %d points", this, actor, HEALING_POINT);
    }

    /**
     * Adds the consume EnergyDrink action to a list of actions available to the actor.
     * @param owner the actor that owns the item
     * @return a list of allowable actions.
     */
    @Override
    public ActionList allowableActions(Actor owner) {
        ActionList actions = super.allowableActions(owner);
        actions.add(new ConsumeAction(this));
        return actions;
    }

    /**
     * The chance of the bug occurring when purchasing an EnergyDrink.
     * @return the chance of the bug occurring when purchasing an EnergyDrink.
     */
    @Override
    public boolean bugChance(){
        return rand.nextInt(100) < BUGCHANCE;
    }

    /**
     *The new cost of the EnergyDrink after the bug.
     * @return the new cost of the EnergyDrink after the bug.
     */
    @Override
    public int bug() {
        int bugCost = getCost() * 2;
        System.out.println("The system bugged and Energy Drink costs double the price");
        return bugCost;
    }

    /**
     * Applies the effect of the actor purchasing an EnergyDrink.
     * @param actor the actor purchasing an EnergyDrink.
     * @return the cost of the EnergyDrink.
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
}