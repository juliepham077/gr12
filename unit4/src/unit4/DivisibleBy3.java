package unit4;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class DivisibleBy3 implements ActionListener{
	JFrame frame;
	JPanel panel;
	JLabel prompt, answer;
	JButton check;
	JTextField number;
	
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new DivisibleBy3();
			}
		});
	}
	
	public DivisibleBy3() {
		frame = new JFrame("DivisibleBy3");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel(new GridLayout(2,2,10,10));
		panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		prompt = new JLabel("Enter an integer: ");
		panel.add(prompt);
		
		number = new JTextField(15);
		panel.add(number);
		
		check = new JButton("Check");
		check.setActionCommand("Check");
		check.addActionListener(this);
		panel.add(check);
		
		answer = new JLabel(" ");
		panel.add(answer);
		
		frame.setContentPane(panel);
		frame.pack();
		frame.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent event) {
		String eventName = event.getActionCommand();
		
		if (eventName.equals("Check")) {
			String n = number.getText();
			if (Integer.parseInt(n)%3 == 0) answer.setText("Number is divisible by 3.");
			else answer.setText("Number is not divisible by 3.");
		}
	}

}
