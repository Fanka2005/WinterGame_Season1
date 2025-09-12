package game.items;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.attributes.ActorAttributeOperation;
import edu.monash.fit2099.engine.actors.attributes.BaseAttributes;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Location;
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
  public Bottle(int maxCapacity) {
    super("Bottle", 'B', true);
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
    this.remainCapacity -= 1;
    actor.modifyAttribute(BaseAttributes.STAMINA, ActorAttributeOperation.INCREASE, 4);
    return actor + " drinks from this bottle" + this.remainCapacity + "/" + this.maxCapacity;
  }

  /**
   * List of allowable actions that can be performed on the Bedroll when it is on the ground
   *
   * @param location the location of the ground on which the item lies
   * @return an unmodifiable list of Actions
   */
  @Override
  public ActionList allowableActions(Location location) {
    ActionList actions = new ActionList();
    actions.add(new DrinkAction(this));
    return actions;
  }
}
