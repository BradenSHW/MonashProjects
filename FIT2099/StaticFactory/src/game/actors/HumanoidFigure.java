package game.actors;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import game.enumerations.Ability;
import game.enumerations.Status;

/**
 * A class representing the Humanoid Figure.
 * Humanoid Figure cannot be damaged by other actors and actors are able to sell items to it.
 * Created by:
 * @author Kok Heng Ng
 */
public class HumanoidFigure extends Actor {

    private static final int MAX_HEALTH = Integer.MAX_VALUE;

    /**
     * Constructor for creating a HumanoidFigure.
     * Humanoid Figures have infinite health and have capabilities of allowing players to trade with them.
     * Actors are unable to hit them.
     */
    public HumanoidFigure(){
        super("The Entity", 'H', MAX_HEALTH);
        this.addCapability(Ability.CAN_TRADE);
        this.addCapability(Status.PROTECTED_BY_FACTORY);
    }

    /**
     * Humanoid Figure is only capable of doing nothing for now.
     *
     * @param actions    collection of possible Actions for this Actor
     * @param lastAction The Action this Actor took last turn
     * @param map        the map containing the Actor
     * @param display    the I/O object to which messages may be written
     * @return the valid action that can be performed in that iteration or null if no valid action is found
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        return new DoNothingAction();
    }

}
