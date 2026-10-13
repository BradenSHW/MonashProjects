package bookingsystem;

import actions.*;
import payments.ApplePay;
import payments.GooglePay;

import java.util.List;
import java.util.ArrayList;

/**
 * This class handles the user's available actions
 */
public class User implements ActionCapable {
    private double balance;
    private boolean isUserDone;
    List<Booking> bookings;

    /**
     * Initialisation of the user
     */
    public User() {
        this.balance = 0;
        this.isUserDone = false;
        this.bookings = new ArrayList<Booking>();
    }

    /**
     * Obtains the user's balance
     * @return the user's balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Adds the user's balance
     * @param balance the amount to be added
     */
    public void addBalance(double balance) {
        this.balance += balance;
    }

    /**
     * Checks if the user is done using the Booking System
     * @return the user's status
     */
    public boolean getUserDone() {
        return isUserDone;
    }

    /**
     * Sets the user's status
     * @param isUserDone the user's status
     */
    public void setUserDone(boolean isUserDone) {
        this.isUserDone = isUserDone;
    }

    /**
     * Adds a booking
     * @param booking booking to be added
     */
    public void addBookings(Booking booking) {
        bookings.add(booking);
    }

    /**
     * Removes a booking
     * @param booking booking to be removed
     */
    public void removeBookings(Booking booking) {
        bookings.remove(booking);
    }

    /**
     * Obtains user's bookings
     * @return a list of the user's bookings
     */
    public List<Booking> getBookings() {
        return bookings;
    }

    /**
     * All the available actions the user can perform
     * @return the actions the user can perform
     */
    @Override
    public List<Action> allowableActions() {
        List<Action> actions = new ArrayList<>();

        AddBalanceAction addBalanceAction = new AddBalanceAction(new GooglePay());
        actions.add(addBalanceAction);

        addBalanceAction = new AddBalanceAction(new ApplePay());
        actions.add(addBalanceAction);

        ViewBalanceAction viewBalanceAction = new ViewBalanceAction();
        actions.add(viewBalanceAction);

        DisplayBookingAction displayBookingAction = new DisplayBookingAction();
        actions.add(displayBookingAction);

        ConfirmAction confirmAction = new ConfirmAction();
        actions.add(confirmAction);

        for (int i = 0; i < bookings.size(); i++) {
            RemoveBookingAction removeBookingAction = new RemoveBookingAction(bookings.get(i));
            actions.add(removeBookingAction);
        }

        ExitAction exitAction = new ExitAction();
        actions.add(exitAction);

        return actions;
    }

    /**
     * Displays the user's booked vehicles
     * @return the user's booked vehicles, can display none if no booking has been made
     */
    public String displayBookedVehicles() {
        if (bookings.isEmpty()) {
            return "No bookings.";
        }
        else {
            String bookedVehicles = "";
            for (int i = 0; i < bookings.size(); i++) {
                bookedVehicles += String.format(bookings.get(i).toString() + "\n");
            }
            return bookedVehicles;
        }
    }
}
