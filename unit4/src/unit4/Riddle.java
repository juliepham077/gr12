package unit4;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Riddle implements ActionListener{
	JFrame frame;
	JPanel panel;
	JLabel question, answer;
	JButton button;
	
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Riddle();
			}
		});
	}
	
	Riddle() {
		frame = new JFrame("Riddle");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel(new GridLayout(2,2, 10, 10));
		panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		question = new JLabel("Why did the chicken cross the road?");
		panel.add(question);
		
		answer = new JLabel(" ");
		panel.add(answer);
		
		button = new JButton("Check");
		button.setActionCommand("Check");
		button.addActionListener(this);
		panel.add(button);
				
		frame.setContentPane(panel);
		frame.pack();
		frame.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent event) {
		String eventName = event.getActionCommand();
		
		if (eventName.equals("Check")) {
			answer.setText("To get to the other side.");
			button.setText("Reset");
			button.setActionCommand("Reset");
		} else {
			answer.setText(" ");
			button.setText("Check");
			button.setActionCommand("Check");
		}
	}

}

