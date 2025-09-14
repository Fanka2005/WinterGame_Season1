package game.capabilities;

import edu.monash.fit2099.engine.actors.Actor;

/**
 * Interface representing and is a contract for Drinkable object
 *
 * @author Fauzanda Lathifanka Sunarko
 */
public interface Drinkable {

  /**
   * The drinkBy methods, which will provide the implementation for the Drink Action
   *
   * @param actor is the actor object
   * @return a string that inform what happened.
   */
  String drunkBy(Actor actor);
}

