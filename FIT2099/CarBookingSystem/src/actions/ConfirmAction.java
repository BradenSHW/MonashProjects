package actions;

import bookingsystem.User;

/**
 * This class allows a user to confirm bookings
 */
public class ConfirmAction implements Action {

    /**
     * Action to confirm bookings
     * @param user the user that can execute this action
     * @return a string detailing the confirmation of the bookings, balance deducted and balance remaining
     */
    @Override
    public String execute(User user) {
        double totalPrice = 0;

        // Calculate total price of all bookings
        for (int i = 0; i < user.getBookings().size(); i++ ) {
            totalPrice += user.getBookings().get(i).getVehicle().getPrice();
        }

        // Deduct total price from user's balance
        user.addBalance(totalPrice * -1);

        // Clear booking list of user
        user.getBookings().clear();

        return String.format("Bookings confirmed. A total price of $%.1f has been deducted from your balance. You have $%.1f remaining. Thank you for using FIT2099 Booking System", totalPrice, user.getBalance());
    }

    /**
     * Displays the option to confirm bookings
     * @return the option to confirm bookings
     */
    @Override
    public String menuDescription() {
        return "Confirm bookings.";
    }
}
