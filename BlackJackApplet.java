import java.awt.*;
import java.applet.*;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.*;
import java.awt.event.*;

public class BlackJackApplet extends Applet implements ActionListener{
	private JLabel walletLabel, potLabel, score;
	private int playerSum;
	private int dealerSum;
	private Deck table;
	private Player player;
	private int totalValue;
	private int ace;
	private Dealer dealer;
	private JButton hit, stay, doubleDown, newGame, bet10;
	private int totalValueD;
	private int wallet;
	private int pot;
	private int dealersMoney;
	public void init() {

		//Card card = table.deal();
		setWallet(1000);
		setPot(0);
		this.dealersMoney = 999999999;
		
        walletLabel = new JLabel("You currently have: $" + getWallet());
        walletLabel.setFont(new Font("sansserif", Font.BOLD, 32));
        this.add(walletLabel);
		
		
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
		
		potLabel = new JLabel("There is $" + getPot() + " in the pot");
		potLabel.setFont(new Font("sansserif", Font.BOLD, 32));
        this.add(potLabel);

        score = new JLabel("                  Playing...");
        score.setFont(new Font("sansserif", Font.BOLD, 45));
        this.add(score);
		
		this.totalValue = 0;
		table = new Deck();
		
		
		player = new Player(table.deal());
		
		dealer = new Dealer(table.deal());
		System.out.println("firstCard value" + player.playersHand.maxHand[0].getValue());
		
		player.playersHand.addACard(table.deal());
		
		
		dealer.dealersHand.addACard(table.deal());
		int playerSum = player.playersHand.getTotalValue();
		int dealerSum = dealer.dealersHand.getTotalValue();
		//System.out.println("secondCard value" + player.playersHand.maxHand[1].getValue());
		//System.out.println(totalValue);
		
			
		
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
			

			if (playerSum < 21) {
				
				player.playersHand.addACard(table.deal());
				repaint();
				
				playerSum = player.playersHand.getTotalValue();
				System.out.println("totalValue (player)= " + player.playersHand.getTotalValue());
			System.out.println("playersum = " + playerSum);
			}

			if (playerSum > 21) {
				setWallet(getWallet()-getPot());
				score.setText("You busted. YOU LOSE!");
				
			}
		}
		if ("Stay".equals(ae.getActionCommand())) {
			
			
			if (playerSum > 21) {
				score.setText("Dealer wins! You Busted.");
				setWallet(getWallet() - getPot());
				
			} else if (playerSum <= 21){
				while (dealerSum < 17) {
					dealer.dealersHand.addACard(table.deal());
					
					repaint();
					dealerSum = dealer.dealersHand.getTotalValue();
					System.out.println("dealertotalvalue = " + dealer.dealersHand.getTotalValue());
					System.out.println("playersum = " + player.playersHand.getTotalValue());
					System.out.println("dealersum = " + dealerSum);
				}
				calculateScore();
			}
		}
		if ("New Game".equals(ae.getActionCommand())) {
			first4Cards();
			score.setText("               Playing...");
			walletLabel.setText("You currently have: $" + getWallet());
			setPot(0);
			potLabel.setText("There is $" + getPot() + " in the pot.");
			repaint();

		}
		if ("Double Down".equals(ae.getActionCommand())) {
			
		}
		if ("Bet $10".equals(ae.getActionCommand())) {
			setWallet(getWallet()-10);
			walletLabel.setText("You currently have: $" + getWallet());
			setPot(getPot() + 20);
			potLabel.setText("There is $" + getPot() + " in the pot.");
			dealersMoney -= 10;
			
		}
	}
		
	public int getWallet() {
        return this.wallet;
	}
	public void setWallet(int wallet) {
		this.wallet = wallet;
	}
	public int getPot() {
        return this.pot;
	}
	public void setPot(int pot) {
		this.pot = pot;
	}
	public void first4Cards() {
		int playerSum = 0;
		int dealerSum = 0;
		player = new Player(table.deal());
		dealer = new Dealer(table.deal());
		player.playersHand.addACard(table.deal());
		dealer.dealersHand.addACard(table.deal());
		playerSum = player.playersHand.getTotalValue();
		dealerSum = dealer.dealersHand.getTotalValue();
	}
	public void calculateScore() {
			if (playerSum < 22 && (dealerSum < playerSum || dealerSum > 21)) {
				setWallet(getWallet() + getPot());
				setPot(0);
				walletLabel.setText("You currently have: $" + getWallet());
				score.setText("                You win!");
			} else if ((dealerSum < 22 || playerSum > 21) && playerSum < dealerSum) {
				setWallet(getWallet()-getPot());
				walletLabel.setText("You currently have: $" + getWallet());
				score.setText("                YOU LOSE!");
			} else if (playerSum < 22 && dealerSum == playerSum) {
				setWallet(getWallet() + (getPot()/2));
				dealersMoney = dealersMoney + (getPot()/2);
				setPot(0);
				walletLabel.setText("You currently have: $" + getWallet());
				potLabel.setText("There is $" + getPot() + " in the pot.");
				score.setText("             It's a draw!");
				//pot = 0;	
			}
			// } else if (dealerSum > 21 && playerSum < 21) {
			// 	setWallet(getWallet() + getPot());
			// 	setPot(0);
			// 	walletLabel.setText("You currently have: $" + getWallet());
			// 	score.setText("                You win!");
			// }

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
