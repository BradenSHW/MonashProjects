package game.grounds.trees;

import edu.monash.fit2099.engine.positions.Location;

/**
 * Abstract class representing a tree that can bear fruits
 *
 * Created by:
 * @author Go Wei Zheng
 */
public interface FruitSpawner{

    /**
     * The chance for a fruit to drop
     * @param chance The chance to drop a fruit
     */
    public boolean dropChance(int chance);
    /**
     * The logic for dropping fruits
     * @param location
     */
    public void dropFruit(Location location);
}
