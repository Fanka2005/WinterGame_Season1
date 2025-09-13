package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.Weapon;

/**
 * Class representing an action to attack Note that the attacker must have a weapon.
 *
 * @author Fauzanda Lathifanka Sunarko
 */
public class AttackAction extends Action {

  /**
   * Store the Actor that is to be attacked
   */
  private final Actor target;

  /**
   * Stor the direction of incoming attack.
   */
  private final String direction;

  /**
   * Store the weapon used for the attack
   */
  private Weapon weapon;

  /**
   * Constructor.
   *
   * @param target    the Actor to attack
   * @param direction the direction where the attack should be performed
   */
  public AttackAction(Actor target, String direction, Weapon weapon) {
    this.target = target;
    this.direction = direction;
    this.weapon = weapon;
  }

  /**
   * Constructor with intrinsic weapon as default
   *
   * @param target    the actor to attack
   * @param direction the direction where the attack should be performed
   */
  public AttackAction(Actor target, String direction) {
    this.target = target;
    this.direction = direction;
  }

  /**
   * Override the abstract method execute in the Action class, Execute the Attack action
   *
   * @param actor is the actor object
   * @param map   is the game map
   * @return a string
   */
  @Override
  public String execute(Actor actor, GameMap map) {
    if (weapon == null) {
      weapon = actor.getIntrinsicWeapon();
    }

    String result = weapon.attack(actor, target, map);
    if (!target.isConscious()) {
      result += "\n" + target.unconscious(actor, map);
    }

    return result;
  }

  /**
   * Override the abstract method menuDescription in the Action class Menu Description for the
   * Attack Action.
   *
   * @param actor is the Actor object
   * @return a string
   */
  @Override
  public String menuDescription(Actor actor) {
    return actor + " attacks " + target + " at " + direction + " with " + (weapon != null ? weapon
        : "Intrinsic Weapon");
  }
}
