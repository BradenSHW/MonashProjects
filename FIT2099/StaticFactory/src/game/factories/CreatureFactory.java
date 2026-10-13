package game.factories;

import edu.monash.fit2099.engine.actors.Actor;
import game.actors.HostileCreature;

/**
 * An interface representing a factory for creating creatures (actors) in the game.
 * Created by:
 * @author Kok Heng Ng
 */
public interface CreatureFactory {

    /**
     * Creates a new creature (actor) according to the factory's implementation.
     *
     * @return the newly created creature
     */
    HostileCreature createCreature();
}
