package payments;

/**
 * The ApplePay method for Payment
 */
public class ApplePay implements Payment {
    final double LIMIT = 1000;

    /**
     * Processes the amount to add to the user's balance
     * @param amount the amount the user wants to add
     * @return either true or false depending on whether the transaction succeeds or fails
     */
    @Override
    public boolean processPayment(double amount) {
        if(amount > LIMIT) {
            System.out.printf("Limit exceeded for payment of $%.2f%n", amount);
            return false;
        }
        System.out.printf("Payment processed by Apple Pay: $%.2f%n", amount);
        return true;
    }

    /**
     * The name of the payment method ApplePay
     * @return the name of the payment method ApplePay
     */
    @Override
    public String toString() {
        return "Apple pay";
    }
}
