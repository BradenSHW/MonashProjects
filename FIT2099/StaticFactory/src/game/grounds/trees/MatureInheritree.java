package game.grounds.trees;

import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.Location;
import game.scraps.consumable.LargeFruit;

import java.util.List;
import java.util.Random;

/**
 * A class representing a Mature Inheritree
 * Created by:
 * @author Kok Heng Ng
 * @author Lok Keng Yik
 * @author Go Wei Zheng
 */
public class MatureInheritree extends Tree implements FruitSpawner {
    private static final int FRUIT_CHANCE = 2;

    /**
     * Constructor
     */
    public MatureInheritree() {
        super('T');
    }

    @Override
    public boolean dropChance(int chance) {
        return new Random().nextInt(10) < chance;
    }

    /**
     * Drops a LargeFruit if possible
     * @param location the location of the MatureTree
     */
    @Override
    public void dropFruit(Location location) {
        if(dropChance(FRUIT_CHANCE)) {
            Random random = new Random();
            List<Exit> possibleExit = location.getExits();
            Exit fruitExit = possibleExit.get(random.nextInt(possibleExit.size()));
            Location fruitLocation = fruitExit.getDestination();
            fruitLocation.addItem(new LargeFruit());
        }
    }

    /**
     * A MatureInheritree grows and has a chance of dropping a fruit every tick
     * @param location The location of the Ground
     */
    @Override
    public void tick(Location location) {
        grow();
        dropFruit(location);
    }
}