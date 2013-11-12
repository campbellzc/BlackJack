import java.awt.*;
import java.applet.*;
import java.awt.Graphics;
import java.awt.Rectangle;

public class BlackJackApplet extends Applet {

	private Deck table;
	private Hand player;
	int totalValue = 0;
	public void init() {
		table = new Deck();
		player = new Hand(table.cards[0]);
		//for (int i = 1; i < totalValue; i++) {
		while (totalValue < 21) {
			Card theCard = table.deal();
			player.addACard(table.deal());
			totalValue += theCard.getValue();
			System.out.println(totalValue);
		}
			
			//totalValue += table.cards[i].getValue();
		//}
			

		
	}

	public void paint(Graphics g) {
		//table.draw(g);
		player.draw(g);
	}

}