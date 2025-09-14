package game.items;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.attributes.ActorAttributeOperation;
import edu.monash.fit2099.engine.actors.attributes.BaseAttributes;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actions.ConsumeAction;
import game.capabilities.Consumable;
import game.statuses.PlayerAlive;

/**
 * A class that extends abstract class Item and implements interface Consumable, this class
 * represents an Apple. Created by:
 *
 * @author Fauzanda Lathifanka Sunarko
 */
public class Apple extends Item implements Consumable {

  /**
   * Store the constant Health value
   */
  private final int INCREASE_HEALTH_VALUE;

  /**
   * Store the constant Hydration value
   */
  private final int INCREASE_HYDRATION_VALUE;

  /***
   * Apple class Constructor.
   *
   */
  public Apple(String name, char displayChar, boolean value) {
    super(name, displayChar, value);
    this.INCREASE_HEALTH_VALUE = 3;
    this.INCREASE_HYDRATION_VALUE = 2;
  }

  /**
   * The consumedBy methods, Contains part of the implementation for the Consume Action
   *
   * @param actor is the actor object
   * @return a string that inform what happened.
   */
  @Override
  public String consumedBy(Actor actor) {
    if (actor.hasStatus(PlayerAlive.class)) {
      actor.modifyAttribute(BaseAttributes.STAMINA, ActorAttributeOperation.INCREASE,
          this.INCREASE_HYDRATION_VALUE);
      actor.modifyAttribute(BaseAttributes.HEALTH, ActorAttributeOperation.INCREASE,
          this.INCREASE_HEALTH_VALUE);
      return actor + " consumes the " + this + " and restore " + this.INCREASE_HEALTH_VALUE
          + " Health and " + this.INCREASE_HYDRATION_VALUE + " Hydration";
    } else {
      actor.modifyAttribute(BaseAttributes.HEALTH, ActorAttributeOperation.INCREASE,
          this.INCREASE_HEALTH_VALUE);
      return actor + " consumes the " + this + " and restore " + this.INCREASE_HEALTH_VALUE;
    }
  }

  /**
   * List of allowable actions that the Apple can perform to its owner or to the current map while
   * being carried by an actor.
   *
   * @param owner the actor that owns the item
   * @param map   the map where the actor is performing the action on
   * @return an unmodifiable list of Actions
   */
  public ActionList allowableActions(Actor owner, GameMap map) {
    ActionList actions = new ActionList();
    actions.add(new ConsumeAction(this));
    return actions;
  }
}