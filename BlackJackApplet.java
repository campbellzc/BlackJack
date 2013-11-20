import java.awt.*;
import java.applet.*;
import java.awt.Graphics;
import java.awt.Rectangle;

public class BlackJackApplet extends Applet {

	private Deck table;
	private Hand player;
	private int totalValue;
	private int ace;
	private Hand dealer;
	public void init() {
		this.totalValue = 0;
		table = new Deck();
		player = new Hand(table.deal());
		dealer = new Hand(table.deal());
		this.ace = 0;
		if (table.deal().getValue() == 1) {
			this.totalValue = table.deal().getValue2();
			this.ace = 1;
		} else	{
			this.totalValue = table.deal().getValue();
		}
		
		//for (int i = 1; i < totalValue; i++) {
		//runHand(totalValue, ace);
		
			
		
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
		player.drawPlayer(g, runHand(totalValue, ace));
		dealer.drawDealer(g, runHand(totalValue, ace));
	}
	public int runHand(int totalValue, int ace) {
		//int x = 1;
		//while (x == 1) {
			while (this.totalValue < 21) {
				Card theCard = table.deal();
				player.addACard(theCard);
				if (theCard.getValue() == 1) {
					if ((this.totalValue + 11) <= 21) {
						this.totalValue += theCard.getValue2();
						ace = 1;
					} else {
						this.totalValue += theCard.getValue();
						ace = 0;
					}

				} else {
					
					this.totalValue += theCard.getValue();
				}
				if (this.totalValue > 21) {
					if (ace == 1) {
						
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
		

		return this.totalValue;
	}

}