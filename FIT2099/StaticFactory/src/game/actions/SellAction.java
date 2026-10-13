package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.scraps.Saleable;

/**
 * An action that represents an actor selling the item in the game.
 * Created by:
 * @author Kok Heng Ng
 */
public class SellAction extends Action {

    /**
     * The item to be sold.
     */
    private Saleable saleable;

    /**
     * Constructor for creating a SellAction.
     *
     * @param saleable the item to be sold
     */
    public SellAction(Saleable saleable){
        this.saleable = saleable;
    }

    /**
     * Executes the sell action.
     *
     * @param actor The actor selling the item
     * @param map The map the actor is on.
     * @return a description of the outcome of selling the item
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        return saleable.soldEffect(actor, map);
    }

    /**
     * Provides a description of the sell action for display in the menu
     *
     * @param actor The actor performing the action.
     * @return a description of the sale action
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " sells " + saleable;
    }
}
