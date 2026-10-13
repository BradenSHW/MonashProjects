package vehicles;

/**
 * This class handles the SUV's details
 */
public class SUV extends Vehicle {
    private int seats;
    private EngineType type;

    /**
     * The SUV's details
     * @param brand the SUV's brand
     * @param year the year the SUV was manufactured
     * @param price the SUV's price
     * @param seats the number of seats the SUV has
     * @param type the SUV's engine type
     */
    public SUV(String brand, int year, double price, int seats, EngineType type) {
        super(brand, year, price);
        this.seats = seats;
        this.type = type;
        this.setId("SUV" + Utility.generateRandomInt(1000, 9999));
    }

    /**
     * Obtains the SUV's number of seats
     * @return the SUV's number of seats
     */
    public int getSeats() {
        return seats;
    }

    /**
     * Obtains the SUV's engine type
     * @return the SUV's engine type
     */
    public EngineType getEngineType() {
        return type;
    }

    /**
     * Displays the SUV's details
     * @return the SUV's details
     */
    public String toString() {
        return (String.format("ID: " + getId()) + super.toString() + String.format(" | Number of Seats: " + getSeats() + " | Engine Type: " + getEngineType()));
    }
}
