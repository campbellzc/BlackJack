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
		int ace = 0;
		if (table.deal().getValue() == 1) {
			totalValue = table.cards[0].getValue2();
			ace = 1;
		} else	{
			totalValue = table.cards[0].getValue();
		}
		
		//for (int i = 1; i < totalValue; i++) {
		runHand(totalValue, ace);
		
			
		
		// if (ace = true) {
		// 	totalValue -= 10;
		// 	ace = false;
		// 	runHand(totalValue, ace);
		// }
			
			//totalValue += table.cards[i].getValue();
		//}
			

		
	}


	public void paint(Graphics g) {
		//table.draw(g);
		player.draw(g);
	}
	public int runHand(int totalValue, int ace) {
		//int x = 1;
		//while (x == 1) {
			while (totalValue < 21) {
				Card theCard = table.deal();
				player.addACard(theCard);
				if (theCard.getValue() == 1) {
					if ((totalValue + 11) <= 21) {
						totalValue += theCard.getValue2();
						ace = 1;
					} else {
						totalValue += theCard.getValue();
						ace = 0;
					}

				} else {
					System.out.println("normal card value");
					totalValue += theCard.getValue();
				}
				if (totalValue > 21) {
					if (ace == 1) {
						System.out.println("ace is true");
						totalValue = totalValue - 10;
						
					} else {
						System.out.println("ace is false. should do nothing");
					}
					ace = 0;
				
				}
			// if (ace = true ) {
				
			// 		totalValue -= 10;
			// 		ace = false;
				
				
			// }
				System.out.println(totalValue);
				

			
			}
			

		//}
		

		return totalValue;
	}

}