package game.capabilities;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;

/**
 * Interface representing and is a signature for Consumable object
 *
 * @author Fauzanda Lathifanka Sunarko
 */
public interface Consumable {

  /**
   * The consumedBy methods, which will provide the implementation for the Consumed Action
   *
   * @param actor is the actor object
   * @return a string that inform what happened.
   */
  String consumedBy(Actor actor, GameMap map);
}
