package actions;

import bookingsystem.User;
import payments.Payment;

import java.util.Scanner;

/**
 * This class allows a user to add balance
 */
public class AddBalanceAction implements Action {

    /**
     * The payment method used
     */
    public Payment payment;

    /**
     * Action to add balance
     * @param payment the payment to be added
     */
    public AddBalanceAction(Payment payment) {
        this.payment = payment;
    }

    /**
     * Executes the add balance action
     * @param user the user that can execute this action
     * @return a string detailing the result, can be a success or failure
     */
    @Override
    public String execute(User user) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number to add to your current balance: ");
        float balance = Float.parseFloat(scanner.nextLine());
        if(payment.processPayment(balance)) {
            user.addBalance(balance);
            return String.format("$%.2f is added to the user balance!", balance);
        }
        else {
            return "Failed to add to the user balance.";
        }
    }

    /**
     * Displays the option to add balance
     * @return the option to add balance
     */
    @Override
    public String menuDescription() {
        return "Add balance with " + this.payment.toString() + ".";
    }
}
