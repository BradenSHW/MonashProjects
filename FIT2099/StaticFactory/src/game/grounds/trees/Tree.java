package game.grounds.trees;

import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;

/**
 * Class representing a tree that can't bear fruit
 *
 * Created by:
 * @author Go Wei Zheng
 */
public abstract class Tree extends Ground {
    /**
     * The age of the tree.
     */
    private int age = 0;

    /**
     * The maturity of the tree.
     */
    private boolean mature = false;

    /**
     * Constructor.
     *
     * @param displayChar character to display for this type of terrain
     */
    public Tree(char displayChar) {
        super(displayChar);
    }

    /**
     * Checks if the tree is mature
     * @return the maturity of the tree
     */
    public boolean isMature() {
        return mature;
    }

    /**
     * Sets the tree's maturity
     * @param mature the tree's maturity
     */
    public void setMature(boolean mature) {
        this.mature = mature;
    }

    /**
     * Checks the age of the tree
     * @return the current age of the tree
     */
    public int getAge(){
        return this.age;
    }

    /**
     *
     */

    /**
     * Ages the tree and checks if it is mature
     */
    public void grow(){
        this.age++;
    }

    @Override
    public void tick(Location location) {
        super.tick(location);
    }
}
