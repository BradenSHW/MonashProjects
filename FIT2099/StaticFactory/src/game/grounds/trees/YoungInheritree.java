package game.grounds.trees;

import edu.monash.fit2099.engine.positions.Location;

/**
 * Class representing a Young Inheritree
 *
 * Created by:
 * @author Go Wei Zheng
 */
public class YoungInheritree extends Tree {

    /**
     * Constructor
     */
    public YoungInheritree(){
        super('y');
    }

    /**
     * Ages the tree and checks if it is mature
     */
    @Override
    public void grow() {
        super.grow();

        if(this.getAge() >= 5){
            this.setMature(true);
        }
    }

    /**
     * A YoungInheritree grows and has a chance of dropping a fruit every tick
     * If it is mature, it will turn into a MatureTree
     * @param location The location of the Ground
     */
    @Override
    public void tick(Location location) {
        this.grow();

        if(isMature()){
            location.setGround(new MatureInheritree());
        }
    }
}
