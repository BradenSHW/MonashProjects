package game.grounds.trees;

import edu.monash.fit2099.engine.positions.Location;

/**
 * Class representing an Inheritree Sprout
 *
 * Created by:
 * @author Go Wei Zheng
 */
public class InheritreeSprout extends Tree {
    /**
     * Constructor.
     */
    public InheritreeSprout() {
        super(',');
    }

    /**
     * Ages the tree and checks if it is mature
     */
    @Override
    public void grow() {
        super.grow();

        if(this.getAge() >= 3){
            this.setMature(true);
        }
    }

    /**
     * A Sprout grows and has a chance of dropping a fruit every tick
     * If it is mature, it will turn into a MatureTree
     * @param location The location of the Ground
     */
    @Override
    public void tick(Location location) {
        this.grow();

        if(isMature()){
            location.setGround(new InheritreeSapling());
        }
    }
}