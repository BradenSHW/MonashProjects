package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.scraps.purchasableitems.Monologue;

import java.util.ArrayList;
import java.util.Random;

/**
 * A class that represent an action to listen to monologue.
 * Created by:
 *
 * @author Lok Keng Yik
 */
public class ListenAction extends Action {
    private Monologue targetToListenTo;

    /**
     * Constructor for ListenAction that initialise the targetToListenTo.
     *
     * @param targetToListenTo a target to listen to
     */
    public ListenAction(Monologue targetToListenTo) {
        this.targetToListenTo = targetToListenTo;
    }

    /**
     * Randomly select a monologue from the arraylist of that target's possible monologues.
     *
     * @param actor The actor performing the action.
     * @param map   The map the actor is on.
     * @return a string that is representing the monologue.
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        ArrayList<String> monologueList = targetToListenTo.getMonologue(actor);
        Random random = new Random();
        int indexToChoose = random.nextInt(monologueList.size());
        return String.format(targetToListenTo + ": \"%s\"", monologueList.get(indexToChoose));
    }

    /**
     * Display the option to listen to the monologue.
     *
     * @param actor The actor performing the action.
     * @return a string that represent the option to listen to the monologue
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " listens to " + targetToListenTo;
    }
}
