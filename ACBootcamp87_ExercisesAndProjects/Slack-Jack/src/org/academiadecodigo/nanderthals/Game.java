package org.academiadecodigo.nanderthals;

import java.util.Scanner;

/**
 * <Academia de Código_> #87 @FLOWribellas
 *
 * Bootcamp Week #5 - GAME WEEK
 * Develop a game in 9 days and 10 nights
 *
 * By: Hugo Capela, João Pereira, José Nuno Sousa, Pedro Almeida, Pedro Leite
 */
public class Game {

    public static void main(String[] args) throws InterruptedException {

        GameLogic gl = new GameLogic(); // Initialize a GameLogic
        Music music = new Music(); // Initialize the Music
        Scanner userInput = new Scanner(System.in); // Initialize Scanner for user input

        while(true) {
            music.stop(); // If music is playing, stop
            gl.initScreen(); // Load Initial Screen

            int st = 0;

            // Do-While to validate user input
            do {
                System.out.println("Press 1 to Start or 2 to Exit");

                while( !userInput.hasNextInt() ) {
                    System.out.println("Input not valid. Try again!");
                    System.out.println("Press 1 to Start or 2 to Exit");
                    userInput.next();
                }

                st = userInput.nextInt();

                if (st == 1) {
                    gl.startGame();
                    music.play();
                    break;
                }
                if (st == 2) {
                    System.exit(0);
                    break;
                }

                if( st != 1 || st != 2 ) {
                    System.out.println("Wrong number. Please choose 1 or 2.");
                }
            } while( st != 1 || st != 2);
            // While user input is not 1 or 2, keep asking

            // Create the Playing Deck
            gl.createPlayingDeck();

            // Play while player has money
            while (gl.getPlayerMoney() > 0) {

                // Start the Round by shuffling the playingDeck and print the playerMoney value
                gl.startRound();

                // While player bet is not valid, keep asking for a bet
                while (!gl.getValidBet()) {
                    // Set the player bet with user input and use the method for placing bets
                    int userBet;

                    do {
                        System.out.println("You have " + gl.getPlayerMoney() + "€. How much would you like to bet?");

                        while( !userInput.hasNextInt() ) {
                            System.out.println("Input not valid.");
                            System.out.println("Make a valid bet!");
                            userInput.next();
                        }

                        userBet = userInput.nextInt();
                    } while( userBet <= 0 );


                    gl.placeBet(userBet);
                }

                // Draws initial cards for player and dealer
                gl.initialPlay();

                // Repeat asking the player for a Hit or Stand while the Round does not come to an end
                while (!gl.getEndRound()) {

                    System.out.println("Your hand: ");
                    System.out.println(gl.getPlayerDeck().toString());
                    System.out.println("Your hand value is: " + gl.getPlayerDeck().cardsValue());

                    System.out.println("Dealer hand: " + gl.getDealerDeck().getCard(0).toString() + " and [Hidden]");
                    System.out.println("Press 1 to Hit or press 2 to Stand");

                    // Get user input for a Hit or a Stand
                    int response = userInput.nextInt();

                    // if player chooses to Hit
                    if (response == 1) {
                        // Call the hit method
                        gl.hit();
                    }
                    // if player chooses to Stand
                    if (response == 2) {
                        // Call the stand method
                        gl.stand();
                    }
                }
                // Separator between Rounds
                System.out.println("--------------------");
            }

        }
    }

}
