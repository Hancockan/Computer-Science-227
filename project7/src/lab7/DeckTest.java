package lab7;

import java.util.Arrays;

public class DeckTest {

	public static void main(String[] args){
		Deck deck = new Deck();
		Card[] hand = deck.select(5);
		System.out.println(Arrays.toString(hand));
	}
	
}
