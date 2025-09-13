package game.actors;

import static edu.monash.fit2099.engine.actors.attributes.BaseAttributes.MANA;
import static edu.monash.fit2099.engine.actors.attributes.BaseAttributes.STAMINA;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.attributes.BaseActorAttribute;
import edu.monash.fit2099.engine.actors.attributes.BaseAttributes;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.displays.Menu;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.Weapon;
import game.actions.AttackAction;
import game.weapons.BareFist;
import java.util.List;

/**
 * Class representing the Player.
 *
 * @author Adrian Kristanto
 */
public class Player extends Actor {

    /**
     * Constructor.
     *
     * @param name        Name to call the player in the UI
     * @param displayChar Character to represent the player in the UI
     * @param hitPoints   Player's starting number of hitpoints
     */
    public Player(String name, char displayChar, int hitPoints) {
        super(name, displayChar, hitPoints);
        this.setIntrinsicWeapon(new BareFist());

        //STAMINA : Hydration Level, MANA: Warmth Level
        this.addNewStatistic(BaseAttributes.STAMINA, new BaseActorAttribute(20));
        this.addNewStatistic(BaseAttributes.MANA, new BaseActorAttribute(30));
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
        // Handle multi-turn Actions
        if (lastAction.getNextAction() != null) {
            return lastAction.getNextAction();
        }

        display.println(
            this + "\n" + "Hydration Level: " + this.getAttribute(STAMINA) + "\n" + "Warmth Level: "
                + this.getAttribute(
                MANA));

        // return/print the console menu
        Menu menu = new Menu(actions);
        return menu.showMenu(this, display);
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