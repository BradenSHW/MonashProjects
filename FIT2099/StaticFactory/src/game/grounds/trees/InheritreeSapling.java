package game.grounds.trees;

import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.Location;
import game.scraps.consumable.SmallFruit;

import java.util.List;
import java.util.Random;

/**
 * A class representing an Inheritree Sapling
 * Created by:
 * @author Kok Heng Ng
 * @author Lok Keng Yik
 * @author Go Wei Zheng
 */
public class InheritreeSapling extends Tree implements FruitSpawner {
    private static final int FRUIT_CHANCE = 3;

    /**
     * Constructor
     */
    public InheritreeSapling() {
        super('t');
    }


    @Override
    public boolean dropChance(int chance) {
        return new Random().nextInt(10) < chance;
    }

    /**
     * Drops a SmallFruit if possible
     * @param location the location of the Sapling
     */
    @Override
    public void dropFruit(Location location) {
        if(dropChance(FRUIT_CHANCE)) {
            Random random = new Random();
            List<Exit> possibleExit = location.getExits();
            Exit fruitExit = possibleExit.get(random.nextInt(possibleExit.size()));
            Location fruitLocation = fruitExit.getDestination();
            fruitLocation.addItem(new SmallFruit());
        }
    }

    /**
     * Ages the tree and checks if it is mature
     */
    @Override
    public void grow() {
        super.grow();

        if(this.getAge()>=6){
            this.setMature(true);
        }
    }

    /**
     * A Sapling grows and has a chance of dropping a fruit every tick
     * If it is mature, it will turn into a MatureTree
     * @param location The location of the Ground
     */
    @Override
    public void tick(Location location) {
        this.grow();

        if (isMature()) {
            location.setGround(new YoungInheritree());
        }
        dropFruit(location);
    }
}
