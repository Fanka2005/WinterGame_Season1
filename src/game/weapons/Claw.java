package game.weapons;

import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;

/**
 * Class representing an intrinsic weapon called a Claw. This intrinsic weapon deals 75 damage
 * points with a 80% chance to hit the target.
 *
 * @author Fauzanda Lathifanka Sunarko
 */
public class Claw extends IntrinsicWeapon {

  public Claw() {
    super(75, "claw", 80, "claw");
  }
}