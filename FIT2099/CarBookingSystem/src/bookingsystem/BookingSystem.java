package bookingsystem;

import actions.Action;
import actions.ActionCapable;
import vehicles.*;

import java.util.List;
import java.util.ArrayList;

/**
 * This class handles the Booking System
 */
public class BookingSystem {
    private Vehicle[] vehicles = new Vehicle[6];
    private User user = new User();

    /**
     * Creates the vehicles
     */
    public void createVehicles() {
        vehicles[0] = new Sedan("Lexus", 2023, 200.00, 500, EngineType.ELECTRIC);
        vehicles[1] = new Sedan("BMW", 2022, 150.00, 600, EngineType.PETROL);
        vehicles[2] = new SUV("Tesla", 2023, 300.00, 5, EngineType.ELECTRIC);
        vehicles[3] = new SUV("Mercedes", 2020, 500.00, 7, EngineType.DIESEL);
        vehicles[4] = new Truck("Ford", 2019, 400.00, 1.0);
        vehicles[5] = new Truck("Volkswagen", 2020, 450.00, 1.2);
    }

    /**
     * The Booking System menu displaying all the available options for the user
     */
    public void consoleMenu() {
        while (!user.getUserDone()) {
            List<Action> actions = new ArrayList<>();
            List<ActionCapable> actionCapables = new ArrayList<>();
            actionCapables.add(user);
            for (Vehicle vehicle : vehicles) {
                actionCapables.add(vehicle);
            }
            for (ActionCapable actionCapable : actionCapables) {
                actions.addAll(actionCapable.allowableActions());
            }


            System.out.println("#########################################");
            Action action = Menu.showMenu(actions);
            System.out.println(action.execute(user));
        }
    }


    /**
     * The Welcome message
     */
    public void printStatus() {
        System.out.println("Welcome to FIT2099 Booking System");
        createVehicles();
        consoleMenu();
    }
}