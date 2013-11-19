import java.awt.*;
import java.applet.*;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.swing.*;
import java.awt.event.*;
public class BlackJackApplet extends Applet implements ActionListener {

	private Deck table;
	private Hand player;
	private int totalValue;
	private int ace;
	private Hand dealer;
	public void init() {
		this.totalValue = 0;
		table = new Deck();
		player = new Player(table.deal());
		dealer = new Dealer(table.deal());
		player.addACard(table.deal());
		dealer.addACard(table.deal());
		this.ace = 0;
		if (table.cards[0].getValue() == 1) {
			this.totalValue = table.cards[0].getValue2();
			this.ace = 1;
		} else	{
			this.totalValue = table.cards[0].getValue();
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
		player.drawPlayer(g, runPlayer(totalValue, ace));
		dealer.draw(g, runDealer(totalValue, ace));
	}
	
	
	

}