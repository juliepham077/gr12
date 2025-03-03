package unit4;
import javax.swing.*;
public class SimpleGUI {

	public static void main(String[] args) {
	 	JFrame window = new JFrame("Hello, World!");
		window.setSize(500, 120);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		JLabel lab1 = new JLabel("Hello, World!", SwingConstants.LEFT);
		JLabel lab2 = new JLabel("Hello, World!", SwingConstants.CENTER);
		JLabel lab3 = new JLabel("Hello, World!", SwingConstants.RIGHT);
		panel.add(lab1);
		panel.add(lab2);
		panel.add(lab3);
		
		window.add(panel);
		window.setVisible(true);
	}

}

