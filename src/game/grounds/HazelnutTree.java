package game.grounds;


import static game.Abilities.TAME_BEAR;

import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.items.Hazelnut;
import java.util.Random;

/**
 * A class representing Hazelnut Tree on the ground.
 *
 * @author Fauzanda Lathifanka Sunarko
 */
public class HazelnutTree extends Ground {

  /**
   * Store the tick counter, to keep track of time
   */
  private int counter;

  /**
   * Constructor for Hazelnut Tree
   *
   * @param displayChar the char that will be displayed which represent hazelnut tree
   * @param name        the name of the hazelnut tree
   */
  public HazelnutTree(char displayChar, String name) {
    super(displayChar, name);
    this.counter = 0;
  }

  /**
   * Ground can also experience the joy of time.
   * Will drop hazelnut for every 10 turns
   *
   * @param location The location of the Ground
   */
  @Override
  public void tick(Location location) {
    this.counter += 1;
    Random tile = new Random();
    int exit = tile.nextInt(location.getExits().size());

    if (this.counter % 10 == 0) {
      Item item = new Hazelnut("Hazelnut", 'n', true);
      // Every hazelnut that drops from a hazelnut tree will have the ability to tame bear.
      item.enableAbility(TAME_BEAR);
      location.getExits().get(exit).getDestination().addItem(item);
    }
  }
}
