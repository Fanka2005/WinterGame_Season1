package game;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.capabilities.Status;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.DefaultGroundCreator;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.World;
import game.actors.Bear;
import game.actors.Deer;
import game.actors.Player;
import game.actors.Wolf;
import game.behaviours.AttackBehaviour;
import game.behaviours.WanderBehaviour;
import game.grounds.AppleTree;
import game.grounds.HazelnutTree;
import game.grounds.Snow;
import game.grounds.YewBerryTree;
import game.items.Bedroll;
import game.items.Bottle;
import game.statuses.PlayerAlive;
import java.util.Arrays;
import java.util.List;

public class Earth extends World {

    public Earth(Display display) {
        super(display);
    }

    public void constructWorld() throws Exception {
        DefaultGroundCreator groundCreator = new DefaultGroundCreator();
        groundCreator.registerGround('.', Snow::new);

        List<String> map = Arrays.asList(
            "........................................",
            "........................................",
            "........................................",
            "........................................",
            "........................................",
            "........................................",
            "........................................",
            "........................................",
            "........................................",
            "........................................"
        );

        GameMap gameMap = new GameMap("Forest", groundCreator, map);
        this.addGameMap(gameMap);

        Bear bear = new Bear("Bear", 'B', 200);
        this.addPlayer(bear, gameMap.at(8, 8));
        bear.addBehaviour(0, new AttackBehaviour());
        bear.addBehaviour(999, new WanderBehaviour());

        Wolf wolf = new Wolf("Wolf", 'e', 100);
        this.addPlayer(wolf, gameMap.at(5, 5));
        wolf.addBehaviour(0, new AttackBehaviour());
        wolf.addBehaviour(999, new WanderBehaviour());

        Deer deer = new Deer("Deer", 'd', 100);
        this.addPlayer(deer, gameMap.at(7, 7));
        deer.addBehaviour(999, new WanderBehaviour());

        Actor player = new Player("Explorer", 'ඞ', 100);
        this.addPlayer(player, gameMap.at(1, 1));

        player.addItemToInventory(new Bedroll("Bedroll", '=', true));
        player.addItemToInventory(new Bottle("Bottle", 'o', true,5));

        gameMap.at(6,6).setGround(new AppleTree('T', "Apple Tree"));
        gameMap.at(8,8).setGround(new HazelnutTree('A', "Hazelnut Tree"));
        gameMap.at(9,5).setGround(new YewBerryTree('Y', "Yew Berry Tree"));

        Status alive = new PlayerAlive(player);
        player.addStatus(alive);
    }
}
