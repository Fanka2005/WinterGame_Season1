package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.capabilities.Sleepable;
import game.statuses.Sleeping;

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
   * Store the duration
   */
  private int duration;

  /**
   * SleepAction Constructor
   *
   * @param sleepable is the sleepable object
   */
  public SleepAction(Sleepable sleepable, int duration) {
    this.sleepable = sleepable;
    this.duration = duration;
  }

  /**
   * This provides a mechanism for Actions to take more than one turn. For example, an action can
   * change its state and return itself, or return the next Action in a series. By default, this
   * returns null, indicating that the Action will complete in one turn.
   */
  @Override
  public Action getNextAction() {
    if(this.duration>0) {
      return new SleepAction(this.sleepable, this.duration-1);}
    return null;
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
    if(!actor.hasStatus(Sleeping.class)){
      actor.addStatus(new Sleeping(this.duration));
    }
    if(this.duration>0) {
      return actor + " is sleeping, " + this.duration + " more turns";
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
    return actor + " will sleep in " + this.sleepable + " for " + this.duration + " turns";
  }

}

