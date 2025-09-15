package game.behaviours;

import static game.Abilities.TAME_BEAR;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.Behaviour;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;

/**
 * Class representing a Collect drops Behaviour of the beast (Non-Player Actor object) Can Only
 * collect hazelnut, because bear loves hazelnut.
 *
 * @author Fauzanda Lathifanka Sunarko
 */
public class CollectDropsBehaviour implements Behaviour {

  /**
   * Store the beast/Non-Player actor owner
   */
  private final Actor owner;

  /**
   * Constructor, initialise the owner
   *
   * @param owner the beast/animal owner
   */
  public CollectDropsBehaviour(Actor owner) {
    this.owner = owner;
  }

  /**
   * Implement generateAction method from Behaviour Interface The action to pick up Hazelnut Will
   * only pick up Hazelnut
   *
   * @param actor the Actor acting
   * @param map   the GameMap containing the Actor
   * @return an Action that the Non-Player actor object can use.
   */
  @Override
  public Action generateAction(Actor actor, GameMap map) {
    for (Item item : map.locationOf(actor).getItems()) {
      if (item.hasAbility(TAME_BEAR)) {
        return item.getPickUpAction(this.owner);

      }
    }
    return null;
  }
}
