package actions;

import bookingsystem.User;

/**
 * This class allows a user to exit the Booking System
 */
public class ExitAction implements Action {

    /**
     * Action to exit Booking System
     * @param user the user that can execute this action
     * @return a message thanking the user for using the Booking System
     */
    @Override
    public String execute(User user) {
        user.setUserDone(true);
        return "Thank you for visiting FIT2099 Vehicle Booking System!";
    }

    /**
     * Displays the exit action
     * @return the option to exit
     */
    @Override
    public String menuDescription() {
        return "Exit the system.";
    }
}
