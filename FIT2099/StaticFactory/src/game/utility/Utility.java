package game.utility;
import java.util.Random;

/**
 * Utility represents the class that helps to generate numbers.
 *
 * Created by:
 * @author Lok Keng Yik
 */
public class Utility {
    /**
     * A static method that generate a 3 digits number randomly.
     * @param upper_limit The upper bound in int
     * @return a 3 digits integer
     */
    public static int generateThreeRandomDigits(int upper_limit){
        Random random = new Random();
        int lower_limit = 100;
        return random.nextInt(upper_limit - lower_limit+1) + lower_limit;
    }
}
