package game.capabilities;

import edu.monash.fit2099.engine.actors.Actor;

public interface Sleepable {
  /**
   * The sleptBy methods, which will provide the implementation
   * for the Sleep Action
   *
   * @param actor   is the actor object
   * @return a string that inform what happened.
   */
  public String sleptBy(Actor actor);
}

