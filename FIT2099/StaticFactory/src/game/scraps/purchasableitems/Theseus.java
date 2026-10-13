package game.scraps.purchasableitems;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.TeleportAction;
import game.scraps.Teleportable;

import java.util.Random;

/**
 * Class representing a THESEUS
 * Created by:
 * @author Braden Shiew Hao Wen
 */
public class Theseus extends Item implements Purchasable, Teleportable {

    /**
     * The cost of a THESEUS
     */
    private static final int COST = 100;

    /**
     * Constructor of a THESEUS
     */
    public Theseus() {
        super("THESEUS", '^', true);
    }

    /**
     * The logic for teleporting with a THESEUS
     * The actor is teleported to a random location of the current map
     * @param actor the actor being teleported
     * @param map the map the actor is being teleported to
     */
    @Override
    public void teleport(Actor actor, GameMap map) {
        Random rand = new Random();
        int x, y;
        Location destination;

        do {
            x = rand.nextInt(map.getXRange().max() + 1);
            y = rand.nextInt(map.getYRange().max() + 1);
            destination = map.at(x, y);
        }
        while (destination.containsAnActor());

        map.moveActor(actor, destination);
    }

    /**
     * Obtains the cost of a THESEUS
     * @return the cost of a THESEUS
     */
    @Override
    public int getCost() {
        return COST;
    }

    /**
     * Adds the teleport action to a list of allowable actions available to the actor.
     * @param location the location of the ground on which the THESEUS lies
     * @return a list of allowable actions
     */
    @Override
    public ActionList allowableActions(Location location) {
        ActionList actions = super.allowableActions(location);
        actions.add(new TeleportAction(this));
        return actions;
    }

    /**
     * Applies the effect of purchasing a THESEUS.
     * @param actor the actor purchasing a THESEUS.
     * @return the cost of the THESEUS.
     */
    @Override
    public int purchaseEffect(Actor actor) {
        if (COST <= actor.getBalance()) {
            actor.addItemToInventory(this);
        }
        return COST;
    }
}