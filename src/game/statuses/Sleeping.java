package game.statuses;

import edu.monash.fit2099.engine.GameEntity;
import edu.monash.fit2099.engine.capabilities.Status;
import edu.monash.fit2099.engine.positions.Location;

/**
 * <h1>Sleeping class</h1>
 * This class is used to implement Status interface, this class is used to represent the player status
 * sleeping
 *
 * @author Fauzanda Lathifanka Sunarko
 */
public class Sleeping implements Status {

  /**
   * Store the duration
   */
  private int duration;

  /**
   * Sleeping class Constructor
   *
   * @param duration is the duration of sleep (turns)
   */
  public Sleeping(int duration) {
    this.duration = duration;
  }

  /**
   * Called once per tick to update the status of the current entity. Default implementation does
   * nothing.
   *
   * @param currEntity the entity this status is attached to
   */
  @Override
  public void tickStatus(GameEntity currEntity, Location location) {
    this.duration -= 1;
  }

  /**
   * Indicates whether this status is still active.
   *
   * @return true if active, false otherwise
   */
  @Override
  public boolean isStatusActive() {
    return this.duration > 0;
  }

}