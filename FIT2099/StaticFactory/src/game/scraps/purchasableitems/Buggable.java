package game.scraps.purchasableitems;

/**
 * An interface that represent things that can bug.
 * Created by:
 *
 * @author Lok Keng Yik
 */
public interface Buggable {
    /**
     * The chance of the bug occurring.
     *
     * @return the chance of the bug occurring.
     */
    boolean bugChance();

    /**
     * The new cost of the item after the bug.
     *
     * @return the new cost of the item after the bug.
     */
    int bug();
}
