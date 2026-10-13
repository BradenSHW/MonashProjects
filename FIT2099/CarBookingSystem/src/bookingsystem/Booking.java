package bookingsystem;

import vehicles.Vehicle;

/**
 * This class holds the possible bookings
 */
public class Booking {
    private Vehicle vehicle;

    /**
     * The vehicles that can be booked
     * @param vehicle the vehicle that can be booked
     */
    public Booking(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    /**
     * Obtain the vehicle that can be booked
     * @return the vehicle that can be booked
     */
    public Vehicle getVehicle() {
        return vehicle;
    }

    /**
     * The booking details of the vehicle
     * @return the booking details of the vehicle
     */
    public String toString() {
        return String.format("Booking detail: " + vehicle.toString());
    }
}
