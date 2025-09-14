package game.grounds;


import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.items.Apple;
import java.util.Random;

/**
 * A class representing Apple Tree on the ground.
 *
 * @author Fauzanda Lathifanka Sunarko
 */
public class AppleTree extends Ground {

  /**
   * Store the tick counter, to keep track of time
   */
  private int counter;

  /**
   * Constructor for Apple Tree
   *
   * @param displayChar the char that will be displayed which represent apple tree
   * @param name        the name of the apple tree
   */
  public AppleTree(char displayChar, String name) {
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

    if (this.counter % 3 == 0) {
      location.getExits().get(exit).getDestination().addItem(new Apple("Apple", 'a', true));
    }
  }
}
