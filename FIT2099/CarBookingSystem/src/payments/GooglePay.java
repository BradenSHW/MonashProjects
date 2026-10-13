package payments;

/**
 * The GooglePay method for payment
 */
public class GooglePay implements Payment {

    /**
     * Processes the amount to add to the user's balance
     * @param amount the amount the user wants to add
     * @return true for payment success
     */
    @Override
    public boolean processPayment(double amount) {
        System.out.printf("Payment processed by Google Pay: $%.2f%n", amount);
        return true;
    }

    /**
     * The name of the payment method GooglePay
     * @return the name of the payment method GooglePay
     */
    @Override
    public String toString() {
        return "Google Pay";
    }
}
