import java.util.Random;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Deck {
	private String suit;
	int cardsDealt = 0;
	Random random = new Random();
	Card[] cards = new Card[52];
	public Deck() {
		
		for (int x = 1; x<=13; x++) {
			int i = x;
			if (x > 10) {
				i = 10;
			}
			if (x == 1) {
				Card newCard = new Card(x, 1, 11, "Hearts");
				cards[x-1] = newCard;
			} else {
				Card newCard = new Card(x, i, "Hearts");
				cards[x-1] = newCard;
			}
			
			
			
			

		}
		for (int x = 1; x<=13; x++) {
			int i = x;
			if (x > 10) {
				i = 10;
			}
			if (x == 1) {
				Card newCard = new Card(x, 1, 11, "Spades");
				cards[x+12] = newCard;
			} else {
				Card newCard = new Card(x, i, "Spades");
				cards[x+12] = newCard;
			}
			
			
			
			

		}
		for (int x = 1; x<=13; x++) {
			int i = x;
			if (x > 10) {
				i = 10;
			}
			if (x == 1) {
				Card newCard = new Card(x, 1, 11, "Clubs");
				cards[x+25] = newCard;
			} else {
				Card newCard = new Card(x, i, "Clubs");
				cards[x+25] = newCard;
			}
			
			
			

		}
		for (int x = 1; x<=13; x++) {
			int i = x;
			if (x > 10) {
				i = 10;

			}
			if (x == 1) {
				Card newCard = new Card(x, 1, 11, "Diamonds");
				cards[x+38] = newCard;
			} else {
				Card newCard = new Card(x, i, "Diamonds");
				cards[x+38] = newCard;
			}
			
			
			

		}
		shuffle();
		// suit("Diamonds");
		// suit("Clubs");
		// suit("Spades");
		// suit("Hearts");
		
	}
	public void shuffle() {
		for (int i = cards.length-1; i>0; i--) {
			Card a = cards[i];
			int temp = random.nextInt(i);
			cards[i] = cards[temp];
			cards[temp] = a;
		}
		print();
	}
	public void print() {
		for (int i = 0; i<cards.length; i++) {
			System.out.println(cards[i].getValue() + " of " + cards[i].getSuit() + " value = " + cards[i].getValue());
		}
	}
	public void draw(Graphics g) {
		int xOffset = 50;
		for (int i = 0; i<cards.length; i++) {
			cards[i].draw(g, new Rectangle(xOffset, 50, 150, 300));
			xOffset += 25;
		}
		shuffle();
		xOffset = 50;
		for (int i = 0; i<cards.length; i++) {
			cards[i].draw(g, new Rectangle(xOffset, 150, 150, 300));
			xOffset += 25;
		}
	}
	public Card deal() {
		cardsDealt++;
		return cards[cardsDealt-1];
	}
	public Card deal2() {
		cardsDealt++;
		return cards[cardsDealt-2];
	}
	//public void suit(String suit) {
		// Card ace = new Card("Ace", 1, suit);
		// Card two = new Card("Two",2, suit);
		// Card three = new Card("Three",3, suit);
		// Card four = new Card("Four",4, suit);
		// Card five = new Card("Five", 5, suit);
		// Card six = new Card("Six", 6, suit);
		// Card seven = new Card("Seven",7, suit);
		// Card eight = new Card("Eight",8, suit);
		// Card nine = new Card("Nine",9, suit);
		// Card ten = new Card("Ten", 10, suit);
		// Card jack = new Card("Jack", 10, suit);
		// Card queen = new Card("Queen", 10, suit);
		// Card king = new Card("King", 10, suit);

	//}
}