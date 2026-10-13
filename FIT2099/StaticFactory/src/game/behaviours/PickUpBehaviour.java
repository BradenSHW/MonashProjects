package game.behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.Behaviour;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;

import java.util.List;
import java.util.Random;

/**
 * PickUpBehaviour class which implements Behaviour interface. It represents a behaviour to pick up an item randomly on
 * the ground where the NPC is currently standing.
 *
 * Created by:
 * @author Lok Keng Yik
 */
public class PickUpBehaviour implements Behaviour {
    /**
     * Retrieve the list of items on the ground that the NPC is currently standing and randomly pick one item and
     * called getPickUpAction to let the NPC to pick it up. However, if no item on the ground, return null.
     *
     * @param actor the Actor acting
     * @param map the GameMap containing the Actor
     * @return null if no item on the ground, else provide a PickUpAction to pick up the item
     */
    @Override
    public Action getAction(Actor actor, GameMap map) {
        Location here = map.locationOf(actor);
        List<Item> itemsOnHere = here.getItems();
        if (!itemsOnHere.isEmpty()){
            Random random = new Random();
            int indexOfItemToPick = random.nextInt(itemsOnHere.size());
            return itemsOnHere.get(indexOfItemToPick).getPickUpAction(actor);
        }
        return null;  //if no items on the ground

    }
}
