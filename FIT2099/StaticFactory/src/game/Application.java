package game;

import java.util.Arrays;
import java.util.List;

import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.FancyGroundFactory;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.World;
import game.actors.HumanoidFigure;
import game.actors.Player;
import game.factories.AlienBugFactory;
import game.factories.CreatureFactory;
import game.factories.SpiderFactory;
import game.factories.SuspiciousAstronautFactory;
import game.grounds.*;
import game.grounds.trees.InheritreeSapling;
import game.grounds.trees.InheritreeSprout;
import game.maps.PlayableMap;
import game.scraps.LargeBolt;
import game.scraps.MetalSheet;
import game.scraps.consumable.JarOfPickles;
import game.scraps.consumable.PotOfGold;
import game.scraps.weaponscraps.MetalPipe;

/**
 * The main class to start the game.
 * Created by:
 * @author Kok Heng Ng
 * @author Braden Shiew Hao Wen
 */
public class Application {

    /**
     * The entry point for the game.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {

        // Create a new world and initialize the display
        World world = new World(new Display());

        // Create a fancy ground factory to create different types of ground
        FancyGroundFactory groundFactory = new FancyGroundFactory(new Dirt(),
                new Wall(), new Floor(), new Puddle());

        // Define the map layout
        List<String> map = Arrays.asList(
                "...~~~~.........~~~...........",
                "...~~~~.......................",
                "...~~~........................",
                "..............................",
                ".............#####............",
                ".............#___#...........~",
                ".............#___#..........~~",
                ".............##_##.........~~~",
                ".................~~........~~~",
                "................~~~~.......~~~",
                ".............~~~~~~~........~~",
                "......~.....~~~~~~~~.........~",
                ".....~~~...~~~~~~~~~..........",
                ".....~~~~~~~~~~~~~~~~........~",
                ".....~~~~~~~~~~~~~~~~~~~....~~");

        // Create a new game map
        GameMap gameMap = new PlayableMap(groundFactory, map, "Polymorphia");
        world.addGameMap(gameMap);

        List<String> map2 = Arrays.asList(
                ".......",
                ".#####.",
                ".#___#.",
                ".#___#.",
                ".##_##.",
                ".......",
                ".......",
                ".......",
                ".......",
                ".......");

        GameMap factoryMap = new PlayableMap(groundFactory, map2, "Factory");
        world.addGameMap(factoryMap);

        List<String> map3 = Arrays.asList(
                "..........................~~~~",
                "..........................~~~~",
                "..........................~~~~",
                "~..........................~..",
                "~~...........#####............",
                "~~~..........#___#............",
                "~~~..........#___#............",
                "~~~..........##_##............",
                "~~~..................~~.......",
                "~~~~................~~~~......",
                "~~~~...............~~~~~......",
                "..~................~~~~.......",
                "....................~~........",
                ".............~~...............",
                "............~~~~..............");

        GameMap refactorioMap = new PlayableMap(groundFactory, map3, "Refactorio");
        world.addGameMap(refactorioMap);

        // Display the title with animation
        for (String line : FancyMessage.TITLE.split("\n")) {
            new Display().println(line);
            try {
                Thread.sleep(200);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }

        // Create a creature factory for spawning spiders
        CreatureFactory spiderFactory = new SpiderFactory();
        gameMap.at(7, 9).setGround(new Crater(spiderFactory, 5));

        CreatureFactory suspiciousAstronautFactory = new SuspiciousAstronautFactory();
        gameMap.at(2, 6).setGround(new Crater(suspiciousAstronautFactory, 5));

        CreatureFactory alienBugFactory = new AlienBugFactory();
        gameMap.at(13, 2).setGround(new Crater(alienBugFactory, 10));

        // Create the player character and place it on the game map
        Player player = new Player("Intern", '@', 4);
        world.addPlayer(player, gameMap.at(15, 6));
        player.addBalance(1000);

        // Create items and place them on the game map
        Item metalSheet = new MetalSheet();
        Item largeBolt = new LargeBolt();
        gameMap.at(4,7).addItem(metalSheet);
        gameMap.at(23, 4).addItem(largeBolt);

        // Create a metal pipe and place it on the game map
        Item metalPipe = new MetalPipe();
        gameMap.at(15, 10).addItem(metalPipe);

        Item jarOfPickles = new JarOfPickles();
        gameMap.at(15, 9).addItem(jarOfPickles);

        Item potOfGold = new PotOfGold();
        gameMap.at(15, 11).addItem(potOfGold);

        // Create a terminal and place it on the game map
        Terminal terminal = new Terminal();
        gameMap.at(14, 5).setGround(terminal);

        Terminal terminal2 = new Terminal();
        factoryMap.at(2, 2).setGround(terminal2);

        Terminal terminal3 = new Terminal();
        refactorioMap.at(14, 5).setGround(terminal3);
        refactorioMap.at(22, 9).setGround(new InheritreeSprout());

        // Add a Humanoid Figure into the factory map
        HumanoidFigure humanoidFigure = new HumanoidFigure();
        factoryMap.at(3, 9).addActor(humanoidFigure);

        // Start the game loop
        world.run();
    }
}
