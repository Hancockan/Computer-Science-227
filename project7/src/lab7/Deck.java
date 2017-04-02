package lab7;
import java.util.Random;

import lab7.Card.Suit;

/**
 * Class representing a standard 52-card deck of playing
 * cards from which cards can be selected at random.
 */
public class Deck
{
  /**
   * The cards comprising this deck.
   */
  private Card[] cards;
  
  /**
   * The random number generator to use for selecting cards.
   */
 
  private Random rand;
  
  /**
   * Constructs a new deck with a default random number generator.
   */
  public Deck()
  {
    rand = new Random();
    init();
  }

  /**
   * Constructs a new deck with the given random number generator.
   */
  public Deck(Random givenGenerator)
  {
    rand = givenGenerator;
	init();
  }
  
  /**
   * Returns a new array containing k elements selected
   * at random from this deck.
   */
  public Card[] select(int k)
  {
	  //new card hand
	  Card[] hand = new Card[k];
	  //for loop to go through and construct a hand of the needed size
	  for(int i = 0;i < k;i++){
		  int randomCard = rand.nextInt(52-i);
		  swap(cards, (51-i),  randomCard);
		  hand[i] = cards[51-i];
	  }
	  return hand;
    
  }
  
  /**
   * Initializes a new deck of 52 cards.
   */
  private void init()
  {
    cards = new Card[52];
    int index = 0;
    for (int rank = 1; rank <= 13; ++rank)
    {
      cards[index] = new Card(rank, Suit.CLUBS);
      index += 1;
      cards[index] = new Card(rank, Suit.DIAMONDS);
      index += 1;
      cards[index] = new Card(rank, Suit.HEARTS);
      index += 1;
      cards[index] = new Card(rank, Suit.SPADES);
      index += 1;
    }

  }
  public static void swap(Card[] cards2, int i, int j)
  {
    Card temp = cards2[i];
    cards2[i] = cards2[j];
    cards2[j] = temp;  
  }
}