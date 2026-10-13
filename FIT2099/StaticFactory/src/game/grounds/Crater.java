package game.grounds;

import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.factories.CreatureFactory;

import java.util.List;
import java.util.Random;

/**
 * A class representing a Crater, a type of ground that can spawn creatures periodically.
 * Created by:
 * @author Kok Heng Ng
 */
public class Crater extends Ground {

    /** The spawn rate of creatures from the crater. */
    private final int spawnRate;

    /** The factory responsible for creating creatures spawned from the crater. */
    private CreatureFactory creatureFactory;

    /**
     * Constructor for creating a Crater.
     *
     * @param creatureFactory the factory responsible for creating creatures spawned from the crater
     * @param spawnRate       the spawn rate of creatures from the crater
     */
    public Crater(CreatureFactory creatureFactory, int spawnRate) {
        super('u');
        this.creatureFactory = creatureFactory;
        this.spawnRate = spawnRate;
    }

    /**
     * Retrieves the spawn rate of creatures from the crater.
     *
     * @return the spawn rate of creatures from the crater
     */
    public int getSpawnRate() {
        return this.spawnRate;
    }

    /**
     * Retrieves the factory responsible for creating creatures spawned from the crater.
     *
     * @return the factory responsible for creating creatures spawned from the crater
     */
    public CreatureFactory getCreatureFactory() {
        return creatureFactory;
    }

    /**
     * Overrides the tick method to handle periodic spawning of creatures from the crater.
     *
     * @param location the location of the crater
     */
    @Override
    public void tick(Location location) {
        super.tick(location);
        Random random = new Random();
        if (random.nextInt(100) <= getSpawnRate()) {

            // Get a random exit from the location to spawn the creature
            List<Exit> possibleExitsForCreature = location.getExits();
            Exit creatureExitSpot = possibleExitsForCreature.get(random.nextInt(possibleExitsForCreature.size()));
            Location creatureSpawnAt = creatureExitSpot.getDestination();

            // Check if the location to spawn the creature is empty, then add the creature
            if (!creatureSpawnAt.containsAnActor()) {
                creatureSpawnAt.addActor(getCreatureFactory().createCreature());
            }
        }
    }
}
