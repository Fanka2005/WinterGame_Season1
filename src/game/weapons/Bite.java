package game.weapons;

import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;

/**
 * Class representing an intrinsic weapon called a Bite. This intrinsic weapon deals 50 damage
 * points with a 50% chance to hit the target.
 *
 * @author Fauzanda Lathifanka Sunarko
 */
public class Bite extends IntrinsicWeapon {

  /**
   * Bite Constructor
   */
  public Bite() {
    super(50, "Bites", 50, "Bite");
  }
}