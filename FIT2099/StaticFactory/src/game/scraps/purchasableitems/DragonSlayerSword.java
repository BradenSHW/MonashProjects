package game.scraps.purchasableitems;

import edu.monash.fit2099.engine.actors.Actor;
import game.scraps.weaponscraps.WeaponScraps;

import java.util.Random;

/**
 * Class representing a DragonSlayerSword.
 * Created by:
 * @author Braden Shiew Hao Wen
 */
public class DragonSlayerSword extends WeaponScraps implements Purchasable, Buggable {

    /**
     * The chance of bug when purchasing a DragonSlayerSword.
     */
    private static final int BUGCHANCE = 50;

    /**
     * The cost of a DragonSlayerSword
     */
    private static final int COST = 100;

    private Random rand = new Random();

    /**
     * Constructor of a DragonSlayerSword.
     */
    public DragonSlayerSword() {
        super("Dragon Slayer Sword", 'x', 50, "slashes", 75);
    }

    /**
     * Obtains the cost of a DragonSlayerSword.
     * @return the cost of a DragonSlayerSword.
     */
    @Override
    public int getCost() {
        return COST;
    }

    /**
     * The chance of the bug occurring when purchasing a DragonSlayerSword.
     * @return the chance of the bug occurring when purchasing a DragonSlayerSword.
     */
    @Override
    public boolean bugChance() {
        return rand.nextInt(100) < BUGCHANCE;
    }

    /**
     *The new cost of the DragonSlayerSword after the bug.
     * @return the new cost of the DragonSlayerSword after the bug.
     */
    @Override
    public int bug() {
        int bugCost = getCost();
        System.out.println("The system bugged and took the credits without printing the Dragon Slayer Sword");
        return bugCost;
    }

    /**
     * Applies the effect of the actor purchasing a DragonSlayerSword.
     * @param actor the actor purchasing a DragonSlayerSword.
     * @return the cost of the DragonSlayerSword.
     */
    @Override
    public int purchaseEffect(Actor actor) {
        int cost = COST;
        if (bugChance())
            return bug();
        if (cost <= actor.getBalance()){
            actor.addItemToInventory(this);
        }
        return cost;
    }
}
