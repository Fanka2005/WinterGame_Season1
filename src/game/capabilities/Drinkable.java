package game.capabilities;

import edu.monash.fit2099.engine.actors.Actor;

public interface Drinkable {
  /**
   * The drinkBy methods, which will provide the implementation
   * for the Drink Action
   *
   * @param actor   is the actor object
   * @return a string that inform what happened.
   */
  public String drunkBy(Actor actor);
}
