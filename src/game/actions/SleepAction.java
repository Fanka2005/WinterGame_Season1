package game.actions;

import edu.monash.fit2099.engine.GameEntity;
import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.capabilities.Status;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.capabilities.Sleepable;

public class SleepAction extends Action implements Status {
  /**
   * Store the sleepable object
   */
  private Sleepable sleepable;

  /**
   * Store the sleep duration
   */
  private int duration;

  /**
   * Store the sleep location
   */
  private Location location;

  /**
   * DrinkAction Constructor
   *
   * @param sleepable is a drinkable object
   */
  public SleepAction(Sleepable sleepable, int duration, Location location) {
    this.sleepable = sleepable;
    this.duration = duration;
    this.location = location;
  }


  /**
   * Called once per tick to update the status of the current entity. Default
   * implementation does nothing.
   *
   * @param currEntity the entity this status is attached to
   */
  @Override
  public void tickStatus(GameEntity currEntity, Location location) {
    if (sleepable != null) {
      this.duration--;
    }
  }

  /**
   * Indicates whether this status is still active.
   *
   * @return true if active, false otherwise
   */
  @Override
  public boolean isStatusActive() {
    return duration != 0;
  }

  /**
   * This provides a mechanism for Actions to take more than one turn.
   * For example, an action can change its state and return itself, or return the next Action in a series.
   * By default, this returns null, indicating that the Action will complete in one turn.
   * @return null
   */
  public Action getNextAction() {
    return new SleepAction(this.sleepable, this.duration, this.location);
  }

  /**
   * Override the abstract method execute in the Action class
   *
   * @param actor   is the actor object
   * @param map is the game map
   * @return a string
   */
  @Override
  public String execute(Actor actor, GameMap map) {
    if(this.isStatusActive()){
      this.tickStatus(actor, this.location);
      this.getNextAction();
    }
    return sleepable.sleptBy(actor);
  }

  /**
   * Override the abstract method menuDescription in the Action class
   *
   * @param actor is the Actor object
   * @return a string
   */
  @Override
  public String menuDescription(Actor actor) {
    return actor + " will sleep in " + sleepable.getClass().getSimpleName();
  }
}
