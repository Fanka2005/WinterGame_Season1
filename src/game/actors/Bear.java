package game.actors;

import static game.Abilities.CAN_TAME;
import static game.Abilities.TAME_BEAR;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.DoNothingAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.Behaviour;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.Weapon;
import game.actions.AttackAction;
import game.actions.ConsumeAction;
import game.actions.GetItemAction;
import game.actions.TameAction;
import game.behaviours.CollectDropsBehaviour;
import game.behaviours.FightAlongsideBehaviour;
import game.behaviours.FollowBehaviour;
import game.capabilities.Consumable;
import game.capabilities.Tameable;
import game.weapons.Claw;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Class representing a Bear.
 *
 * @author Fauzanda Lathifanka Sunarko
 */
public class Bear extends Actor implements Tameable {

  /**
   * Store the behaviours that the Bear can use
   */
  private final Map<Integer, Behaviour> behaviours = new TreeMap<>();

  /**
   * Constructor.
   *
   * @param name        Name to call the player in the UI
   * @param displayChar Character to represent the player in the UI
   * @param hitPoints   Player's starting number of hitpoints
   */

  public Bear(String name, char displayChar, int hitPoints) {
    super(name, displayChar, hitPoints);
    this.setIntrinsicWeapon(new Claw());
  }

  /**
   * Add Behaviour Method
   *
   * @param order     the behaviour order
   * @param behaviour is the behaviour
   */
  public void addBehaviour(int order, Behaviour behaviour) {
    this.behaviours.put(order, behaviour);
  }

  /**
   * The tamedBy methods, which will provide the implementation for the Tame Action Once a
   * beast/Non-Player actor is tamed by the explorer, it will have 3 behaviours which are :
   * FightAlongside Behaviour Collect Hazelnut Behaviour Follow owner behaviour
   *
   * @param actor is the actor object
   * @return a string that inform what happened.
   */
  @Override
  public String tamedBy(Actor actor, GameMap map, Consumable item) {
    actor.removeItemFromInventory((Item) item);
    Action consume = new ConsumeAction(item);
    String message = consume.execute(this, map);
    this.addBehaviour(0, new FightAlongsideBehaviour());
    this.addBehaviour(1, new CollectDropsBehaviour());
    this.addBehaviour(2, new FollowBehaviour(actor));
    return message + " given by " + actor + " and is tamed";
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

    } else {
      for (Weapon weapon : weapons) {
        list.add(new AttackAction(this, map.locationOf(this).toString(), weapon));
      }
    }

    if (otherActor.hasAbility(CAN_TAME)) {
      for (Consumable item : otherActor.getItemInventoryAs(Consumable.class)) {
        if (((Item) item).hasAbility(TAME_BEAR)) {
          list.add(new TameAction(this, item));
        }
      }
      if (!this.getItemInventory().isEmpty()) {
        list.add(new GetItemAction(this));
      }
    }
    return list;
  }

}