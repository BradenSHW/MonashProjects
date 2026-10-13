package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.scraps.Teleportable;

/**
 * A class containing the logic for teleporting.
 * Created by:
 * @author Braden Shiew Hao Wen
 */
public class TeleportAction extends Action {

    /**
     * The item that is teleportable.
     */
    private final Teleportable teleportable;

    /**
     * Constructor for creating a TeleportAction
     * @param teleportable the item that is teleportable
     */
    public TeleportAction(Teleportable teleportable) {
        this.teleportable = teleportable;
    }

    /**
     * Executes the TeleportAction
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return the outcome of the teleportation
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        teleportable.teleport(actor, map);
        return actor + " teleported with " + teleportable;
    }

    /**
     * Displays the option to teleport
     * @param actor The actor performing the action.
     * @return a description of the teleport action
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " teleports with " + teleportable;
    }
}
