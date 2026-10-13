package game.actors;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.behaviours.FollowBehaviour;
import game.behaviours.PickUpBehaviour;
import game.enumerations.Ability;
import game.utility.Utility;

import java.util.List;

/**
 * AlienBug class extends HostileCreature abstract class and represents Alien Bug which cannot attack the intern. It can
 * wander around the map. However, when there is scraps on the ground that it is currently standing, it will pick up all
 * items available randomly. If intern is within the surrounding(one exits away) of the Alien Bug, it will follow the
 * intern until it dies or when the game has ended. However, it would prioritise picking up all scraps first then only
 * follow intern, wandering has the lowest priority.
 *
 * Created by:
 * @author Lok Keng Yik
 */
public class AlienBug extends HostileCreature {
    private static final int NUMBER_LIMIT = 999;

    /**
     * Constructor for AlienBug which initialise its name, display character and hit points. Adds ability for it to enter
     * spaceship and make picking up scraps as highest priority and following intern as second-highest priority.
     */
    public AlienBug() {
        super("Feature-" + Utility.generateThreeRandomDigits(NUMBER_LIMIT), 'a', 2);
        this.addCapability(Ability.CAN_ENTER_SPACESHIP);
        this.behaviours.put(0, new PickUpBehaviour());
        this.behaviours.put(1, new FollowBehaviour());
    }

    /**
     *To drop all items when dead which loops through the items it has.
     *
     * @param actor the perpetrator
     * @param map where the alien bug fell unconscious
     * @return a string that say it has died
     */
    @Override
    public String unconscious(Actor actor, GameMap map) {
        List<Item> itemsOnActor = this.getItemInventory();
        for (Item item : itemsOnActor){
            Location dropAt = map.locationOf(this);
            dropAt.addItem(item); // drop the item on where the alien bug is standing
        }
        return super.unconscious(this, map);
    }
}
