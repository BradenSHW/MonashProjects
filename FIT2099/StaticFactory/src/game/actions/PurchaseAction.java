package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.scraps.purchasableitems.Purchasable;

/**
 * A class containing the logic for purchasing an item.
 * Created by:
 * @author Braden Shiew Hao Wen
 */

public class PurchaseAction extends Action {

    /**
     * The item that is purchasable.
     */
    private Purchasable purchasable;

    /**
     * Constructor for creating a PurchaseAction.
     * @param purchasable the item that is purchasable.
     */
    public PurchaseAction(Purchasable purchasable){
        this.purchasable = purchasable;
    }

    /**
     * Executes the PurchaseAction.
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return the outcome of the purchase
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        int cost = purchasable.purchaseEffect(actor);
        int balanceDiff = actor.getBalance() - cost;
        if (balanceDiff >= 0) {
            actor.deductBalance(cost);
            return String.format("%s successfully purchased %s for $%d", actor, purchasable, cost);
        }
        return String.format("%s has insufficient funds to purchase %s", actor, purchasable);
    }

    /**
     * Displays the option to purchase an item in the menu.
     * @param actor The actor performing the action.
     * @return a description of the purchase action.
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " purchases " + purchasable + String.format(" for $%d", purchasable.getCost());
    }
}