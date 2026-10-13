package actions;

import bookingsystem.User;
import bookingsystem.Booking;

/**
 * This class allows a user to add bookings
 */
public class AddBookingAction implements Action {
    private Booking myBooking;

    /**
     * Action to add bookings
     * @param myBooking the booking to be added
     */
    public AddBookingAction(Booking myBooking){
        this.myBooking = myBooking;
    }

    /**
     * Executes the add booking action
     * @param user the user that can execute this action
     * @return a string detailing the result of booking a vehicle and adding it to the Booking System
     */
    @Override
    public String execute(User user) {
        user.addBookings(myBooking);
        return myBooking + " is successfully added to the Booking System!";
    }

    /**
     * Displays the option to add bookings
     * @return the option to add bookings
     */
    @Override
    public String menuDescription() {
        return "Add the following vehicle to the Booking System: " + myBooking;
    }
}