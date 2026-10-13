package game.actors;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.attributes.BaseActorAttributes;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.displays.Menu;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.FancyMessage;
import game.enumerations.Ability;
import game.enumerations.Status;

/**
 * Class representing the Player.
 * Created by:
 * @author Kok Heng Ng
 * @author Braden Shiew Hao Wen
 */
public class Player extends Actor {
    /**
     * Constructor for creating a Player.
     *
     * @param name        Name to call the player in the UI
     * @param displayChar Character to represent the player in the UI
     * @param hitPoints   Player's starting number of hitpoints
     */
    public Player(String name, char displayChar, int hitPoints) {
        super(name, displayChar, hitPoints);
        this.addCapability(Status.HOSTILE_TO_ENEMY);
        this.addCapability(Ability.CAN_ENTER_SPACESHIP);
    }

    /**
     * Determines the action to be performed by the player in each turn.
     *
     * @param actions    collection of possible Actions for the player
     * @param lastAction the Action the player took last turn
     * @param map        the map containing the player
     * @param display    the I/O object to which messages may be written
     * @return the Action chosen by the player for the current turn
     */
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        // Handle multi-turn Actions
        if (lastAction.getNextAction() != null)
            return lastAction.getNextAction();

        // Display player's status and show menu for selecting actions
        Menu menu = new Menu(actions);
        display.println(String.format("%s\nHP: %s/%s\nBalance: %s", this.name, this.getAttribute(BaseActorAttributes.HEALTH), this.getAttributeMaximum(BaseActorAttributes.HEALTH), this.getBalance()));
        return menu.showMenu(this, display);
    }

    /**
     * Overrides the unconscious method to provide a custom message when the player becomes unconscious.
     *
     * @param actor the actor that caused the player to become unconscious
     * @param map   the map containing the player
     * @return a message indicating the player is unconscious
     */
    @Override
    public String unconscious(Actor actor, GameMap map) {
        return super.unconscious(actor, map) + String.format("\n%s", FancyMessage.YOU_ARE_FIRED);
    }

    /**
     * Overrides the unconscious method to provide a custom message when the player becomes unconscious.
     *
     * @param map the map containing the player
     * @return a message indicating the player is unconscious
     */
    @Override
    public String unconscious(GameMap map) {
        return super.unconscious(map) + String.format("\n%s", FancyMessage.YOU_ARE_FIRED);
    }

    /**
     * The Player's default attack stats
     * @return the Player's default attack stats
     */
    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(1, "punches", 5);
    }
}
