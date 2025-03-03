package unit4;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class MetricConversion implements ActionListener{
	
	JFrame window;
	JPanel panel;
	JLabel prompt, formula;
	JTextField input;
	JComboBox selection;
	
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new MetricConversion();
			}
		});

	}
	
	MetricConversion() {
		//Set up the frame
		window = new JFrame("MetricConversion");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Set up the panel
		panel = new JPanel();
		panel.setLayout(new GridLayout(2, 2));
		panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		
		//Add the prompt label
		prompt = new JLabel("Select a conversion type:");
		prompt.setAlignmentX(Component.LEFT_ALIGNMENT);
		panel.add(prompt);
		
		//Create and add the combo box
		String[] conversions = {"inch to centimeters", "foot to meters", "gallon to liters", "pound to kilograms"};
		selection = new JComboBox(conversions);
		selection.setAlignmentX(JComboBox.LEFT_ALIGNMENT);
		selection.addActionListener(this);
		panel.add(selection);
		
		//Add the text field to read the user's input
		input = new JTextField(15);
		panel.add(input);
		
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
	 * Handle the combo box selection
	 */
	public void actionPerformed(ActionEvent e) {
		JComboBox comboBox = (JComboBox)e.getSource();
		String name = (String)comboBox.getSelectedItem();
		
		//Read the value form the text field and convert to a number
		String amount = input.getText();
		double number = Double.parseDouble(amount);
		
		if (name == "inch to centimeters") {
			number *= 2.54;
			formula.setText(Double.toString(number) + " centimeters");
		} else if (name == "foot to meters") {
			number *= 0.3048;
			formula.setText(Double.toString(number) + " meters");
		} else if (name == "gallon to liters") { 
			number *= 4.5461;
			formula.setText(Double.toString(number) + " liters");
		} else if (name == "pound to kilograms") {
			number *= 0.4536;
			formula.setText(Double.toString(number) + " kilograms");
		}
	}

}
