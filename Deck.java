public class Deck {
	private String suit;

	
	public Deck() {
		suit("Diamonds");
		suit("Clubs");
		suit("Spades");
		suit("Hearts");
	}
	public void suit(String suit) {
		Card ace = new Card("Ace", 1, suit);
		Card two = new Card("Two",2, suit);
		Card three = new Card("Three",3, suit);
		Card four = new Card("Four",4, suit);
		Card five = new Card("Five", 5, suit);
		Card six = new Card("Six", 6, suit);
		Card seven = new Card("Seven",7, suit);
		Card eight = new Card("Eight",8, suit);
		Card nine = new Card("Nine",9, suit);
		Card ten = new Card("Ten", 10, suit);
		Card jack = new Card("Jack", 10, suit);
		Card queen = new Card("Queen", 10, suit);
		Card king = new Card("King", 10, suit);

	}
}