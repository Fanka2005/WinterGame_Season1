package game.items;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.Location;
import game.actions.SleepAction;
import game.capabilities.Sleepable;
import java.util.Random;


/**
 * A class that extends abstract class Item and implements interface Sleepable this class represents
 * a Bedroll. Created by:
 *
 * @author Fauzanda Lathifanka Sunarko
 */
public class Bedroll extends Item implements Sleepable {

  /**
   * Store the random instance
   */
  private final Random random = new Random();

  /**
   * Store the sleep duration
   */
  private int duration;

  /**
   * Bedroll class Constructor
   */
  public Bedroll(String name, char displayChar, boolean value) {
    super(name, displayChar, value);
  }

  /**
   * The sleptBy methods, Contains part of the implementation for the Sleep Action
   *
   * @param actor is the actor object
   * @return a string that inform what happened.
   */
  @Override
  public String sleptBy(Actor actor) {
    return actor + " wakes up";
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
    this.duration = random.nextInt(6,11);
    actions.add(new SleepAction(this, this.duration));
    return actions;
  }


}