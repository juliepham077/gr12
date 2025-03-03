package unit4;
import java.awt.*;
import javax.swing.*;

public class GridLayoutDemo {
	public static void main(String[] args) {
		new GridLayoutDemo();
	}
	
	GridLayoutDemo()  {
		JFrame window = new JFrame("Grid Layout Demo");
		//You can create the panel and indicate the layout in 1 step
		JPanel panel = new JPanel(new GridLayout(2,3,10, 20));
		
		JLabel lab1 = new JLabel("This is the Row 1, Col 1");
		panel.add(lab1);
		JButton b1 = new JButton("Row 1, Col 2");
		panel.add(b1);
		JButton b2 = new JButton("Row 1, Col 3");
		panel.add(b2);
		JLabel lab2 = new JLabel("This is Row 2, Col 1");
		panel.add(lab2);
		JButton b3 = new JButton("Row 2, Col 2");
		panel.add(b3);
		JButton b4 = new JButton("Row 2, Col 3");
		panel.add(b4);
		
		window.setContentPane(panel);
		window.pack();
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
