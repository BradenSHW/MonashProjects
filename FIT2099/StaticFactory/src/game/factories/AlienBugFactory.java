package game.factories;

import edu.monash.fit2099.engine.actors.Actor;
import game.actors.AlienBug;
import game.actors.HostileCreature;

public class AlienBugFactory implements CreatureFactory {

    /**
     * Creates a new HuntsmanSpider creature.
     *
     * @return the newly created HuntsmanSpider
     *
     * Created by:
     * @author Cheng Shun Yi
     * @author Kok Heng Ng
     */
    @Override
    public HostileCreature createCreature() {
        return new AlienBug();
    }
}
