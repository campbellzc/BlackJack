import java.awt.Graphics;
public class Dealer {
	Hand dealersHand;
	public Dealer(Card firstCard) {
		dealersHand = new Hand(firstCard);
		
	}
	
	public void draw(Graphics g, int totalValue) {
		dealersHand.drawDealerFirst(g);
	}
}