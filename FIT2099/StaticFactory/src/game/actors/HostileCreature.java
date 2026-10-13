package game.actors;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.Behaviour;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.behaviours.AttackBehaviour;
import game.actions.AttackAction;
import game.behaviours.WanderBehaviour;
import game.enumerations.Status;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * An abstract class representing a hostile creature in the game.
 * Hostile creatures are capable of attacking other actors.
 * Created by:
 * @author Kok Heng Ng
 */
public abstract class HostileCreature extends Actor {

    /** A mapping of behaviour priorities to behaviours for the hostile creature. */
    protected Map<Integer, Behaviour> behaviours = new TreeMap<>();

    /**
     * Constructor for creating a HostileCreature.
     *
     * @param name       the name of the creature
     * @param displayChar the character used to represent the creature on the map
     * @param hitPoints  the hit points of the creature
     */
    public HostileCreature(String name, char displayChar, int hitPoints) {
        super(name, displayChar, hitPoints);
        this.behaviours.put(999, new WanderBehaviour());
    }

    /**
     * Selects a valid action to perform at each turn.
     *
     * @param actions    collection of possible Actions for this Actor
     * @param lastAction The Action this Actor took last turn
     * @param map        the map containing the Actor
     * @param display    the I/O object to which messages may be written
     * @return the valid action that can be performed in that iteration or null if no valid action is found
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        for (Behaviour behaviour : behaviours.values()) {
            Action action = behaviour.getAction(this, map);
            if (action != null)
                return action;
        }
        // If no action is found, do nothing
        return new DoNothingAction();
    }

    /**
     * Returns a list of allowable actions for the hostile creature when interacting with other actors.
     *
     * @param otherActor the other actor involved in the interaction
     * @param direction  the direction to the other actor
     * @param map        the map containing the hostile creature
     * @return a list of allowable actions for the interaction
     */
    @Override
    public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
        ActionList actions = new ActionList();
        // If the other actor is hostile to the enemy, add an attack action
        if (otherActor.hasCapability(Status.HOSTILE_TO_ENEMY)) {
            actions.add(new AttackAction(this, direction));
        }
        return actions;
    }


}
