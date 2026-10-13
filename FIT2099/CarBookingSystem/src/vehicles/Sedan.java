package vehicles;

/**
 * This class handles the Sedan's details
 */
public class Sedan extends Vehicle {
    private int range;
    private EngineType type;

    /**
     * The Sedan's details
     * @param brand the Sedan's brand
     * @param year the year the Sedan was manufactured
     * @param price the Sedan's price
     * @param range the Sedan's range
     * @param type the Sedan's engine type
     */
    public Sedan(String brand, int year, double price, int range, EngineType type) {
        super(brand, year, price);
        this.range = range;
        this.type = type;
        this.setId("Sedan" + Utility.generateRandomInt(10000, 99999));
    }

    /**
     * Obtains the Sedan's range
     * @return the Sedan's range
     */
    public int getRange() {
        return range;
    }

    /**
     * Obtains the Sedan's engine type
     * @return the Sedan's engine type
     */
    public EngineType getEngineType() {
        return type;
    }

    /**
     * Displays the Sedan's details
     * @return the Sedan's details
     */
    public String toString() {
        return (String.format("ID: " + getId()) + super.toString() + String.format(" | Range: " + getRange() + " km" + " | Engine Type: " + getEngineType()));
    }
}
