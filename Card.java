/**
 * 
 * Brady Africk
 * version 1 on January 4, 2015
 * 
 * Welcome to the Card class! 
 * 
 * Here you'll find:
 * 
 *-saying the suit's card
 *-defines the card's rank in the deck
 *-defines the cards value
 *-converts the cards rank to its value
 * 
 */
public class Card
{
    static final int CLUBS = 1;                 //
    static final int SPADES = 2;                //
    static final int DIAMONDS = 3;              //these assign a number to each suit
    static final int HEARTS = 4;                //

    static final int JACK_VALUE = 10;           //
    static final int QUEEN_VALUE = 10;          //these give each of the face cards a value
    static final int KING_VALUE = 10;           //
    static final int ACE_VALUE = 11;            //
    
    static final int JACK_RANK = 11;            //  
    static final int QUEEN_RANK = 12;           //these are the rank of the cards
    static final int KING_RANK = 13;            //
    static final int ACE_RANK = 14;             //
    
    int suit; //interger for for the suit fo these cards
    int rank; //interger for for the rank fo these cards

    /**
     *  This is the constructor for the creation of a card in a deck.
     *  
     *  this makes sure that the suit is a valid one
     *  makes sure the rank of the card is also acceptable
     */
    public Card(int theSuit, int theRank)
    {
        suit = theSuit; //sets suit equal theSuit
        rank = theRank; //sets ranks equal theRank
        if ((suit < CLUBS) || (suit > HEARTS)) //if the suit is less than clubs or greater than hearts
        {
            System.out.println("not a valid suit."); //says it's not a valid suit and returns nothing
            return;
        }
        if ((rank < 2) || (rank > ACE_RANK)) //if rank is less than 2 or greater than the rank of Ace
        {
            System.out.println("not a valid suit."); //says it's not a valid suit and returns nothing
            return;
        }
    }

    /**
     *  This method sets the interger "theSuit" 
     *  to the variable of "suit".
     */
    public void chooseSuit(int theSuit)
    {
        suit = theSuit; //sets suit equal theSuit
        if ((suit < CLUBS) || (suit > HEARTS))  //if the suit is less than clubs or greater than hearts
        {
            System.out.println("not a valid suit."); //says it's not a valid suit and returns nothing
            return;
        }
    }

    /**
     *  This method returns the suit of a card.
     */
    public int getSuit()
    {
        return suit; //returns the suit
    }
    
    /**
     *  This method sets "theRank" to the universally used variable
     *  of "rank".
     */
    public void chooseRank(int theRank)
    {
        rank = theRank; //sets rank equal to theRank
        if ((rank < 2) || (rank > ACE_RANK)) //if rank is less than 2 or greater than the rank of Ace
        {
            System.out.println("not a valid suit."); //says it's not a valid suit and returns nothing
            return;
        }
    }

    /**
     *  This method returns the rank.
     */
    public int getRank()
    {
        return rank; //returns the rank
    }
    
    /**
     *  This method converts a cards rank to its numerical addition value.
     */
    public int getValue()
    {
        if ((rank >= 2) && (rank <= 10))
        {                                      //////    converts the rank of these cards to a value 
            return rank;
        }
        else if (rank == JACK_RANK)
        {                                      //////    converts the rank of these cards to a value 
            return JACK_VALUE;
        }                                     
        else if (rank == QUEEN_RANK)           
        {                                      //////    converts the rank of these cards to a value   
            return QUEEN_VALUE;                
        }                                      
        else if (rank == KING_RANK)
        {                                      //////    converts the rank of these cards to a value 
            return KING_VALUE;
        }
        else 
        {                                      //////    converts the rank of these cards to a value 
            return ACE_VALUE;
        }
    }

    /**
     *  This method converts the rank to a string.  
     *      
     */
    public String rankToString()
    {
        if ((rank >= 2) && (rank <=10))
        {
            return Integer.toString(rank); // returns rank
        }
        else if (rank == JACK_RANK)  // Jack in place of 11
        {
            return "Jack";
        }
        else if (rank == QUEEN_RANK)  // Queen in place of 12
        {
            return "Queen";
        }
        else if (rank == KING_RANK) // King in place of 13
        {
            return "King";
        }
        else if (rank == ACE_RANK) // Ace in place of 14
        {
            return "Ace";
        }
        else
        {
            return "Bad rank";                  // if invalid rank
        }
    }
    
    /**
     *  This method converts the suit to a string.
     */
    public String suitToString()
    {
        if (suit == CLUBS)
        {
            return "Clubs";       //returns lowercase suit
        }
        else if (suit == SPADES)
        {
            return "Spades";      //returns lowercase suit
        }
        else if (suit == DIAMONDS)
        {
            return "Diamonds";    //returns lowercase suit
        }
        else if (suit == HEARTS)
        {
            return "Hearts";      //returns lowercase suit
        }
        else
        {
            return "not a valid suit.";     //returns lowercase suit
        }
    }
    
    /**
     *  This method prints the "rank" of "suit"
     */
    public String toString()
    {
        return rankToString() + " of " + suitToString(); // This allows [blank] of [blanks] to be returned
    }
}

