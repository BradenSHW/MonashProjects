package actions;

import java.util.List;

/**
 * This is the ActionCapable interface for other classes to implement
 */
public interface ActionCapable {

    /**
     * Creates a list of allowable actions
     * @return a list of allowable actions
     */
    public List<Action> allowableActions();
}