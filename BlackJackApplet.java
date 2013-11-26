import java.awt.*;
import java.applet.*;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.*;
import java.awt.event.*;

public class BlackJackApplet extends Applet implements ActionListener{
	private JLabel walletLabel, potLabel, score, wins, losses, draws;
	private Deck table;
	private Player player;
	private Dealer dealer;
	private JButton hit, stay, doubleDown, newGame, bet10, doneBet;
	private int totalValueD;
	private int wallet, totalBet, pot, ace, totalValue, dealerSum, playerSum;
	private int dealersMoney, loseGames, winGames, drawGames;
	private Graphics g;
	private boolean front = false;
	
	// sets the initial window
	public void init() {
		int totalBet = 0;
		//Card card = table.deal();
		setWallet(1000);
		setPot(0);
		this.dealersMoney = 999999999;
		winGames = 0;
		loseGames = 0;
		drawGames = 0;
		
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

		title = "Done Betting";
		doneBet = new JButton(title);
		doneBet.setActionCommand(title);
		doneBet.addActionListener(this);
		this.add(doneBet);
		
		potLabel = new JLabel("There is $" + getPot() + " in the pot");
		potLabel.setFont(new Font("sansserif", Font.BOLD, 32));
        this.add(potLabel);

        score = new JLabel("                  Bet Please");
        score.setFont(new Font("sansserif", Font.BOLD, 45));
        this.add(score);

        wins = new JLabel(winGames + "-");
        wins.setFont(new Font("sansserif", Font.BOLD, 32));
        this.add(wins);

        losses = new JLabel(loseGames + "-");
        losses.setFont(new Font("sansserif", Font.BOLD, 32));
        this.add(losses);
		
        draws = new JLabel(drawGames + "");
        draws.setFont(new Font("sansserif", Font.BOLD, 32));
        this.add(draws);

		this.totalValue = 0;
		table = new Deck();
		
		doubleDown.setEnabled(false);
		newGame.setEnabled(false);
		stay.setEnabled(false);
		hit.setEnabled(false);
		
			
		
	}

	// draws the cards
	public void paint(Graphics g) {
		//table.draw(g);
		super.paint(g);
		player.playersHand.drawPlayer(g);
		if (front == true) {
			dealer.dealersHand.drawDealer(g);
		} else {
			dealer.dealersHand.drawDealerFirst(g);
		}
		
		
		//player.drawPlayer(g);
		
		

	}
	//the buttons
	public void actionPerformed(ActionEvent ae) {
		if ("Hit".equals(ae.getActionCommand())) {
			

			if (playerSum < 21) {
				
				player.playersHand.addACard(table.deal());
				repaint();
				
				playerSum = player.playersHand.getTotalValue();
				

			}

			if (playerSum > 21) {
				setWallet(getWallet());
				score.setText("You busted. YOU LOSE!");
				bet10.setEnabled(false);
				doneBet.setEnabled(false);
				doubleDown.setEnabled(false);
				newGame.setEnabled(true);
				stay.setEnabled(false);
				hit.setEnabled(false);
				stay();

			}
		}
		if ("Stay".equals(ae.getActionCommand())) {
			stay();
		}
		if ("New Game".equals(ae.getActionCommand())) {
			

			playerSum = 0;
			dealerSum = 0;
			repaint();
			totalBet = 0;
			front = true;
			setWallet(getWallet());
			score.setText("               Bet Again");
			walletLabel.setText("You currently have: $" + getWallet());
			setPot(0);
			potLabel.setText("There is $" + getPot() + " in the pot.");
			
			doubleDown.setEnabled(false);
			newGame.setEnabled(false);
			stay.setEnabled(false);
			hit.setEnabled(false);
			bet10.setEnabled(true);
			doneBet.setEnabled(true);
			
		}
		if ("Double Down".equals(ae.getActionCommand())) {
			player.playersHand.addACard(table.deal());
			playerSum = player.playersHand.getTotalValue();
			setWallet(getWallet() - totalBet);
			setPot(getPot() + (totalBet*2));
			walletLabel.setText("You currently have: $" + getWallet());
			potLabel.setText("There is $" + getPot() + " in the pot.");
			// if (playerSum > 21) {
			// 	setWallet(getWallet());
			// 	score.setText("You busted. YOU LOSE!");
			// 	front = true;
			// 	repaint();
			// }
			// if (playerSum < 22) {
			// 	repaint();
			// }
			stay();
		}
		if ("Bet $10".equals(ae.getActionCommand())) {
			setWallet(getWallet()-10);
			totalBet += 10;
			walletLabel.setText("You currently have: $" + getWallet());
			setPot(getPot() + 20);
			potLabel.setText("There is $" + getPot() + " in the pot.");
			dealersMoney -= 10;
			
		}
		if ("Done Betting".equals(ae.getActionCommand())) {
			front = false;
			first4Cards();
			repaint();
			score.setText("                     Playing....");
			bet10.setEnabled(false);
			doneBet.setEnabled(false);
			doubleDown.setEnabled(true);
			newGame.setEnabled(true);
			stay.setEnabled(true);
			hit.setEnabled(true);
		}
	}
	// gets wallet
	public int getWallet() {
        return this.wallet;
	}
	// sets wallet
	public void setWallet(int wallet) {
		this.wallet = wallet;
	}
	//gets pot
	public int getPot() {
        return this.pot;
	}
	// sets pot
	public void setPot(int pot) {
		this.pot = pot;
	}
	//deals the first 4 cards
	public void first4Cards() {
		player = new Player(table.deal());
		dealer = new Dealer(table.deal());
		player.playersHand.addACard(table.deal());
		dealer.dealersHand.addACard(table.deal());
		int playerSum = player.playersHand.getTotalValue();
		int dealerSum = dealer.dealersHand.getTotalValue();
	}
	// calculates the score
	public void calculateScore() {
			if (playerSum < 22 && (dealerSum < playerSum || dealerSum > 21)) {
				setWallet(getWallet() + getPot());
				setPot(0);
				walletLabel.setText("You currently have: $" + getWallet());
				score.setText("                You win!");
				winGames++;
				wins.setText(winGames + "-");
			} else if ((dealerSum < 22 || playerSum > 21) && playerSum < dealerSum) {
				setWallet(getWallet());
				walletLabel.setText("You currently have: $" + getWallet());
				score.setText("                YOU LOSE!");
				loseGames++;
				losses.setText(loseGames + "-");
			} else if (playerSum < 22 && dealerSum == playerSum) {
				setWallet(getWallet() + (getPot()/2));
				dealersMoney = dealersMoney + (getPot()/2);
				setPot(0);
				walletLabel.setText("You currently have: $" + getWallet());
				potLabel.setText("There is $" + getPot() + " in the pot.");
				score.setText("             It's a draw!");
				drawGames++;
				draws.setText(drawGames + "");
				
			}
			

	}
	// stay button
	public void stay() {
		playerSum = player.playersHand.getTotalValue();
		front = true;
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
		hit.setEnabled(false);
		doubleDown.setEnabled(false);
		stay.setEnabled(false);
	}
	
	
	
	

}
