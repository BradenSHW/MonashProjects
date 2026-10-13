package actions;

import bookingsystem.User;

/**
 * This is the Action interface for other classes to implement
 */
public interface Action {

    /**
     * Executes a specific action
     * @param user the user that can execute this action
     * @return a string detailing the outcome of the action
     */
    String execute(User user);

    /**
     * Displays the action option in the menu
     * @return a string to display the action option in the menu
     */
    String menuDescription();
}
