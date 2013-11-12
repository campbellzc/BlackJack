import java.awt.Graphics;
import java.awt.Rectangle;


public class Hand {
	//private Deck cards;
	private Card[] maxHand;
	private int amountOfCards;
	public Hand(Card firstCard) {
		this.maxHand = new Card[11];
		this.maxHand[0] = firstCard;
		this.amountOfCards = 1;
	}
	
	public void draw(Graphics g) {
		int y = 50;
		for (int i = 0; i < amountOfCards; i++) {
			this.maxHand[i].draw(g, new Rectangle(y, 50, 200, 300));
			y+=250;
		}

	}
	public void addACard(Card x) {
		if (amountOfCards < 11) {
			maxHand[amountOfCards] = x;
			amountOfCards++;
		}
	}
	public Card[] getCards() {
		return this.maxHand;
	}
	public int getNumberOfCards() {
		return this.amountOfCards;
	}
}