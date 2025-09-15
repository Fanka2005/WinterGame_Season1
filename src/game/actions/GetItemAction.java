package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;

/**
 * <h1>DrinkAction class</h1>
 * This class is used extend the abstract Action class for Drinking action
 *
 * @author Fauzanda Lathifanka Sunarko
 */
public class GetItemAction extends Action {

  private final Actor tamedActor;

  /**
   * DrinkAction Constructor
   */
  public GetItemAction(Actor tamedActor) {
    this.tamedActor = tamedActor;
  }

  /**
   * Override the abstract method execute in the Action class This will let the player/owner to get
   * an item from the tamed Beast
   *
   * @param actor is the actor object
   * @param map   is the game map
   * @return a string
   */
  @Override
  public String execute(Actor actor, GameMap map) {
    Item item = tamedActor.getItemInventory().get(0);
    actor.addItemToInventory(item);
    return item + " has been added to " + actor + " Inventory";
  }

  /**
   * Override the abstract method menuDescription in the Action class
   *
   * @param actor is the Actor object
   * @return a string
   */
  @Override
  public String menuDescription(Actor actor) {
    return actor + " will get a Hazelnut from " + this.tamedActor;
  }

}