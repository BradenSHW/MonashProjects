package vehicles;

import actions.Action;
import actions.ActionCapable;
import actions.AddBookingAction;
import bookingsystem.Booking;

import java.util.List;
import java.util.ArrayList;

/**
 * This class handles the vehicle's details
 */
public class Vehicle implements ActionCapable {
    private String brand;
    private int year;
    private double price;
    private String id;

    /**
     * The vehicle's details
     * @param brand the vehicle's brand
     * @param year the year the vehicle was manufactured
     * @param price the vehicle's price
     */
    public Vehicle(String brand, int year, double price) {
        this.brand = brand;
        this.year = year;
        this.price = price;
    }

    /**
     * Obtains the vehicle's brand
     * @return the vehicle's brand
     */
    public String getBrand() {
        return brand;
    }

    /**
     * Obtains the year the vehicle was manufactured
     * @return the year the vehicle was manufactured
     */
    public int getYear() {
        return year;
    }

    /**
     * Obtains the vehicle's price
     * @return the vehicle's price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Obtains the vehicle's ID
     * @return the vehicle's ID
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the vehicle's ID
     * @param id the vehicle's ID
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * The allowable actions of the vehicle
     * @return the allowable actions of the vehicle
     */
    @Override
    public List<Action> allowableActions() {
        List<Action> actions = new ArrayList<>();
        Booking booking = new Booking(this);
        actions.add(new AddBookingAction(booking));
        return actions;
    }

    /**
     * Displays the vehicle's details
     * @return the vehicle's details
     */
    public String toString() {
        return String.format(" | Brand: " + getBrand() + " | Year: " + getYear() + " | Price: $%.2f per day" , getPrice());
    }
}