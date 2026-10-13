package actions;

import bookingsystem.User;

/**
 * This class allows a user to view their balance
 */
public class ViewBalanceAction implements Action {

    /**
     * Action to view balance
     * @param user the user that can execute this action
     * @return the user's balance
     */
    @Override
    public String execute(User user) {
        double balance = user.getBalance();
        return String.format("You have a balance of $%.2f", balance);
    }

    /**
     * Displays the view balance option
     * @return the option to view balance
     */
    @Override
    public String menuDescription() {
        return "View balance.";
    }
}
