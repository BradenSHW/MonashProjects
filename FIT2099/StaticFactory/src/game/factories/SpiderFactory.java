package game.factories;

import edu.monash.fit2099.engine.actors.Actor;
import game.actors.HostileCreature;
import game.actors.HuntsmanSpider;

/**
 * A factory class for creating HuntsmanSpider creatures.
 * Created by:
 * @author Kok Heng Ng
 */
public class SpiderFactory implements CreatureFactory {

    /**
     * Creates a new HuntsmanSpider creature.
     *
     * @return the newly created HuntsmanSpider
     */
    @Override
    public HostileCreature createCreature() {
        return new HuntsmanSpider();
    }
}
