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
	private Dealer dealer;
	private JButton hit, stay, doubleDown, newGame, bet10;
	private int totalValueD;
	private int yourMoney;
	private int pot;
	public void init() {
		//Card card = table.deal();
		int yourMoney = 1000;
		int pot = 0;
		
		
		
		
		String title = "Hit";
		hit = new JButton(title);
		hit.setActionCommand(title);
		hit.addActionListener(this);
		this.add(hit);

		title = "Stay";
		stay = new JButton(title);
		stay.setActionCommand(title);
		stay.addActionListener(this);
		this.add(stay);

		title = "New Game";
		newGame = new JButton(title);
		newGame.setActionCommand(title);
		newGame.addActionListener(this);
		this.add(newGame);

		title = "Double Down";
		doubleDown = new JButton(title);
		doubleDown.setActionCommand(title);
		doubleDown.addActionListener(this);
		this.add(doubleDown);
		
		title = "Bet $10";
		bet10 = new JButton(title);
		bet10.setActionCommand(title);
		bet10.addActionListener(this);
		this.add(bet10);
		
		this.totalValue = 0;
		table = new Deck();
		
		
		player = new Player(table.deal());
		
		dealer = new Dealer(table.deal());
		System.out.println("firstCard value" + player.playersHand.maxHand[0].getValue());
		
		player.playersHand.addACard(table.deal());
		
		
		dealer.dealersHand.addACard(table.deal());
		System.out.println("secondCard value" + player.playersHand.maxHand[1].getValue());
		System.out.println(totalValue);
		
			
		
	}


	public void paint(Graphics g) {
		//table.draw(g);
		super.paint(g);
		player.playersHand.drawPlayer(g);
		
		//player.drawPlayer(g);
		dealer.dealersHand.drawDealerFirst(g);
	}
	public void actionPerformed(ActionEvent ae) {
		if ("Hit".equals(ae.getActionCommand())) {
			int playerSum = player.playersHand.getTotalValue();
			if (playerSum < 21) {
				player.playersHand.addACard(table.deal());
				
				repaint();
			}
			
			
		} else if ("Stay".equals(ae.getActionCommand())) {
			int dealerSum = dealer.dealersHand.getTotalValue();
			while (dealerSum < 17) {
				dealer.dealersHand.addACard(table.deal());
				dealerSum = dealer.dealersHand.getTotalValue();
				repaint();
			}
		}
		if ("New Game".equals(ae.getActionCommand())) {
			init();
			repaint();
		}
		if ("Double Down".equals(ae.getActionCommand())) {
			
		}
		if ("Bet $10".equals(ae.getActionCommand())) {
			
		}
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
