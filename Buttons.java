import java.awt.*;
import java.swing.*;
import java.awt.event.*;

public class Buttons extends JPanel implements ActionListener {
	public Buttons() {
		super();

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
	}
	public void actionPerformed(ActionEvent ae) {
		if ("Hit".equals(ae.getActionCommand())) {
			player.addACard(table.deal());
			repaint();
		} else if ("Stay".equals(ae.getActionCommand())) {
			runDealer()
			repaint();
		}
	}
}