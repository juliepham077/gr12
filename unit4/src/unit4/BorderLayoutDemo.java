package unit4;
import java.awt.*;
import javax.swing.*;
public class BorderLayoutDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new BorderLayoutDemo();
	}
	
	BorderLayoutDemo() {
		JFrame window = new JFrame("Border Layout Demo");
		JButton b1, b2, b3, b4, b5;
		JPanel panel = new JPanel();
		
		panel.setLayout(new BorderLayout(10, 10));
		
		b1 = new JButton("Button 1");
		panel.add(b1, BorderLayout.LINE_START);
		
		b2 = new JButton("Button 2");
		panel.add(b2, BorderLayout.PAGE_START);
		
		b3 = new JButton("Button 3");
		panel.add(b3, BorderLayout.LINE_END);
		
		b4 = new JButton("Button 4");
		panel.add(b4, BorderLayout.PAGE_END);
		
		b5 = new JButton("Button 5");
		panel.add(b5, BorderLayout.CENTER);
		
		window.setContentPane(panel);
		window.pack();
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
