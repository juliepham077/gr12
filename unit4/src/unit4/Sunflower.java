package unit4;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Sunflower implements ActionListener{
	JFrame frame;
	JPanel panel;
	JLabel flower;
	JButton english, latin;

	public static void main(String[] args) {
	 javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Sunflower();
			}
		});
	}
	
	Sunflower() {
		frame = new JFrame("Sunflower");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		panel.add(Box.createRigidArea(new Dimension(10,15)));
		
		flower = new JLabel(" ");
		panel.add(flower);

		panel.add(Box.createRigidArea(new Dimension(10, 10)));
		
		english = new JButton("English");
		english.setActionCommand("English");
		english.addActionListener(this);
		panel.add(english);
		
		latin = new JButton("Latin");
		latin.setActionCommand("Latin");
		latin.addActionListener(this);
		panel.add(latin);
		
		panel.setAlignmentX(Component.CENTER_ALIGNMENT);
				
		frame.setContentPane(panel);
		frame.pack();
		frame.setVisible(true);
	}
	

	public void actionPerformed(ActionEvent event) {
		String eventName = event.getActionCommand();
		
		if (eventName.equals("English")) {
			flower.setText("Sunflower");
		} else if (eventName.equals("Latin")){
			flower.setText("Helianthus");
		}
	}

}
