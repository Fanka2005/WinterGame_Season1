package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.capabilities.Sleepable;

/**
 * <h1>SleepAction class</h1>
 * This class is used extend the abstract Action class for Sleeping action
 *
 * @author Fauzanda Lathifanka Sunarko
 */
public class SleepAction extends Action {
  /**
   * Store the sleepable object
   */
  private Sleepable sleepable;

  /**
   * SleepAction Constructor
   *
   * @param sleepable is the sleepable object
   */
  public SleepAction(Sleepable sleepable) {
    this.sleepable = sleepable;
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
    return actor + " will sleep on " + this.sleepable;
  }

}

