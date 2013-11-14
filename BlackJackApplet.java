import java.awt.*;
import java.applet.*;
import java.awt.Graphics;
import java.awt.Rectangle;

public class BlackJackApplet extends Applet {

	private Deck table;
	private Hand player;
	
	public void init() {
		int totalValue = 0;
		table = new Deck();
		player = new Hand(table.cards[0]);
		boolean ace = false;
		if (table.deal().getValue() == 1) {
			totalValue = table.cards[0].getValue2();
			ace = true;
		} else	{
			totalValue = table.cards[0].getValue();
		}
		
		//for (int i = 1; i < totalValue; i++) {
		while (totalValue < 21) {
			Card theCard = table.deal();
			player.addACard(theCard);
			if (theCard.getValue() == 1) {
				if ((totalValue + 11) <= 21) {
					totalValue += theCard.getValue2();
					ace = true;
				} else {
					totalValue += theCard.getValue();
				}

			} else {
				totalValue += theCard.getValue();
			}
			if (ace = true ) {
				
					totalValue -= 10;
					ace = false;
				
				
			}
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