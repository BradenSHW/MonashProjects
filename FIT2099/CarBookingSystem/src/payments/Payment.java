package payments;

/**
 * This is the payment interface for other classes to implement
 */
public interface Payment {

    /**
     * Processes the amount the user wants to add to their balance
     * @param amount the amount the user wants to add
     */
    public boolean processPayment(double amount);
}
