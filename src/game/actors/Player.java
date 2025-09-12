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
import game.BareFist;

/**
 * Class representing the Player.
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

    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        // Handle multi-turn Actions
        if (lastAction.getNextAction() != null)
            return lastAction.getNextAction();

        display.println(
            this + "\n" + "Hydration Level: " + this.getAttribute(STAMINA) + "\n" + "Warmth Level: "
                + this.getAttribute(
                MANA));

        // return/print the console menu
        Menu menu = new Menu(actions);
        return menu.showMenu(this, display);
    }
}