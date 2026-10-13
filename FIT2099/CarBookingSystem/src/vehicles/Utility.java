package vehicles;

import java.util.Random;

/**
 * This class generates a random integer for the vehicle's ID
 */
public class Utility {

    /**
     * Generates a random number for the vehicle's ID
     * @param lower the lower bound of the ID
     * @param upper the upper bound of the ID
     * @return the randomly generated ID
     */
    public static int generateRandomInt(int lower, int upper) {
        Random random = new Random();
        return random.nextInt(upper - lower + 1) + lower;
    }
}
