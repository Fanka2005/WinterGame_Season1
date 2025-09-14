package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.capabilities.Consumable;

/**
 * <h1>ConsumeAction class</h1>
 * This class is used extend the abstract Action class for Consume action
 *
 * @author Fauzanda Lathifanka Sunarko
 */
public class ConsumeAction extends Action {

  /**
   * Store the consumable object
   */
  private final Consumable consumable;

  /**
   * ConsumeAction Constructor
   *
   * @param consumable is a consumable object
   */
  public ConsumeAction(Consumable consumable) {
    this.consumable = consumable;
  }

  /**
   * Override the abstract method execute in the Action class
   *
   * @param actor is the actor object
   * @param map   is the game map
   * @return a string
   */
  @Override
  public String execute(Actor actor, GameMap map) {
    return consumable.consumedBy(actor);
  }

  /**
   * Override the abstract method menuDescription in the Action class
   *
   * @param actor is the Actor object
   * @return a string
   */
  @Override
  public String menuDescription(Actor actor) {
    return actor + " will consume " + this.consumable;
  }

}
