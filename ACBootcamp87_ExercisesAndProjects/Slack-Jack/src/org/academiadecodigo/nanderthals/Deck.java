package org.academiadecodigo.nanderthals;

import java.util.ArrayList;
import java.util.Random;
import org.academiadecodigo.nanderthals.Card;

public class Deck {
    private ArrayList <Card> cards;

    public Deck(){
        this.cards = new ArrayList<Card>();
    }

    public void createFullDeck() {
        //Generate cards
        for(Suit cardSuit : Suit.values()){
            for(Value cardValue : Value.values()) {
                //Add a new card to the deck
                String imagePath = getImagePath(cardSuit, cardValue);
                this.cards.add(new Card(cardSuit,cardValue,imagePath));
            }
        }
    }

    private String getImagePath(Suit cardSuit, Value cardValue) {
        String imagePath;

        switch (cardSuit) {
            case CLUB:
                switch (cardValue) {
                    case ACE:
                        imagePath = "images/clubs/ace_of_clubs.png";
                        break;
                    case TWO:
                        imagePath = "images/clubs/2_of_clubs.png";
                        break;
                    case THREE:
                        imagePath = "images/clubs/3_of_clubs.png";
                        break;
                    case FOUR:
                        imagePath = "images/clubs/4_of_clubs.png";
                        break;
                    case FIVE:
                        imagePath = "images/clubs/5_of_clubs.png";
                        break;
                    case SIX:
                        imagePath = "images/clubs/6_of_clubs.png";
                        break;
                    case SEVEN:
                        imagePath = "images/clubs/7_of_clubs.png";
                        break;
                    case EIGHT:
                        imagePath = "images/clubs/8_of_clubs.png";
                        break;
                    case NINE:
                        imagePath = "images/clubs/9_of_clubs.png";
                        break;
                    case TEN:
                        imagePath = "images/clubs/10_of_clubs.png";
                        break;
                    case JACK:
                        imagePath = "images/clubs/jack_of_clubs2.png";
                        break;
                    case QUEEN:
                        imagePath = "images/clubs/queen_of_clubs2.png";
                        break;
                    case KING:
                        imagePath = "images/clubs/king_of_clubs2.png";
                        break;
                    default:
                        imagePath = "images/cardback.png";
                        break;
                }
                break;

            case DIAMOND:
                switch (cardValue) {
                    case ACE:
                        imagePath = "images/diamonds/ace_of_diamonds.png";
                        break;
                    case TWO:
                        imagePath = "images/diamonds/2_of_diamonds.png";
                        break;
                    case THREE:
                        imagePath = "images/diamonds/3_of_diamonds.png";
                        break;
                    case FOUR:
                        imagePath = "images/diamonds/4_of_diamonds.png";
                        break;
                    case FIVE:
                        imagePath = "images/diamonds/5_of_diamonds.png";
                        break;
                    case SIX:
                        imagePath = "images/diamonds/6_of_diamonds.png";
                        break;
                    case SEVEN:
                        imagePath = "images/diamonds/7_of_diamonds.png";
                        break;
                    case EIGHT:
                        imagePath = "images/diamonds/8_of_diamonds.png";
                        break;
                    case NINE:
                        imagePath = "images/diamonds/9_of_diamonds.png";
                        break;
                    case TEN:
                        imagePath = "images/diamonds/10_of_diamonds.png";
                        break;
                    case JACK:
                        imagePath = "images/diamonds/jack_of_diamonds2.png";
                        break;
                    case QUEEN:
                        imagePath = "images/diamonds/queen_of_diamonds2.png";
                        break;
                    case KING:
                        imagePath = "images/diamonds/king_of_diamonds2.png";
                        break;
                    default:
                        imagePath = "images/cardback.png";
                        break;
                }
                break;

            case HEART:
                switch (cardValue) {
                    case ACE:
                        imagePath = "images/hearts/ace_of_hearts.png";
                        break;
                    case TWO:
                        imagePath = "images/hearts/2_of_hearts.png";
                        break;
                    case THREE:
                        imagePath = "images/hearts/3_of_hearts.png";
                        break;
                    case FOUR:
                        imagePath = "images/hearts/4_of_hearts.png";
                        break;
                    case FIVE:
                        imagePath = "images/hearts/5_of_hearts.png";
                        break;
                    case SIX:
                        imagePath = "images/hearts/6_of_hearts.png";
                        break;
                    case SEVEN:
                        imagePath = "images/hearts/7_of_hearts.png";
                        break;
                    case EIGHT:
                        imagePath = "images/hearts/8_of_hearts.png";
                        break;
                    case NINE:
                        imagePath = "images/hearts/9_of_hearts.png";
                        break;
                    case TEN:
                        imagePath = "images/hearts/10_of_hearts.png";
                        break;
                    case JACK:
                        imagePath = "images/hearts/jack_of_hearts2.png";
                        break;
                    case QUEEN:
                        imagePath = "images/hearts/queen_of_hearts2.png";
                        break;
                    case KING:
                        imagePath = "images/hearts/king_of_hearts2.png";
                        break;
                    default:
                        imagePath = "images/cardback.png";
                        break;
                }
                break;

            case SPADE:
                switch (cardValue) {
                    case ACE:
                        imagePath = "images/spades/ace_of_spades2.png";
                        break;
                    case TWO:
                        imagePath = "images/spades/2_of_spades.png";
                        break;
                    case THREE:
                        imagePath = "images/spades/3_of_spades.png";
                        break;
                    case FOUR:
                        imagePath = "images/spades/4_of_spades.png";
                        break;
                    case FIVE:
                        imagePath = "images/spades/5_of_spades.png";
                        break;
                    case SIX:
                        imagePath = "images/spades/6_of_spades.png";
                        break;
                    case SEVEN:
                        imagePath = "images/spades/7_of_spades.png";
                        break;
                    case EIGHT:
                        imagePath = "images/spades/8_of_spades.png";
                        break;
                    case NINE:
                        imagePath = "images/spades/9_of_spades.png";
                        break;
                    case TEN:
                        imagePath = "images/spades/10_of_spades.png";
                        break;
                    case JACK:
                        imagePath = "images/spades/jack_of_spades2.png";
                        break;
                    case QUEEN:
                        imagePath = "images/spades/queen_of_spades2.png";
                        break;
                    case KING:
                        imagePath = "images/spades/king_of_spades2.png";
                        break;
                    default:
                        imagePath = "images/cardback.png";
                        break;
                }
                break;

            default:
                imagePath = "images/cardback.png";
                break;
        }

        return imagePath;
    }


    // Shuffle the Deck
    public void shuffle(){
        ArrayList<Card> temporaryDeck = new ArrayList<Card>();
        Random random = new Random();
        int randomCardIndex = 0;
        int originalSize = this.cards.size();
        for (int i = 0; i < originalSize; i++) {
            //Generate Random Index rand.nextInt((max-min) + 1) + min
            randomCardIndex = random.nextInt((this.cards.size()-1 - 0) + 1) + 0;
            temporaryDeck.add(this.cards.get(randomCardIndex));
            //Remove from original deck
            this.cards.remove(randomCardIndex);
        }
        this.cards = temporaryDeck;
    }

    @Override
    public String toString() {
        String cardListOutput = "";
        for(Card aCard : this.cards) {
            cardListOutput += "\n-" + aCard.toString();
        }
        return cardListOutput;
    }

    public void removeCard(int i){
        this.cards.remove(i);
    }

    public Card getCard(int i){
        return this.cards.get(i);
    }

    public void addCard(Card addCard){
        this.cards.add(addCard);
    }

    // Draw a card from the playing Deck
    public void draw(Deck comingFrom){
        this.cards.add(comingFrom.getCard(0));
        comingFrom.removeCard(0);
    }

    public int deckSize(){
        return this.cards.size();
    }

    // Move cards from a Deck to another Deck
    public void moveAllToDeck(Deck moveTo){
        int thisDeckSize = this.cards.size();
        
        //put cards into moveTo deck
        for (int i = 0; i < thisDeckSize; i++) {
            moveTo.addCard(this.getCard(i));
            }

        for (int i = 0; i < thisDeckSize; i++) {
            this.removeCard(0);
        }

    }



    // Return total value of cards in deck
    public int cardsValue(){
        int totalValue = 0;
        int aces = 0;

        for (Card aCard : this.cards) {
            switch (aCard.getValue()) {
                case TWO : {
                    totalValue += 2;
                    break;
                }
                case THREE : {
                    totalValue += 3;
                    break;
                }
                case FOUR : {
                    totalValue += 4;
                    break;
                }
                case FIVE : {
                    totalValue += 5;
                    break;
                }
                case SIX : {
                    totalValue += 6;
                    break;
                }
                case SEVEN : {
                    totalValue += 7;
                    break;
                }
                case EIGHT : {
                    totalValue += 8;
                    break;
                }
                case NINE : {
                    totalValue += 9;
                    break;
                }
                case TEN : {
                    totalValue += 10;
                    break;
                }
                case JACK : {
                    totalValue += 10;
                    break;
                }
                case QUEEN : {
                    totalValue += 10;
                    break;
                }
                case KING : {
                    totalValue += 10;
                    break;
                }
                case ACE : {
                    aces += 1;
                    break;
                }
            }
        }
        for (int i = 0; i < aces; i++) {

            if(totalValue> 10) {
                totalValue += 1;
            } else {
                totalValue += 11;
            }    
        }
        return totalValue;
    }


}
