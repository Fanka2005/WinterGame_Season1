package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.capabilities.Drinkable;

public class DrinkAction extends Action {
  /**
   * Store the drinkable object
   */
  private Drinkable drinkable;

  /**
   * DrinkAction Constructor
   *
   * @param drinkable is a drinkable object
   */
  public DrinkAction(Drinkable drinkable) {
    this.drinkable = drinkable;
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
    return drinkable.drunkBy(actor);
  }

  /**
   * Override the abstract method menuDescription in the Action class
   *
   * @param actor is the Actor object
   * @return a string
   */
  @Override
  public String menuDescription(Actor actor) {
    return actor + " will drink from " + drinkable.getClass().getSimpleName();
  }

}
