public class Player {
	public Player() {
		
	}
	public int runPlayer(int totalValue, int ace) {
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
}