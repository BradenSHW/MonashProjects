package game.actors;

import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.behaviours.AttackBehaviour;
import game.behaviours.WanderBehaviour;
import game.enumerations.Status;

/**
 * A class representing a hostile creature, Huntsman Spider, in the game.
 * Huntsman Spiders are capable of attacking other actors and wandering randomly.
 * Created by:
 * @author Kok Heng Ng
 */
public class HuntsmanSpider extends HostileCreature {

    /**
     * Constructor for creating a HuntsmanSpider.
     * Huntsman Spiders have a default hit point of 1 and an intrinsic weapon that stabs with 25 damage.
     * They also have a WanderBehaviour by default.
     */
    public HuntsmanSpider() {
        super("Huntsman Spider", '8', 1);
        // WanderBehaviour has the lowest priority
        this.behaviours.put(0, new AttackBehaviour());
    }

    /**
     * Retrieves the intrinsic weapon of the Huntsman Spider.
     *
     * @return the intrinsic weapon of the Huntsman Spider
     */
    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        // Huntsman Spider has an intrinsic weapon that stabs with 25% accuracy
        return new IntrinsicWeapon(1, "stabs", 25);
    }
}
