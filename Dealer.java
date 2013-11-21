import java.awt.Graphics;
public class Dealer {
	Hand dealersHand;
	public Dealer(Card firstCard) {
		dealersHand = new Hand(firstCard);
		
	}
	public int runDealer(int totalValue, int ace, Card theCard) {
			while (totalValue < 17) {
				//Card theCard = table.deal();
				dealersHand.addACard(theCard);
				if (theCard.getValue() == 1) {
					if ((totalValue + 11) <= 21) {
						totalValue += theCard.getValue2();
						ace = 1;
					} else {
						totalValue += theCard.getValue();
						ace = 0;
					}

				} else {
					
					totalValue += theCard.getValue();
				}
				if (totalValue > 21) {
					if (ace == 1) {
						
						totalValue = totalValue - 10;
						
					} else {
						System.out.println("ace is false. should do nothing");
					}
					ace = 0;
				
				}
			
				System.out.println(totalValue);
			
			}

		return totalValue;
	}
	public void draw(Graphics g, int totalValue) {
		dealersHand.drawDealerFirst(g);
	}
}