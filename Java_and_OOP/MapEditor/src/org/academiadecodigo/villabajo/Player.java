package org.academiadecodigo.villabajo;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

/**
 * Started the exercise with Map and Player classes separated.
 * Later, refactored the structure so Player would be an inner class of Map
 */
public class Player implements KeyboardHandler {

    private Rectangle player;

    public Player() {
        player = new Rectangle(10,10,20,20);
        player.setColor(Color.GREEN);
        player.fill();
        keyboardInit();
    }

    public double getX() {
        return this.player.getX();
    }
    public double getY() {
        return this.player.getY();
    }


    // Keyboard init
    public void keyboardInit() {

        /*Keyboard keyboard = new Keyboard(this);

        // Up Key
        KeyboardEvent upPress = new KeyboardEvent();
        upPress.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        upPress.setKey(KeyboardEvent.KEY_UP);

        // Down Key
        KeyboardEvent downPress = new KeyboardEvent();
        downPress.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        downPress.setKey(KeyboardEvent.KEY_DOWN);

        // Left Key
        KeyboardEvent leftPress = new KeyboardEvent();
        leftPress.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        leftPress.setKey(KeyboardEvent.KEY_LEFT);

        // Right Key
        KeyboardEvent rightPress = new KeyboardEvent();
        rightPress.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        rightPress.setKey(KeyboardEvent.KEY_RIGHT);

        // Space Key
        KeyboardEvent spacePress = new KeyboardEvent();
        spacePress.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        spacePress.setKey(KeyboardEvent.KEY_SPACE);

        // Add the events created to be listened by the keyboard
        keyboard.addEventListener(upPress);
        keyboard.addEventListener(downPress);
        keyboard.addEventListener(leftPress);
        keyboard.addEventListener(rightPress);

        keyboard.addEventListener(spacePress);*/

    }

    // Moving the Player inside the "Grid"
    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        // don't need this right now
    }
}
