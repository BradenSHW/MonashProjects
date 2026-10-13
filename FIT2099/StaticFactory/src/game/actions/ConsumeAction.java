package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.scraps.consumable.Consumable;

/**
 * An action that represents the consumption of a consumable item by an actor.
 * Created by:
 * @author Kok Heng Ng
 */
public class ConsumeAction extends Action {

    /** The consumable item to be consumed. */
    private Consumable consumable;

    /**
     * Constructor for creating a ConsumeAction.
     *
     * @param consumable the consumable item to be consumed
     */
    public ConsumeAction(Consumable consumable) {
        this.consumable = consumable;
    }

    /**
     * Executes the consume action.
     *
     * @param actor the actor performing the consumption
     * @param map   the game map where the consumption is performed
     * @return a description of the outcome of the consumption
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        String result = actor + " ";
        result += consumable.consumedEffect(actor);
        return result;
    }

    /**
     * Provides a description of the consume action for display in the menu.
     *
     * @param actor the actor performing the consumption
     * @return a description of the consume action
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " consumes " + consumable;
    }
}
