package game.scraps.purchasableitems;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.attributes.BaseActorAttributes;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.ListenAction;

import java.util.ArrayList;

/**
 * A class that represents AIDevice in the game. It extends Item and implements Purchasable and Monologue interfaces.
 * Created by:
 *
 * @author Lok Keng Yik
 */

public class AIDevice extends Item implements Purchasable, Monologue {
    private boolean onSubscription;
    private int subscriptionCounter;

    private static final int SUBSCRIPTION_COST = 1;
    private ArrayList<String> monologueList = new ArrayList<String>();
    private static final int TEN_ITEMS = 10;
    private static final int FIFTY_CREDITS = 50;
    private static final int TWO_HEALTH_POINTS = 2;
    private static final int FIVE_TICK = 5;
    private static final int COST = 50;

    /***
     * Constructor for AIDevice to add default monologues and set default values for its attributes.
     */
    public AIDevice() {
        super("Astley, an AI device", 'z', true);
        this.onSubscription = true;
        this.subscriptionCounter = 0;
        this.monologueList.add("The factory will never gonna give you up, valuable intern!");
        this.monologueList.add("We promise we never gonna let you down with a range of staff benefits.");
        this.monologueList.add("We never gonna run around and desert you, dear intern!");
    }

    /**
     * Obtains the cost of the AIDevice.
     *
     * @return the cost of AIDevice.
     */
    @Override
    public int getCost() {
        return COST;
    }

    /**
     * Applies the effect of the actor purchasing an AIDevice.
     *
     * @param actor the actor purchasing an AIDevice.
     * @return the cost of the AIDevice.
     */
    @Override
    public int purchaseEffect(Actor actor) {
        if (COST <= actor.getBalance()) {
            actor.addItemToInventory(this);
        }
        return COST;
    }

    /**
     * Make the actor holding this item to pay for subscription fee every five turns. If the actor can pay, then deduct
     * actor's balance and continue the subscription, else stop the subscription.
     *
     * @param currentLocation The location of the actor carrying this AIDevice.
     * @param actor           The actor carrying this AIDevice.
     */
    @Override
    public void tick(Location currentLocation, Actor actor) {
        Display display = new Display();
        subscriptionCounter += 1;
        if (subscriptionCounter % FIVE_TICK == 0) {  // every five ticks
            onSubscription = false;
            if (actor.getBalance() < SUBSCRIPTION_COST) {
                display.println("Subscription paused due to intern fail to pay subscription fee.");
            } else {
                actor.deductBalance(SUBSCRIPTION_COST);
                onSubscription = true;
                display.println("Subscription payment received!");
            }
        }
    }

    /**
     * Add monologues to an arraylist based on different condition and return the arraylist consist of possible monologues
     * by this AIDevice.
     *
     * @param actor the actor that wants to listen to the monologue
     * @return monologueOptions, an arraylist of strings.
     */
    @Override
    public ArrayList<String> getMonologue(Actor actor) {
        ArrayList<String> monologueOptions = new ArrayList<String>();
        monologueOptions.addAll(monologueList);
        if (actor.getItemInventory().size() > TEN_ITEMS) {
            monologueOptions.add("We never gonna make you cry with unfair compensation.");
        }
        if (actor.getBalance() > FIFTY_CREDITS) {
            monologueOptions.add("Trust is essential in this business. We promise we never gonna say goodbye to a valuable intern like you.");
        }
        if (actor.getAttribute(BaseActorAttributes.HEALTH) < TWO_HEALTH_POINTS) {
            monologueOptions.add("Don't worry, we never gonna tell a lie and hurt you, unlike those hostile creatures.");
        }
        return monologueOptions;
    }

    /**
     * Only allow owner to listen to this AIDevice if it is still on its subscription period.
     *
     * @param owner the actor that owns AIDevice
     * @return actions, an ActionList consist of actions that can be performed
     */
    @Override
    public ActionList allowableActions(Actor owner) {
        ActionList actions = super.allowableActions(owner);
        if (onSubscription) {
            actions.add(new ListenAction(this));
        }
        return actions;
    }
}
