package game.capabilities;

import edu.monash.fit2099.engine.actors.Actor;

/**
 * Interface representing and is a contract for Sleepable object
 *
 * @author Fauzanda Lathifanka Sunarko
 */
public interface Sleepable {

  /**
   * The sleptBy methods, which will provide the implementation for the Sleep Action
   *
   * @param actor is the actor object
   * @return a string that inform what happened.
   */
  String sleptBy(Actor actor);
}

