import java.util.Random;

public class Deck {
	private String suit;
	Random random = new Random();
	Card[] cards = new Card[52];
	public Deck() {
		
		for (int x = 1; x<=13; x++) {
			int i = x;
			if (x > 10) {
				i = 10;
			}
			Card newCard = new Card(i, "Hearts");
			
			
			cards[x-1] = newCard;

		}
		for (int x = 1; x<=13; x++) {
			int i = x;
			if (x > 10) {
				i = 10;
			}
			Card newCard = new Card(i, "Spades");
			
			
			cards[x+12] = newCard;

		}
		for (int x = 1; x<=13; x++) {
			int i = x;
			if (x > 10) {
				i = 10;
			}
			Card newCard = new Card(i, "Clubs");
			
			
			cards[x+25] = newCard;

		}
		for (int x = 1; x<=13; x++) {
			int i = x;
			if (x > 10) {
				i = 10;

			}
			Card newCard = new Card(i, "Diamonds");
			
			
			cards[x+38] = newCard;

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
			System.out.println(cards[i].getValue() + " of " + cards[i].getSuit());
		}
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