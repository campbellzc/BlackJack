import java.awt.*;
import java.applet.*;

public class BlackJackApplet extends Applet {

	private Card poster;

	public void init() {
		poster = new Card("card");
	}

	public void paint(Graphics g) {
		poster.draw(g, new Rectangle(50, 50, 200, 300));
	}

}