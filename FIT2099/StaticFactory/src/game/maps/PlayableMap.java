package game.maps;

import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.GroundFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Class representing a playable map of the game.
 * Created by:
 * @author Braden Shiew Hao Wen
 */
public class PlayableMap extends GameMap {

    /**
     * A list of playable maps
     */
    private static final List<PlayableMap> playableMaps = new ArrayList<>();

    /**
     * The name of a playable map
     */
    private final String name;

    /**
     * Constructor of a playable map
     * @param groundFactory the GroundFactory of the map
     * @param lines the layout of the map
     * @param name the name of the map
     */
    public PlayableMap(GroundFactory groundFactory, List<String> lines, String name) {
        super(groundFactory, lines);
        this.name = name;
        playableMaps.add(this);
    }

    /**
     * Obtains the name of the map
     * @return the name of the map
     */
    public String getName() {
        return name;
    }

    /**
     * Obtains a list of the playable maps
     * @return a list of the playable maps
     */
    public static List<PlayableMap> getPlayableMaps() {
        return new ArrayList<>(playableMaps);
    }
}
