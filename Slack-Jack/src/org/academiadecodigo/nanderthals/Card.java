package org.academiadecodigo.nanderthals;

import org.academiadecodigo.nanderthals.Suit;
import org.academiadecodigo.nanderthals.Value;

public class Card {
    private Suit suit;
    private Value value;
    private String imagePath;

    public Card(Suit suit, Value value,String imagePath) {
        this.value = value;
        this.suit = suit;
        this.imagePath = imagePath;
    }

    public String toString() {
        return this.suit.toString() + "-" + this.value.toString();
    }

    public Value getValue() {
        return this.value;
    }

    public String getImagePath() {
        return this.imagePath;
    }

}
