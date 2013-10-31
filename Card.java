public class Card {
	private String card;
	private int value;
	private String suit;
	//private int number;
	int[] values = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
 	public Card(String card, int value, String suit) {
		setCard(card);
		setSuit(suit);
		setValue(value);
		System.out.println("" + this.card + " of " + this.suit);

	}
	public String getCard() {
		return this.card;
	}
	public void setCard(String card) {
		this.card = card;
	}
	public int getValue() {
		return this.value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public String getSuit() {
		return this.suit;
	}
	public void setSuit(String suit) {
		this.suit = suit;
	}

}