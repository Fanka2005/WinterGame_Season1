package game.items;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.attributes.ActorAttributeOperation;
import edu.monash.fit2099.engine.actors.attributes.BaseAttributes;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actions.ConsumeAction;
import game.capabilities.Consumable;

/**
 * A class that extends abstract class Item and implements interface Consumable, this class
 * represents a Hazelnut. Created by:
 *
 * @author Fauzanda Lathifanka Sunarko
 */
public class Hazelnut extends Item implements Consumable {

  /**
   * Store the constant Health value
   */
  private final int INCREASE_HEALTH_VALUE;

  /***
   * Hazelnut class Constructor.
   *
   */
  public Hazelnut(String name, char displayChar, boolean value) {
    super(name, displayChar, value);
    this.INCREASE_HEALTH_VALUE = 1;
  }

  /**
   * The consumedBy methods, Contains part of the implementation for the Consume Action
   *
   * @param actor is the actor object
   * @return a string that inform what happened.
   */
  @Override
  public String consumedBy(Actor actor, GameMap map) {

    actor.modifyStatsMaximum(BaseAttributes.HEALTH, ActorAttributeOperation.INCREASE,
        this.INCREASE_HEALTH_VALUE);

    return actor + " consumes the " + this + " and restore " + this.INCREASE_HEALTH_VALUE;
  }

  /**
   * List of allowable actions that the Hazelnut can perform to its owner or to the current map
   * while being carried by an actor.
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
