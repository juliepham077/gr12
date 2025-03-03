package unit4;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class MetricConversion2 implements ActionListener{
	
	JFrame window;
	JPanel panel;
	JLabel prompt, formula;
	JRadioButton ic, fm, gl, pk;
	ButtonGroup buttons;
	
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new MetricConversion2();
			}
		});

	}
	
	MetricConversion2() {
		//Set up the frame
		window = new JFrame("MetricConversion");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Set up the panel
		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		//panel.setPreferredSize(new Dimension(200, 100));
		
		//Add the prompt label
		prompt = new JLabel("Select a conversion type:");
		prompt.setAlignmentX(Component.LEFT_ALIGNMENT);
		panel.add(prompt);
		
		//Create and add the radio buttons
		ic = new JRadioButton("inch to centimeters");
		ic.setActionCommand("inch to centimeters");
		ic.addActionListener(this);
		panel.add(ic);
		
		fm = new JRadioButton("foot to meters");
		fm.setActionCommand("foot to meters");
		fm.addActionListener(this);
		panel.add(fm);
		
		gl = new JRadioButton("gallon to liters");
		gl.setActionCommand("gallon to liters");
		gl.addActionListener(this);
		panel.add(gl);
		
		pk = new JRadioButton("pound to kilograms");
		pk.setActionCommand("pound to kilograms");
		pk.addActionListener(this);
		panel.add(pk);
		
		//Add radio buttons to a button group
		buttons = new ButtonGroup();
		buttons.add(ic);
		buttons.add(fm);
		buttons.add(gl);
		buttons.add(pk);
		
		panel.add(Box.createRigidArea(new Dimension(10, 15)));
		
		//Add the label to show the conversion formula
		formula = new JLabel(" ");
		formula.setAlignmentX(Component.LEFT_ALIGNMENT);
		panel.add(formula);
				
		//Pack and display the window
		window.add(panel);
		window.pack();
		window.setLocationRelativeTo(null);
		window.setVisible(true);
	}
	
	/**
	 * Handle the radio button selection
	 */
	public void actionPerformed(ActionEvent e) {
		String name = e.getActionCommand();
		
		if (name == "inch to centimeters") formula.setText("1 inch = 2.54 centimeters");
		else if (name == "foot to meters") formula.setText("1 foot = 0.3048 meters");
		else if (name == "gallon to liters") formula.setText("1 gallon = 4.5461 liters");
		else if (name == "pound to kilograms") formula.setText("1 pound = 0.4536 kilograms");
	}

}

