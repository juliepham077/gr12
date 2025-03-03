package unit4;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class OSButtons {

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new OSButtons();
			}
		});
	}
	
	OSButtons() {
		JFrame window = new JFrame("OSButtons");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		ButtonGroup group = new ButtonGroup();
		
		//Add radio buttons
		JRadioButton linux = new JRadioButton("Linux");
		panel.add(linux);
		JRadioButton windows = new JRadioButton("Windows");
		panel.add(windows);
		JRadioButton mac = new JRadioButton("MacIntosh");
		panel.add(mac);
		
		//Add buttons to group, so can only select 1
		group.add(linux);
		group.add(windows);
		group.add(mac);
		
		//Pack and display the window
		window.add(panel);
		window.pack();
		window.setLocationRelativeTo(null);
		window.setVisible(true);
	}

}
