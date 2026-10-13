package game.grounds;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.MoveActorAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.*;
import game.actions.PurchaseAction;
import game.maps.PlayableMap;
import game.scraps.purchasableitems.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Class representing a Terminal.
 * Created by:
 * @author Braden Shiew Hao Wen
 * @author Lok Keng Yik
 */
public class Terminal extends Ground {

    /**
     * Creates a list of purchasable items.
     */
    ArrayList<Purchasable> purchasables = new ArrayList<>();

    /**
     * Constructor of a Terminal.
     */
    public Terminal() {
        super('=');
        purchasables.add(new EnergyDrink());
        purchasables.add(new DragonSlayerSword());
        purchasables.add(new ToiletPaperRoll());
        purchasables.add(new AIDevice());
        purchasables.add(new Theseus());
    }

    /**
     * Adds the actions to teleport to maps other than the current one
     * @param actions list of allowable actions
     * @param currentMap the map the actor is currently on
     */
    private void addTeleportActions(ActionList actions, GameMap currentMap) {
        List<PlayableMap> playableMaps = PlayableMap.getPlayableMaps();
        for (int i = 0; i < playableMaps.size(); i++) {
            PlayableMap map = playableMaps.get(i);
            if (!map.equals(currentMap)) {
                Location spawnLocation = findSpawnLocation(map);
                actions.add(new MoveActorAction(spawnLocation, "to " + map.getName()));
            }
        }
    }

    /**
     * Finds the spawn location of the map the actor is being teleported to
     * Scans the map to spawn the actor on a floor
     * Defaults to a random location if no floor is found
     * @param map the map the actor is teleporting to
     * @return the spawn location of the map being teleported to
     */
    private Location findSpawnLocation(GameMap map) {
        for (int x = 0; x < map.getXRange().max(); x++) {
            for (int y = 0; y < map.getYRange().max(); y++) {
                if (map.at(x, y).getGround().getDisplayChar() == '_') {
                    return map.at(x, y);
                }
            }
        }
        // Default to a random location if no floor is found
        Random rand = new Random();
        int x, y;
        Location destination;

        do {
            x = rand.nextInt(map.getXRange().max() + 1);
            y = rand.nextInt(map.getYRange().max() + 1);
            destination = map.at(x, y);
        }
        while (destination.containsAnActor());

        return destination;
    }

    /**
     * Adds Terminal actions to a list of actions available to the actor.
     * @param actor the Actor acting
     * @param location the current Location
     * @param direction the direction of the Ground from the Actor
     * @return a list of allowable actions.
     */
    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction) {
        ActionList actions = new ActionList();
        for(Exit exit : location.getExits()){
            if(exit.getDestination().getActor() == actor) {
                for (Purchasable purchasable : purchasables) {
                    actions.add(new PurchaseAction(purchasable));
                }
                addTeleportActions(actions, location.map());
            }
        }
        if(location.getActor() == actor){
            for(Purchasable purchasable : purchasables){
                actions.add(new PurchaseAction(purchasable));
            }
            addTeleportActions(actions, location.map());
        }
        return actions;
    }
}
