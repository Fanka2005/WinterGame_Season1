package game.behaviours;

import static game.Abilities.CAN_TAME;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.Behaviour;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import java.util.ArrayList;
import java.util.Random;

/**
 * Class representing a Fight Alongside Behaviour of the beast (Non-Player Actor object)
 *
 * @author Fauzanda Lathifanka Sunarko
 */
public class FightAlongsideBehaviour implements Behaviour {

  /**
   * Store the java random instance
   */
  private final Random random = new Random();

  /**
   * Implement generateAction method from Behaviour Interface Will attack anyone (in the
   * beast/Non-Player Actor exits) except the owner
   *
   * @param actor the Actor acting
   * @param map   the GameMap containing the Actor
   * @return an Action that the Non-Player actor object can use.
   */
  @Override
  public Action generateAction(Actor actor, GameMap map) {
    ArrayList<Action> actions = new ArrayList<>();

    for (Exit exit : map.locationOf(actor).getExits()) {
      Location destination = exit.getDestination();

      if ((destination.getActor() != null) && (!destination.getActor().hasAbility(CAN_TAME))) {
        actions.addAll(
            destination.getActor().allowableActions(actor, map.locationOf(actor).toString(), map)
                .getUnmodifiableActionList());

      }
    }

    if (!actions.isEmpty()) {
      return actions.get(random.nextInt(actions.size()));
    } else {
      return null;
    }
  }

}
