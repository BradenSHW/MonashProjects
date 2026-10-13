package actions;

import bookingsystem.User;
import bookingsystem.Booking;

/**
 * This class allows a user to remove a booking
 */
public class RemoveBookingAction implements Action {
    private Booking myBooking;

    /**
     * The booking to be removed
     * @param myBooking the booking to remove
     */
    public RemoveBookingAction(Booking myBooking){
        this.myBooking = myBooking;
    }

    /**
     * Action to remove a booking
     * @param user the user that can execute this action
     * @return a message telling the user that the booking is removed
     */
    @Override
    public String execute(User user) {
        user.removeBookings(myBooking);
        return myBooking + " is successfully removed from the Booking System!";
    }

    /**
     * Displays the remove booking option
     * @return the option to remove booking
     */
    @Override
    public String menuDescription() {
        return "Remove the following vehicle from the Booking System: " + myBooking;
    }
}
