package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.capabilities.Consumable;
import game.capabilities.Tameable;

/**
 * <h1>TameAction class</h1>
 * This class is used extend the abstract Action class for Tame action
 *
 * @author Fauzanda Lathifanka Sunarko
 */
public class TameAction extends Action {

  /**
   * Store the tameable object
   */
  private final Tameable tameable;

  /**
   * Store the tameable object
   */
  private final Consumable consumable;

  /**
   * TameAction Constructor
   *
   * @param tameable is a tameable object
   */
  public TameAction(Tameable tameable, Consumable item) {
    this.tameable = tameable;
    this.consumable = item;
  }

  /**
   * Override the abstract method execute in the Action class
   *  Execute the tamedBy method in Tameable interface.
   *
   * @param actor is the actor object
   * @param map   is the game map
   * @return a string
   */
  @Override
  public String execute(Actor actor, GameMap map) {
    return tameable.tamedBy(actor, map, this.consumable);
  }

  /**
   * Override the abstract method menuDescription in the Action class
   *
   * @param actor is the Actor object
   * @return a string
   */
  @Override
  public String menuDescription(Actor actor) {
    return actor + " will tame " + this.tameable;
  }

}
