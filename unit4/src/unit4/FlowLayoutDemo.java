package unit4;
import java.awt.*;
import javax.swing.*;
public class FlowLayoutDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			new FlowLayoutDemo();
	}
		
	FlowLayoutDemo() {
		JFrame window = new JFrame("Flow Layout Demo");
		JButton b1, b2, b3, b4, b5;
		JPanel panel = new JPanel();
		
		//panel.setLayout(new FlowLayout(FlowLayout.LEADING, 10, 10));
		//panel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
		panel.setLayout(new FlowLayout(FlowLayout.TRAILING, 10, 10));
			panel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
				//panel.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
				
		b1 = new JButton("Button 1");
		panel.add(b1);
		
		b2 = new JButton("Button 2");
		panel.add(b2);
				
		b3 = new JButton("Button 3");
		panel.add(b3);
				
		b4 = new JButton("Button 4");
		panel.add(b4);
				
		b5 = new JButton("Button 5");
		panel.add(b5);
				
		window.setContentPane(panel);
		window.pack();
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
