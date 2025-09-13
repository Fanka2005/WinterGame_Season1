package game.items;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.attributes.ActorAttributeOperation;
import edu.monash.fit2099.engine.actors.attributes.BaseAttributes;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actions.DrinkAction;
import game.capabilities.Drinkable;

/**
 * A class that extends abstract class Item and implements interface Sleepable, this class
 * represents a Bottle. Created by:
 *
 * @author Fauzanda Lathifanka Sunarko
 */
public class Bottle extends Item implements Drinkable {

  /**
   * Store the bottle maximum capacity
   */
  private final int maxCapacity;

  /**
   * Store the bottle remaining capacity
   */
  private int remainCapacity;

  /***
   * Bottle class Constructor.
   *
   */
  public Bottle(String name, char displayChar, boolean value, int maxCapacity) {
    super(name, displayChar, value);
    this.maxCapacity = maxCapacity;
    this.remainCapacity = maxCapacity;
  }

  /**
   * The sleptBy methods, Contains part of the implementation for the Sleep Action
   *
   * @param actor is the actor object
   * @return a string that inform what happened.
   */
  @Override
  public String drunkBy(Actor actor) {
    if (this.remainCapacity == 0) {
      return "Water bottle is empty";
    }
    this.remainCapacity -= 1;
    actor.modifyAttribute(BaseAttributes.STAMINA, ActorAttributeOperation.INCREASE, 4);
    return actor + " drinks from this bottle " + this.remainCapacity + "/" + this.maxCapacity
        + " remaining";
  }

  /**
   * List of allowable actions that the bottle can perform to its owner or to the current map while
   * being carried by an actor.
   *
   * @param owner the actor that owns the item
   * @param map   the map where the actor is performing the action on
   * @return an unmodifiable list of Actions
   */
  public ActionList allowableActions(Actor owner, GameMap map) {
    ActionList actions = new ActionList();
    actions.add(new DrinkAction(this));
    return actions;
  }
}
