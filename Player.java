import java.awt.Graphics;
import java.awt.Rectangle;
public class Player {
	Hand playersHand;
	
	public Player(Card firstCard) {
		playersHand = new Hand(firstCard);
		
		//drawPlayer(g, runPlayer(totalValue, ace));
	}
	
	// public void firstValue() {
	// 	if (table.cards[0].getValue() == 1) {
	// 		this.totalValue = table.cards[0].getValue2();
	// 		this.ace = 1;
	// 	} else	{
	// 		this.totalValue = table.cards[0].getValue();
	// 	}
	// }
	

	public void runPlayer(Graphics g, int totalValue) {
		playersHand.drawPlayer(g);
	}
	
}