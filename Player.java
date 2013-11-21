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
		playersHand.drawPlayer(g, totalValue);
	}
	public int getTotalValueP(int totalValue2, int ace, Card theCard) {
			
				//Card theCard = newCard;
				
				if (theCard.getValue() == 1) {
					if ((totalValue2 + 11) <= 21) {
						System.out.println("ace is true (=11)");
						totalValue2 += theCard.getValue2();
						ace = 1;
					} else {
						System.out.println("ace is true (=1)");
						totalValue2 += theCard.getValue();
						ace = 0;
					}

				} else {
					System.out.println("should be normal value");
					totalValue2 += theCard.getValue();
					System.out.println(theCard.getValue());
				}
				if (totalValue2 > 21) {
					if (ace == 1) {
						
						totalValue2 = totalValue2 - 10;
						
					} else {
						System.out.println("ace is false. should do nothing");
					}
					ace = 0;
				
				}
			
				System.out.println(totalValue2);
			
			

		return totalValue2;
	}
}