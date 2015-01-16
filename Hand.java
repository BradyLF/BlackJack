/**
 * Brady Africk
 * version 1 on January 5, 2015
 * 
 * The Hand class controls all aspects of card handling 
 * such as handling multiple cards in the player's hand
 * 
 * 
 *-adding a card to the player's hand
 *-extracting a card from the deck
 *-adding the value of the hand
 *-printing the hand
 *
 * 
 */
 public class Hand
{
    Card[] cards = new Card[52];                    //create hand of cards
    int cardIndex = 0;                              //know what index in array to add card too
    
    /**
     *  This method adds a card to the player's hand.
     *  
     *  It accomplishes this by taking the next card in the array and adding it to the hand
     */
    public void nextCard(Card card)
    {
        if (cardIndex < 51) //if the cardIndex is less than 51
        {
            cards[cardIndex] = card;
            cardIndex++;   //cardIndex is now equal to cardIndex+ 1
        }
        else
        {
            System.out.println("You have too many cards in your hand right now.");        //if there are too many cards
        }
    }
    
    /**
     *  This method print the cards in a hand out.
     */
    public void printHand() //prints the hand
    {
        for (int n = 0; n < cardIndex; n++)  //for loop for goign through the hand and printing it
        {
             System.out.println(cards[n].toString()); //prints the nth card in the card array
        }
    }
    
    /**
     *  This method calculates the sum of the hand.
     *  
     *  It does this by going through each card in the array of the hand
     *  and adding it to the int total
     */
    public int handValue()
    {
        int total = 0;   //sets total to 0
        for (int n = 0; n < cardIndex; n++)  //for loop for making the total the toal of the cards in the hand
        {
            total = total + cards[n].getValue();
        }
        return total; //returns the total
    }
    
}
