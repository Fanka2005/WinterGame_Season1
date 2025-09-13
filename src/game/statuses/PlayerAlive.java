package game.statuses;

import edu.monash.fit2099.engine.GameEntity;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.attributes.ActorAttributeOperation;
import edu.monash.fit2099.engine.actors.attributes.BaseAttributes;
import edu.monash.fit2099.engine.capabilities.Status;
import edu.monash.fit2099.engine.positions.Location;

/**
 * <h1>PlayerAlive class</h1>
 * This class is used to implement Status interface, this class is used to represent whether the
 * player/explorer is alive.
 *
 * @author Fauzanda Lathifanka Sunarko
 */
public class PlayerAlive implements Status {

  /**
   * Store the actor object
   */
  private Actor actor;

  /**
   * PlayerAlive class Constructor
   *
   * @param actor is the actor object
   */
  public PlayerAlive(Actor actor) {
    this.actor = actor;
  }

  /**
   * Called once per tick to update the status of the current entity.
   *
   * @param currEntity the entity this status is attached to
   */
  @Override
  public void tickStatus(GameEntity currEntity, Location location) {
    if (!this.actor.hasStatus(Sleeping.class)) {
      this.actor.modifyAttribute(BaseAttributes.STAMINA, ActorAttributeOperation.DECREASE, 1);
      this.actor.modifyAttribute(BaseAttributes.MANA, ActorAttributeOperation.DECREASE, 1);
    }
  }

  /**
   * Indicates whether this status is still active.
   * It will return False if the HydrationLevel or WarmthLevel or Health Points is 0 or less
   * It will return True if the HydrationLevel, WarmthLevel and Health Points is all above 0
   *
   * @return true if active, false otherwise
   */
  @Override
  public boolean isStatusActive() {
    return (this.actor.getAttribute(BaseAttributes.STAMINA) >= 0) && (this.actor.getAttribute(BaseAttributes.MANA) >= 0) && (this.actor.getAttribute(BaseAttributes.HEALTH) > 0);
  }

}