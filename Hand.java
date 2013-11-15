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
	
	public void drawPlayer(Graphics g, int totalValue) {
		int x = 50;
		for (int i = 0; i < amountOfCards; i++) {
			this.maxHand[i].draw(g, new Rectangle(x, 50, 200, 300));
			x+=250;
		}
		
		g.drawString("Total: " + totalValue, 40, 370);
	}
	public void drawDealer(Graphics g, int totalValue) {
		int xOffset = 50;
		for (int i = 0; i < amountOfCards; i++) {
			if (i == 0) {
				maxHand[i].drawBackOfCard(g, new Rectangle(xOffset, 500, 200, 300));
			} else {
				maxHand[i].draw(g, new Rectangle(xOffset, 500, 200, 300));
			}
			xOffset += 250;

		}
		g.drawString("Total: " + totalValue, 40, 820);
		

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