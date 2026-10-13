package actions;

import bookingsystem.User;

/**
 * This class allows a user to display their bookings
 */
public class DisplayBookingAction implements Action {

    /**
     * Action to display bookings
     * @param user the user that can execute this action
     * @return all of the user's confirmed bookings
     */
    @Override
    public String execute(User user) {
        return user.displayBookedVehicles();
    }

    /**
     * Displays the option to view bookings
     * @return the option to view bookings
     */
    @Override
    public String menuDescription() {
        return "View bookings.";
    }
}
