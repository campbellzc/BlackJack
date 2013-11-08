import java.awt.*;
import java.applet.*;
import java.awt.Graphics;
import java.awt.Rectangle;

public class BlackJackApplet extends Applet {

	private Deck table;
	private Hand player;

	public void init() {
		table = new Deck();
		player = new Hand(table[0]);
	}

	public void paint(Graphics g) {
		//table.draw(g);
		player.draw(g);
	}

}