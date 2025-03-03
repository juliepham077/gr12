package unit4;
import java.awt.*;
import javax.swing.*;
public class BoxLayoutDemo {

	public static void main(String[] args) {
	 	new BoxLayoutDemo();
	}
	
	BoxLayoutDemo() {
		JFrame window = new JFrame("Box Layout Demo");
		
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		
		JLabel lab1 = new JLabel("This is a label");
		panel.add(lab1);
		panel.add(Box.createRigidArea(new Dimension(0,5)));
		
		JLabel lab2 = new JLabel("There is a rigid area above this.");
		panel.add(lab2);
		
		JButton b1 = new JButton("This is a button!");
		panel.add(b1);
		panel.add(Box.createRigidArea(new Dimension(10,15)));
		JButton b2 = new JButton("This is another button!");
		panel.add(b2);
		
		window.setContentPane(panel);
		window.pack();
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
