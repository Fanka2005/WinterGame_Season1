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
import game.grounds.Snow;
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

        Actor bear = new Bear("Bear", 'B', 200);
        this.addPlayer(bear, gameMap.at(2, 2));

        Actor wolf = new Wolf("Wolf", 'e', 100);
        this.addPlayer(wolf, gameMap.at(2, 1));

        Actor Deer = new Deer("Deer", 'd', 100);
        this.addPlayer(Deer, gameMap.at(3, 1));

        Actor player = new Player("Explorer", 'ඞ', 100);
        this.addPlayer(player, gameMap.at(1, 1));

        player.addItemToInventory(new Bedroll("Bedroll", '=', true));
        player.addItemToInventory(new Bottle("Bottle", 'o', true,5));

        Status alive = new PlayerAlive(player);
        player.addStatus(alive);
    }
}
