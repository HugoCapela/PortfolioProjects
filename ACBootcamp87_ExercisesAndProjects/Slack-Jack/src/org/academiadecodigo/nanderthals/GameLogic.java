package org.academiadecodigo.nanderthals;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class GameLogic {

    public static final int TIME_TO_CLOSE_GAME_CARDS = 650;
    private final int PCINITX = 450;
    private final int PCINITY = 435;
    private final int DCINITX = 450;
    private final int DCINITY = 20;
    private final int CINC = 50;

    private Deck playingDeck = new Deck(); // The Playing Deck for Cards
    private Deck playerDeck = new Deck(); // A Deck of Cards for the Player
    private Deck dealerDeck = new Deck(); // A Deck of Cards for the Dealer
    private int playerMoney = 250; // The Player initial bet amount
    private boolean validBet = false; // Boolean to validate the Player Bet -> False by default
    private int playerBet; // The Player's Bet
    private boolean endRound; // Boolean to determine if the Round is/is not finished

    private Text totalMoney;
    private Text currentBet;
    private Text win;
    private Text lose;
    private Text push;

    private Picture player1Card;
    private Picture player2Card;
    private Picture player3Card;
    private Picture player4Card;
    private Picture player5Card;
    private Picture player6Card;
    private Picture player7Card;
    private Picture dealer1Card;
    private Picture dealer2Card;
    private Picture dealer3Card;
    private Picture dealer4Card;
    private Picture dealer5Card;
    private Picture dealer6Card;
    private Picture dealer7Card;
    private Picture hiddenCard;

    private int playerCardCounter;
    private int dealerCardCounter;

    // Getters
    public int getPlayerMoney() {
        return this.playerMoney;
    }
    public boolean getEndRound() {
        return this.endRound;
    }
    public boolean getValidBet() {
        return this.validBet;
    }
    public Deck getPlayerDeck() {
        return this.playerDeck;
    }
    public Deck getDealerDeck() {
        return this.dealerDeck;
    }
    public int getPlayerBet() {
        return this.playerBet;
    }

    // Method to create the initial Screen
    public void initScreen() {
        Picture startScreen = new Picture(10,10,"images/slackjack3.jpg");
        Picture startScreen2 = new Picture(10,10,"images/slackjack4.jpg");
        Picture options = new Picture(810,10,"images/playquit.jpg");
        startScreen.draw();
        options.draw();
    }

    // Method to create the table
    public void startGame() {
        Picture table = new Picture(10,10, "images/tablewithoutkeys.png");
        table.draw();
        this.playerMoney = 250;
    }

    // Method that creates a full deck of cards in playingDeck
    public void createPlayingDeck() {
        this.playingDeck.createFullDeck();
    }


    // Method to start a round:
    // ^- Shuffles the playingDeck
    // ^- Shows the Player Money
    public void startRound() {
        this.playingDeck.shuffle();

        totalMoney = new Text(150,475, "You have: \n" + getPlayerMoney() + "€");
        totalMoney.setColor(Color.WHITE);
        totalMoney.grow(100,10);
        totalMoney.draw();
    }


    // Method to validate the Player's Bet
    public void placeBet(int bet) {

        this.playerBet = bet;
        validBet = true;

        // Bet not valid if it's value is bigger than the Player's Money
        if( this.playerBet > this.playerMoney ) {
            System.out.println("You cannot bet more than what you have. Make a valid bet!");
            validBet = false;
            return;
        }

        currentBet = new Text(130, 540, "Your bet: " + getPlayerBet() + "€");
        currentBet.setColor(Color.WHITE);
        currentBet.grow(75,10);
        currentBet.draw();
        return;
    }

    // Method to start a round:
    // -> sets endRound value to false (it's the very beginning of the round)
    // -> takes 2 cards of the playingDeck to the playerDeck
    // -> takes 2 cards of the playingDeck to the dealerDeck
    public void initialPlay() {
        this.endRound = false;

        // Start dealing
        // Player gets 2 cards

        playerDeck.draw(playingDeck);
        // ^- picture.draw() the first player card
        // Posição inicial da primeira carta do Player é X=450, Y=435
        player1Card = new Picture(PCINITX,PCINITY,playerDeck.getCard(playerCardCounter).getImagePath());
        playerCardCounter++;
        player1Card.draw();

        playerDeck.draw(playingDeck);
        // ^- picture.draw() the second player card
        // Próxima carta do player é incrementar em X + 50px
        player2Card = new Picture(PCINITX + CINC, PCINITY, playerDeck.getCard(playerCardCounter).getImagePath());
        playerCardCounter++;
        player2Card.draw();

        // Dealer gets 2 cards
        dealerDeck.draw(playingDeck);
        // ^- picture.draw() the first dealer card
        // Posição inicial da primeira carta do dealer é X= 450, Y=20
        dealer1Card = new Picture(DCINITX, DCINITY, dealerDeck.getCard(dealerCardCounter).getImagePath());
        dealerCardCounter++;
        dealer1Card.draw();

        dealerDeck.draw(playingDeck);
        // ^- picture.draw() the second dealer card
        // Próxima carta do dealer é subtrair em X + 50px
        dealer2Card = new Picture(DCINITX + CINC, DCINITY, dealerDeck.getCard(dealerCardCounter).getImagePath());
        hiddenCard = new Picture(DCINITX + CINC, DCINITY, "images/cardback.png");
        dealerCardCounter++;
        dealer2Card.draw();
        hiddenCard.draw();
    }

    // Method for the player to ask the dealer for a new card:
    // -> player draws a new card and stores it on playerDeck
    // -> Checks if the player hand value is bigger than 21:
    //      -> If true: Bust. Player loses the round. End Round.
    //      -> If false, keep playing
    public void hit() throws InterruptedException {

        // Draw a new card
        playerDeck.draw(playingDeck);

        switch(playerCardCounter) {
            case 2:
                player3Card = new Picture(PCINITX + 100, PCINITY, playerDeck.getCard(playerCardCounter).getImagePath());
                playerCardCounter++;
                player3Card.draw();
                break;
            case 3:
                player4Card = new Picture(PCINITX + 150, PCINITY, playerDeck.getCard(playerCardCounter).getImagePath());
                playerCardCounter++;
                player4Card.draw();
                break;
            case 4:
                player5Card = new Picture(PCINITX + 200, PCINITY, playerDeck.getCard(playerCardCounter).getImagePath());
                playerCardCounter++;
                player5Card.draw();
                break;
            case 5:
                player6Card = new Picture(PCINITX + 250, PCINITY, playerDeck.getCard(playerCardCounter).getImagePath());
                playerCardCounter++;
                player6Card.draw();
                break;
            case 6:
                player7Card = new Picture(PCINITX + 300, PCINITY, playerDeck.getCard(playerCardCounter).getImagePath());
                playerCardCounter++;
                player7Card.draw();
                break;
        }

        System.out.println("You draw a " + playerDeck.getCard(playerDeck.deckSize() -1).toString());

        // Bust if > 21
        if( playerDeck.cardsValue() > 21 ) {
            System.out.println("Bust. Current value: " + playerDeck.cardsValue());
            lose = new Text(140,130, "You Lost!");
            lose.grow(75,10);
            lose.setColor(Color.RED);
            lose.draw();
            playerMoney -= playerBet;
            endRound = true;
            this.endRound();
        }
        return;
    }

    // Method for the player to stop playing and for the dealer to finish the game:
    // -> reveal dealer's card and hand value
    // -> if dealer hand value is bigger than the player's hand value: dealer wins. End Round.
    // -> dealer asks for a new card if it's hand value is below 17
    // -> checks if the dealer hand value is bigger than 21: Bust. Player wins the round. End Round.
    public void stand() throws InterruptedException {

        // Remove the hidden layer of the second card of the dealer
        hiddenCard.delete();

        // Reveal dealer cards
        System.out.println("Dealer Cards: " + dealerDeck.toString());

        // Display total value for dealer
        System.out.println("Dealer's hand value is: " + dealerDeck.cardsValue());

        // See if dealer has more points than player
        if ( (dealerDeck.cardsValue() > playerDeck.cardsValue()) && endRound == false ) {
            System.out.println("Dealer WIN!!!");
            lose = new Text(140,130, "You Lost!");
            lose.grow(75,10);
            lose.setColor(Color.RED);
            lose.draw();
            playerMoney -= playerBet;
            endRound = true;
        }

        // Dealer draws at 16, stand at 17
        while( (dealerDeck.cardsValue() < 19) && endRound == false ) {
            dealerDeck.draw(playingDeck);
            Thread.sleep(1000);

            switch (dealerCardCounter) {
                case 2:
                    dealer3Card = new Picture(DCINITX + 100, DCINITY, dealerDeck.getCard(dealerCardCounter).getImagePath());
                    dealerCardCounter++;
                    dealer3Card.draw();
                    break;
                case 3:
                    dealer4Card = new Picture(DCINITX + 150, DCINITY, dealerDeck.getCard(dealerCardCounter).getImagePath() );
                    dealerCardCounter++;
                    dealer4Card.draw();
                    break;
                case 4:
                    dealer5Card = new Picture(DCINITX + 200, DCINITY, dealerDeck.getCard(dealerCardCounter).getImagePath());
                    dealerCardCounter++;
                    dealer5Card.draw();
                    break;
                case 5:
                    dealer6Card = new Picture(DCINITX + 250, DCINITY, dealerDeck.getCard(dealerCardCounter).getImagePath());
                    dealerCardCounter++;
                    dealer6Card.draw();
                    break;
                case 6:
                    dealer7Card = new Picture(DCINITX + 300, DCINITY, dealerDeck.getCard(dealerCardCounter).getImagePath());
                    dealerCardCounter++;
                    dealer7Card.draw();
                    break;
            }

            System.out.println("Dealer draws a " + dealerDeck.getCard(dealerDeck.deckSize() -1).toString() );
            // Display total value for dealer
            System.out.println("Dealer's hand value is: " + dealerDeck.cardsValue());
        }

        // Determine if dealer is busted
        if( (dealerDeck.cardsValue() > 21) && endRound == false ) {
            System.out.println("Dealer busts! You WIN!!!");
            win = new Text(140,130,"You Won!");
            win.grow(75,10);
            win.setColor(Color.GREEN);
            win.draw();
            playerMoney += playerBet;
            endRound = true;
        }

        result();
    }

    // Method to get the round results:
    // -> if player and dealer hand values are the same, it's a tie: Push
    // -> if player hand value is bigger than the dealers hand value: Player wins the round.
    // -> if dealer hand value is bigger than the players hand value: Dealer wins the round.
    // End Round
    public void result() throws InterruptedException {

        // Determine if tie (push)
        if( (playerDeck.cardsValue() == dealerDeck.cardsValue()) && endRound == false ) {
            System.out.println("Push");
            push = new Text(140,130,"It's a Tie!");
            push.grow(75,10);
            push.setColor(Color.YELLOW);
            push.draw();
            endRound = true;
        }

        // Determine who is the winner
        if( (playerDeck.cardsValue() > dealerDeck.cardsValue()) && endRound == false ) {
            System.out.println("YOU WIN!!!");
            win = new Text(140,130,"You Won!");
            win.grow(75,10);
            win.setColor(Color.GREEN);
            win.draw();
            playerMoney += playerBet;
            endRound = true;
        } else if( endRound == false ) {
            System.out.println("YOU LOST!!!");
            lose = new Text(140,130, "You Lost!");
            lose.grow(75,10);
            lose.setColor(Color.RED);
            lose.draw();
            playerMoney -= playerBet;
            endRound = true;
        }

        this.endRound();
    }

    // Method to End Round
    // Sets validBet value to false (default)
    // Moves all cards from the player and dealer decks to the playingDeck
    public void endRound() throws InterruptedException {
        // Reset the validBet property
        this.validBet = false;

        // Move all cards from the player and dealer to the Playing Deck
        playerDeck.moveAllToDeck(playingDeck);
        dealerDeck.moveAllToDeck(playingDeck);

        // Reset both counters for a new Round
        playerCardCounter = 0;
        dealerCardCounter = 0;


        System.out.println("End of Round.");

        // Need to delete() every element at the End of the Round
        totalMoney.delete();
        currentBet.delete();

        if( hiddenCard != null ) {
            Thread.sleep(TIME_TO_CLOSE_GAME_CARDS);
            hiddenCard.delete();
        }
        if( player1Card != null) {
            Thread.sleep(TIME_TO_CLOSE_GAME_CARDS);
            player1Card.delete();
        }
        if( player2Card != null) {
            Thread.sleep(TIME_TO_CLOSE_GAME_CARDS);
            player2Card.delete();
        }
        if( player3Card != null) {
            Thread.sleep(TIME_TO_CLOSE_GAME_CARDS);
            player3Card.delete();
        }
        if( player4Card != null) {
            Thread.sleep(TIME_TO_CLOSE_GAME_CARDS);
            player4Card.delete();
        }
        if( player5Card != null) {
            Thread.sleep(TIME_TO_CLOSE_GAME_CARDS);
            player5Card.delete();
        }
        if( player6Card != null) {
            Thread.sleep(TIME_TO_CLOSE_GAME_CARDS);
            player6Card.delete();
        }
        if( player7Card != null) {
            Thread.sleep(TIME_TO_CLOSE_GAME_CARDS);
            player7Card.delete();
        }
        if( dealer7Card != null) {
            Thread.sleep(TIME_TO_CLOSE_GAME_CARDS);
            dealer7Card.delete();
        }
        if( dealer6Card != null) {
            Thread.sleep(TIME_TO_CLOSE_GAME_CARDS);
            dealer6Card.delete();
        }
        if( dealer5Card != null) {
            Thread.sleep(TIME_TO_CLOSE_GAME_CARDS);
            dealer5Card.delete();
        }
        if( dealer4Card != null) {
            Thread.sleep(TIME_TO_CLOSE_GAME_CARDS);
            dealer4Card.delete();
        }
        if( dealer3Card != null) {
            Thread.sleep(TIME_TO_CLOSE_GAME_CARDS);
            dealer3Card.delete();
        }
        if( dealer2Card != null) {
            Thread.sleep(TIME_TO_CLOSE_GAME_CARDS);
            dealer2Card.delete();
        }
        if( dealer1Card != null) {
            Thread.sleep(TIME_TO_CLOSE_GAME_CARDS);
            dealer1Card.delete();
        }
        if( lose != null ) {
            Thread.sleep(TIME_TO_CLOSE_GAME_CARDS);
            lose.delete();
        }
        if( push != null ) {
            Thread.sleep(TIME_TO_CLOSE_GAME_CARDS);
            push.delete();
        }
        if( win != null ) {
            Thread.sleep(TIME_TO_CLOSE_GAME_CARDS);
            win.delete();
        }

    }

}
