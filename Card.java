import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Card {
	private String card;
	private int value;
	private String suit;
	private int faceNumber;
	private Image image;
	private String name;
	private int value2;
	//private int number;
	//int[] values = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
 	public Card(int faceNumber, int value, String suit) {
		setCard(card);
		setSuit(suit);
		setValue(value);
		this.faceNumber = faceNumber;
		this.image = Card.loadImage(getFaceNumber() + suit);
		//System.out.println("" + this.value + " of " + this.suit);

	}
	public Card(int faceNumber, int value, int value2, String suit) {
		setSuit(suit);
		setValue(value);
		setValue2(value2);
		this.faceNumber = faceNumber;
		this.image = Card.loadImage(getFaceNumber() + suit);
	}
	public String getFaceNumber() {
		
		if (this.faceNumber == 1) {
			return "A";
		} else if (this.faceNumber > 1 && this.faceNumber <= 10) {
			
			return "" + this.faceNumber;
		} else if (this.faceNumber == 11) {
			return "J";
		} else if (this.faceNumber == 12) {
			return "Q";
		} else if (this.faceNumber == 13) {
			return "K";
		} else {
			return "";
		}
	}
	public String getCard() {
		return this.card;
	}
	public void setCard(String card) {
		this.card = card;
	}
	public int getValue2() {
		return this.value2;
	}
	public void setValue2(int value2) {
		this.value2 = value2;
	}
	public int getValue() {
		return this.value;
	}
	public void setValue(int value) {
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
			path = "Cards" + File.separator + name + ".png";
			//path = "images/sitiiltksj.jpg";
			// images/Jurrassic Park.jpg
			image = ImageIO.read(new File(path));
		} catch(IOException e) {
			System.out.println("Could not load image at path: " + path);
			System.exit(1);
		}
		return image;
	}
	public String faceAndSuit() {
		return this.getFace() + this.getSuit();
	}

}