package game.scraps.weaponscraps;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.actions.AttackAction;


/**
 * A class representing weapon scraps that can be used as weapons by actors in the game.
 * Created by:
 * @author Kok Heng Ng
 */
public class WeaponScraps extends WeaponItem {

    /**
     * Constructor for creating weapon scraps.
     *
     * @param name        the name of the weapon scraps
     * @param displayChar the character representing the weapon scraps in the UI
     * @param damage      the damage inflicted by the weapon scraps
     * @param verb        the verb describing the action performed by the weapon scraps
     * @param hitRate     the hit rate of the weapon scraps
     */
    public WeaponScraps(String name, char displayChar, int damage, String verb, int hitRate) {
        super(name, displayChar, damage, verb, hitRate);
    }

    /**
     * Overrides the allowableActions method to add AttackActions to the list of actions available to the owner of the weapon scraps.
     *
     * @param otherActor the actor to which the actions are allowable
     * @param location   the location at which the actions are allowable
     * @return a list of allowable actions for the owner of the weapon scraps
     */
    @Override
    public ActionList allowableActions(Actor otherActor, Location location) {
        ActionList actions = new ActionList();
        actions.add(new AttackAction(otherActor, location.toString(), this));
        return actions;
    }
}