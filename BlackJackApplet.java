import java.awt.*;
import java.applet.*;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.*;
import java.awt.event.*;

public class BlackJackApplet extends Applet implements ActionListener{

	private Deck table;
	private Player player;
	private int totalValue;
	private int ace;
	//private Dealer dealer;
	private JButton hit, stay, doubleDown;
	private String title;
	private Card currCard;
	public void init() {
		//Card card = table.deal();
		title = "Hit";
		hit = new JButton(title);
		hit.setActionCommand(title);
		hit.addActionListener(this);
		this.add(hit);

		title = "Stay";
		stay = new JButton(title);
		stay.setActionCommand(title);
		stay.addActionListener(this);
		this.add(stay);
		this.totalValue = 0;
		table = new Deck();
		if (table.cards[0].getValue() == 1) {
			totalValue = table.cards[0].getValue2();
			ace = 1;
		} else	{
			totalValue = table.cards[0].getValue();
			ace = 0;
		}
		//dealer = new Dealer(table.deal());
		
		//dealer.addACard(table.deal());
		
		
		
		//for (int i = 1; i < totalValue; i++) {
		//runHand(totalValue, ace);
		
		player = new Player(table.deal());
		System.out.println("firstCard value" + player.playersHand.maxHand[0].getValue());
		player.playersHand.addACard(table.deal());
		if (table.cards[1].getValue() == 1) {
			totalValue += table.cards[1].getValue2();
			ace = 1;
		} else	{
			totalValue += table.cards[1].getValue();
			ace = 0;
		}
		
		System.out.println("secondCard value" + player.playersHand.maxHand[1].getValue());
		
		
		//getTotalValueP(totalValue, ace);
		//totalValue += player.playersHand.maxHand[1].getValue();
		System.out.println(totalValue);
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
		
		player.playersHand.drawPlayer(g, totalValue);
		
		//player.drawPlayer(g);
		//dealer.drawDealer(g, runHand(totalValue, ace));
	}
	public void actionPerformed(ActionEvent ae) {
		if ("Hit".equals(ae.getActionCommand())) {
			if (totalValue < 21) {
				player.playersHand.addACard(table.deal());
				totalValue = getTotalValueP(totalValue, ace);
				repaint();
			}
			
			
		} else if ("Stay".equals(ae.getActionCommand())) {
			// runDealer();
			// repaint();
		}
	}
	public int getTotalValueP(int totalValue, int ace) {
				
					Card theCard = table.deal2();
				
				if (theCard.getValue() == 1) {
					if ((totalValue + 11) <= 21) {
						System.out.println("ace is true (=11)");
						totalValue += theCard.getValue2();
						ace = 1;
					} else {
						System.out.println("ace is true (=1)");
						totalValue += theCard.getValue();
						ace = 0;
					}

				} else {
					System.out.println("should be normal value");
					totalValue += theCard.getValue();
					System.out.println(theCard.getValue());
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
				theCard = table.deal();
			
			

		return totalValue;
	}
	// public void buttons() {
	// 	super();

		
	// }
	// public int runHand(int totalValue, int ace) {
	// 	//int x = 1;
	// 	//while (x == 1) {
	// 		while (this.totalValue < 21) {
	// 			Card theCard = table.deal();
	// 			player.addACard(theCard);
	// 			if (theCard.getValue() == 1) {
	// 				if ((this.totalValue + 11) <= 21) {
	// 					this.totalValue += theCard.getValue2();
	// 					ace = 1;
	// 				} else {
	// 					this.totalValue += theCard.getValue();
	// 					ace = 0;
	// 				}

	// 			} else {
					
	// 				this.totalValue += theCard.getValue();
	// 			}
	// 			if (this.totalValue > 21) {
	// 				if (ace == 1) {
						
	// 					totalValue = totalValue - 10;
						
	// 				} else {
	// 					System.out.println("ace is false. should do nothing");
	// 				}
	// 				ace = 0;
				
	// 			}
	// 		// if (ace = true ) {
				
	// 		// 		totalValue -= 10;
	// 		// 		ace = false;
				
				
	// 		// }
	// 			System.out.println(totalValue);
				

			
	// 		}
			
			

	// 	//}
		

	// 	return this.totalValue;

	// }
	
	
	

}