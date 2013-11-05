import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Card {
	private String card;
	private String value;
	private String suit;
	private int faceNumber;
	private Image image;
	private String name;
	//private int number;
	//int[] values = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
 	public Card(int faceNumber, String value, String suit) {
		setCard(card);
		setSuit(suit);
		setValue(value);
		this.faceNumber = faceNumber;
		//System.out.println("" + this.value + " of " + this.suit);

	}
	public Card(int faceNumber, String value, String value2, String suit) {
		this.suit = suit;
		this.value = value;
		this.value2 = value;
		this.faceNumber = faceNumber;
	}
	
	public String getCard() {
		return this.card;
	}
	public void setCard(String card) {
		this.card = card;
	}
	public String getValue() {
		return this.value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getSuit() {
		return this.suit;
	}
	public void setSuit(String suit) {
		this.suit = suit;
	}
	public int getFace() {
		return this.faceNumber;
	}
	public void setFace(int faceNumber) {
		this.faceNumber = faceNumber;
	}
	public void draw(Graphics g, Rectangle r) {
		g.drawImage(image, r.x, r.y, r.width, r.height, null);
	}
	private static Image loadImage(String name) {
		String path = null;
		Image image = null;

		try {
			path = "cards" + File.separator + value + name + ".png";
			//path = "images/sitiiltksj.jpg";
			// images/Jurrassic Park.jpg
			image = ImageIO.read(new File(path));
		} catch(IOException e) {
			System.out.println("Could not load image at path: " + path);
			System.exit(1);
		}
		return image;
	}

}