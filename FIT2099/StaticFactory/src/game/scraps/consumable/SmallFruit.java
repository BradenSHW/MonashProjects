package game.scraps.consumable;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.attributes.ActorAttributeOperations;
import edu.monash.fit2099.engine.actors.attributes.BaseActorAttributes;
import edu.monash.fit2099.engine.items.Item;
import game.actions.ConsumeAction;

/**
 * A class representing a small fruit item that can be consumed by actors in the game.
 * Created by:
 * @author Kok Heng Ng
 */
public class SmallFruit extends Item implements Consumable {

    private static final int HEALING_POINT = 1;
    /**
     * Constructor for creating a small fruit item.
     */
    public SmallFruit() {
        super("Small Fruit", 'o', true);
    }

    /**
     * Applies the effect of consuming the small fruit item on the given actor.
     *
     * @param actor the actor consuming the small fruit item
     * @return a message indicating the effect of consuming the small fruit item
     */
    @Override
    public String consumedEffect(Actor actor) {
        actor.heal(HEALING_POINT);
        actor.removeItemFromInventory(this);
        return String.format("consumed %s and %s heals %s by %d points.", this, this, actor, HEALING_POINT);
    }

    /**
     * Overrides the allowableActions method to add a ConsumeAction to the list of actions available to the owner of the small fruit.
     *
     * @param owner the actor who owns the small fruit
     * @return a list of allowable actions for the owner of the small fruit
     */
    @Override
    public ActionList allowableActions(Actor owner) {
        ActionList actions = super.allowableActions(owner);
        actions.add(new ConsumeAction(this));
        return actions;
    }
}