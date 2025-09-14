package game.grounds;


import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.items.YewBerry;
import java.util.Random;

/**
 * A class representing Yew Berry Tree on the ground.
 *
 * @author Fauzanda Lathifanka Sunarko
 */
public class YewBerryTree extends Ground {

  /**
   * Store the tick counter, to keep track of time
   */
  private int counter;

  /**
   * Constructor for Yew Berry Tree
   *
   * @param displayChar the char that will be displayed which represent Yew Berry Tree
   * @param name        the name of the Yew Berry Tree
   */
  public YewBerryTree(char displayChar, String name) {
    super(displayChar, name);
    this.counter = 0;
  }

  /**
   * Ground can also experience the joy of time.
   *
   * @param location The location of the Ground
   */
  @Override
  public void tick(Location location) {
    this.counter += 1;
    Random tile = new Random();
    int exit = tile.nextInt(location.getExits().size());

    if (this.counter % 5 == 0) {
      location.getExits().get(exit).getDestination().addItem(new YewBerry("Yew Berry", 'x', true));
    }
  }
}
