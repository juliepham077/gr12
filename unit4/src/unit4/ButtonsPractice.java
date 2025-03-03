package unit4;
import javax.swing.*;
public class ButtonsPractice extends JFrame{

	public static void main(String[] args) {
		new ButtonsPractice();
	}
	
	ButtonsPractice() {
		this.setTitle("Practice!");
		this.setSize(230, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		
		JButton b1 = new JButton("This is a button!");
		panel.add(b1);
		
		JLabel name = new JLabel("My name is Julie!! WOOO");
		panel.add(name);
		
		JLabel thing = new JLabel("I am in gr11.YAAA");
		panel.add(thing);
		
		JButton b2 = new JButton("Another button!");
		panel.add(b2);
		
		JButton b3 = new JButton("DO NOT PRESS THIS BUTTON!");
		panel.add(b3);
		
		this.add(panel);
		this.setVisible(true);
	}

}

