import java.util.Random;                        //random library for shuffling the deck
/**
 * 
 * Brady Africk
 * version 1 on January 6, 2015
 * 
 * The Deck class controls everything about the cards in a deck
 * 
 * It does the following:
 *-creates the 52 card
 *-making sure there are cards in the deck and keeping track of the number of remaingin cards
 *-dealing and shuffling the cards
 *
 * 
 */
public class Deck
{
    Card[] cards = new Card[52];                //create the array with 52 slots fdor each card
    int removedCards = 0;                          //an int that counts when a card is removed
    
    /**
     *  This method returns the array of the deck.
     */
    public Card[] getDeck()
    {
        return cards;  //returns the set of cards
    }
    
    /**
     *  This creates all the cards in the deck
     *  It does this by looping through each suit an each rank
     */
    public Deck ()
    {
        int n = 0;
        for (int suit = Card.CLUBS; suit <= Card.HEARTS; suit++) //for loop that goes through the suits and ranks  
        {
            for (int rank = 2; rank <= Card.ACE_RANK; rank++)
            {
                cards[n] = new Card(suit, rank);       //the card in the nth position is given a suit and a rank
                n++;                                   //n is now equal to n + 1
            }
        }
    }
    
    /**
     *  This method makes sure there are cards left in the deck
     */
    public boolean empty()
    {
        return (removedCards > 53); //52 cards in a deck
    }
    
    /**
     *  This method deals a card.
     *  
     *  This is done by making the card a local variable an then 
     *  clearing the cards spot in the array of the deck
     */
    public Card dealCard()
    {
        Card card = cards[removedCards];
        cards[removedCards] = null;            //makes it empty
        removedCards++;                        //adds to the "position" of the dealer
        return card;                           //returns the card
    }
    
    /**
     *  This method checks how many cards are left in the deck
     *  
     *  This is done by taking the total number fo cards and 
     *  substracting the cards taken
     */
    public int cardsLeft()
    {
        return 52 - removedCards;              //calculates the remaining cards
    }
    
    /**
     *  This shuffles the deck of cards.
     *  
     *  This is done by taking two random cards in the deck and 
     *  switching them 1000000 times to ensure the deck is mixed thuroughly
     *  
     */
    public void shuffleDeck()
    {
        int a = removedCards;         
        int b = 51;
        Random random = new Random();
        for (int i = 0; i <= 1000000; i++)
        {
            int x = random.nextInt(b - a + 1) + a;  //int x 
            int y = random.nextInt(b - a + 1) + a;  //int y
            
            Card c1 = cards[x];
            Card c2 = cards[y];
            cards[x] = c2;
            cards[y] = c1;
        }
    }
}
