import java.util.Scanner;                                   //needed for (y/n) user input
/**
 * Brady Africk
 * version 1 on January 7, 2015
 * 
 * Welcome to the game class! 
 * 
 * Here you'll find:
 * 
 *-The play method
 *-The welcome print
 *-The dealing of the cards
 *-The implementation of askign the user a yes or no question
 * 
 */
public class Game
{
    //initializing the variables
    Deck deck = null;                  //the deck
    Hand playerHand = null;            //user's hand 
    Hand DealerHand = null;            //The "Dealer" hand

    /**
     *  This is the constructor. 
     */
    public Game()
    {
        //All the variables needed have already been initialized as this point
    }

    /**
     *  This method prints the welcome message to the player.
     *  It also calls them a "high roller"
     *  But we all know the term "end user" is only code for
     *  "person who will try to break your code"
     *  
     *  Exhibit A: https://i.imgur.com/X17puIB.gif
     */
    private void printWelcome()
    {
        System.out.println("   888888b.   888             d8888  .d8888b.  888    d8P 888888        d8888  .d8888b.  888    d8P     ");
        System.out.println("   888  \"88b  888            d88888 d88P  Y88b 888   d8P    \"88b       d88888 d88P  Y88b 888   d8P;     ");                      //////////////
        System.out.println("   888  .88P  888           d88P888 888    888 888  d8P      888      d88P888 888    888 888  d8P       ");                        //sweet logo//
        System.out.println("   8888888K.  888          d88P 888 888        888d88K       888     d88P 888 888        888d88K        ");                        //////////////
        System.out.println("   888  \"Y88b 888         d88P  888 888        8888888b      888    d88P  888 888        8888888b       ");
        System.out.println("   888    888 888        d88P   888 888    888 888  Y88b     888   d88P   888 888    888 888  Y88b      ");
        System.out.println("   888   d88P 888       d8888888888 Y88b  d88P 888   Y88b    88P  d8888888888 Y88b  d88P 888   Y88b     ");
        System.out.println("   8888888P\"  88888888 d88P     888  \"Y8888P\"  888    Y88b   888 d88P     888  \"Y8888P\"  888    Y88b    ");
        System.out.println("                                                           .d88P                                        ");
        System.out.println("                                                        .d88P                                           ");
        System.out.println();
        System.out.println("Welcome to the casino high roller!");
        System.out.println();
    }

   
    /**
     *  This method prints the user and the dealer's
     *  current cards in the console.
     *  
     *  technically you should only be able to see
     *  one of the dealer's cards but this is what
     *  I was able to do
     */
    private void printHands()
    {
        System.out.println("Here are the dealer's cards:");
        DealerHand.printHand();
        System.out.println("\n");
        System.out.println("Here are your cards:");
        playerHand.printHand();
    }

    /**
     *  This method deals the cards
     *  
     *  It does this by dealing to the user, then the dealer
     *  It repeats this twice
     */
    private void dealCards()
    {
        for (int n = 1; n < 3; n++)               // dealing one card to each "person" twice
        {
            Card card = deck.dealCard();
            playerHand.nextCard(card);                    //deals to player first

            card = deck.dealCard();
            DealerHand.nextCard(card);                    //deals to the "Dealer" after this
        }
    }

    /**
     *  This method is for when the user enters the (y/n).
     *  
     *  This uses Java's Scanner that was imported at the top
     *  to scan the user's imput
     */
    private char getChar()
    {
        String n = ""; 
        boolean waitingForAnswer = true;

        while(waitingForAnswer) //the while loop for waiting for a response from the user
        {
            Scanner console = new Scanner(System.in);

            n = console.nextLine();
            console.close();
            if (n.length() == 1)  //makes sure that the user's input is only one letter
            {
                waitingForAnswer = false;
            }
            else //tells the user there was an error, and scolds the user for being a bad user
            {
                System.out.println("It doesn't look like you entered your answer correctly.");
                System.out.println("This input is CaSe SeNsItIvE");
            }
        }
        return n.charAt(0);  // returns the imput starting from the beginning
    }

    /**
     *  Here is the Game Method in all it's glory
     *  
     *  This method was brought to you by late nights, lots of soda, and help from friends
     *  it features while loops within while loops and if's like you've never seen before
     *  
     *  In this method you'll find the cards being dealt and game being set up
     *  This method is also where the funtionality for the asking the user a y/n question is
     */
    public void play()
    {
        boolean playAgain = true;

        while (playAgain)
        {
            deck = new Deck();                  //We only use the freshest Decks here at the BlueJ casino
            playerHand = new Hand();            //user
            DealerHand = new Hand();            //The "Dealer"
            deck.shuffleDeck();

            printWelcome();
            dealCards();
            boolean hit = true;
            int userHand = playerHand.handValue();
            int dealerHand = DealerHand.handValue();

            while(hit)
            {
                printHands();                                                         //prints the hands

                char answer = 'x';                                                    //creates a value for the user's answer
                System.out.println();                                                 //prints a blank line for organization
                System.out.println("Here is the dealer's hand:  " + dealerHand);      //prints the dealer's value
                System.out.println("Here is your hand:    " + userHand);              //prints your hand's value
                System.out.println("Would You like to hit? (y/n)");                   //Asks the user if they would like to hit  
                answer = getChar();

                if (answer == 'y')  //if the user answers yes to hit, this if is entered
                {
                    Card card = deck.dealCard();        //another card is dealt
                    playerHand.nextCard(card);           //adds this card to the player's hand
                    userHand = playerHand.handValue();
                    if (userHand > 21)                  //checks if you bust (go over 21)
                    {
                        System.out.println("You bust!"); //tells the user they bust. what an idiot.
                        hit = false;                     //sets hit to false. You can't hit anymore becasue you just bust and you're bad at this game. 
                    }
                }
                else if (answer == 'n')     //if you decide you don't want to hit because you think the dealer is full of it
                {
                    if (dealerHand >= userHand)
                    {
                        //dealer wins
                        break;
                    }
                    else
                    {
                        while(dealerHand <= 1) //the dealer hits if his hand is lower than 17
                        {
                            Card card = deck.dealCard();        //dealer will hit
                            DealerHand.nextCard(card);
                            dealerHand = DealerHand.handValue();
                            if (dealerHand > 21)                //checks if dealer busts
                            {
                                System.out.println("The dealer busts!"); //this guy is an idiot. he should be fired from this casino
                                hit = false;        //stops loop
                            }
                        }
                    }
                    hit = false;    //stops the while loop
                }
                else
                {
                    System.out.println("It doesn't look like you entered your answer correctly.");
                    System.out.println("This input is CaSe SeNsItIvE");
                }
            }

            printHands();
            System.out.println("\n");
            System.out.println("      Dealer hand:  " + dealerHand + "  ");       //prints the total value of the dealer's hand
            System.out.println("      Your hand:    " + userHand + "  ");         //prints the total value of the player's hand
            System.out.println("\n");

            //prints conditions
            if (userHand > 21)
            {
                System.out.println("You bust! You lose.");
            }
            else if (dealerHand > 21)
            {
                System.out.println("You win!");    //You won
            }
            else if (userHand == dealerHand)
            {
                System.out.println("You tied.");   //You tied
            } 
            else if (userHand < dealerHand)
            {
                System.out.println("You lose. The dealer had a better hand than you.");
            }
            else if (userHand > dealerHand)
            {
                System.out.println("You win! You had a better hand than the dealer.");
            }

            char answer = 'x';
            System.out.println();
            System.out.println("Play again? (y/n)");            //asks if you want to play again
            answer = getChar();
            if (answer == 'n')
            {
                playAgain = false;      //stops loop
            }
            //I'm losing my mind
        }
    }
}
