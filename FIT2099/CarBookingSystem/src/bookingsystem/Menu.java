package bookingsystem;

import actions.Action;

import java.util.*;

/**
 * This class holds the menu of the Booking System
 */
public class Menu {

    /**
     * Takes the available action and display them as options on the menu
     * @param actions the available actions
     * @return the menu option
     */
    public static Action showMenu(List<Action> actions) {
        Scanner scanner = new Scanner(System.in);
        List<Character> freeChars = new ArrayList<Character>();
        Map<Character, Action> keyToActionMap = new HashMap<>();


        for (char j = 'a'; j <= 'z'; j++) {
            freeChars.add(j);
        }


        for (Action action : actions) {
            char c = freeChars.get(0);
            freeChars.remove(Character.valueOf(c));
            keyToActionMap.put(c, action);
            System.out.println(c + ": " + action.menuDescription());
        }


        char key;
        do {
            key = scanner.next().charAt(0);
        } while (!keyToActionMap.containsKey(key));


        return keyToActionMap.get(key);
    }
}