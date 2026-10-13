package game.factories;

import game.actors.HostileCreature;
import game.actors.SuspiciousAstronaut;

/**
 * SuspiciousAstronautFactory class implements the CreatureFactory interface. It represents a factory class to spawn
 * Suspicious Astronaut.
 *
 * Created by:
 * @author Lok Keng Yik
 */
public class SuspiciousAstronautFactory implements CreatureFactory {

    /**
     * Creates a new SuspiciousAstronaut creature.
     *
     * @return the newly created SuspiciousAstronaut
     */
    @Override
    public HostileCreature createCreature() {
        return new SuspiciousAstronaut();
    }
}
