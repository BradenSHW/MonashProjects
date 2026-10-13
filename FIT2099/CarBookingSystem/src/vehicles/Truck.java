package vehicles;

/**
 * This class handles the Truck's details
 */
public class Truck extends Vehicle {
    private double loading;

    /**
     *
     * @param brand the truck's brand
     * @param year the year the truck was manufactured
     * @param price the truck's price
     * @param loading the truck's loading
     */
    public Truck(String brand, int year, double price, double loading) {
        super(brand, year, price);
        this.loading = loading;
        this.setId("Truck" + Utility.generateRandomInt(100, 999));
    }

    /**
     * Obtains the truck's loading
     * @return the truck's loading
     */
    public double getLoading() {
        return loading;
    }

    /**
     * Displays the truck's details
     * @return the truck's details
     */
    public String toString() {
        return (String.format("ID: " + getId()) + super.toString() + String.format(" | Loading: %.1f", getLoading() ) + " tonnes");
    }
}