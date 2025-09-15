package game.capabilities;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;

/**
 * Interface representing and is a signature for Tameable actor
 *
 * @author Fauzanda Lathifanka Sunarko
 */
public interface Tameable {

  /**
   * The tamedBy methods, which will provide the implementation for the Tame Action
   *
   * @param actor is the actor object
   * @return a string that inform what happened.
   */
  String tamedBy(Actor actor, GameMap map, Consumable item);
}
