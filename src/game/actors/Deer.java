package game.actors;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.Behaviour;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.Weapon;
import game.actions.AttackAction;
import game.behaviours.WanderBehaviour;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Class representing a Deer.
 *
 * @author Fauzanda Lathifanka Sunarko
 */
public class Deer extends Actor {

  /**
   * Store the behaviours that the Deer can use
   */
  private final Map<Integer, Behaviour> behaviours = new TreeMap<>();

  /**
   * Constructor.
   *
   * @param name        Name to call the player in the UI
   * @param displayChar Character to represent the player in the UI
   * @param hitPoints   Player's starting number of hitpoints
   */

  public Deer(String name, char displayChar, int hitPoints) {
    super(name, displayChar, hitPoints);
    this.behaviours.put(999, new WanderBehaviour());
  }

  /**
   * Override the PlayTurn Method from Actor class At each turn, select a valid action to perform.
   *
   * @param actions    collection of possible Actions for this Actor
   * @param lastAction The Action this Actor took last turn. Can do interesting things in
   *                   conjunction with Action.getNextAction()
   * @param map        the map containing the Actor
   * @param display    the I/O object to which messages may be written
   * @return the valid action that can be performed in that iteration or null if no valid action is
   * found
   */
  @Override
  public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
    for (Behaviour behaviour : behaviours.values()) {
      Action action = behaviour.generateAction(this, map);
      if (action != null) {
        return action;
      }
    }
    return new DoNothingAction();

  }

  /**
   * Override the allowableAction from Actor class Returns a new collection of the Actions that the
   * otherActor can do to the current Actor.
   *
   * @param otherActor the Actor that might be performing attack
   * @param direction  String representing the direction of the other Actor
   * @param map        current GameMap
   * @return A collection of Actions.
   */
  @Override
  public ActionList allowableActions(Actor otherActor, String direction, GameMap map) {
    ActionList list = super.allowableActions(otherActor, direction, map);
    List<Weapon> weapons = otherActor.getItemInventoryAs(Weapon.class);

    if (weapons.isEmpty()) {
      list.add(new AttackAction(this, map.locationOf(this).toString(), null));
      return list;
    }

    for (Weapon weapon : weapons) {
      list.add(new AttackAction(this, map.locationOf(this).toString(), weapon));
    }

    return list;
  }

}

