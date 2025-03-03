package unit4;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class SemesterAvg implements ActionListener {
	JFrame frame;
	JPanel contentPane;
	JLabel prompt1, prompt2, prompt3, average, maximum, minimum;
	JTextField grade1, grade2, grade3;
	JButton calculate;
	JCheckBox avg, max, min;
	
	public SemesterAvg() {
		//Create and set up the frame
		frame = new JFrame("Semester Average");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Create a content pane with a GridLayout
		contentPane = new JPanel(new GridLayout(0, 2, 10, 5));
		contentPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		//Create and add a prompt and then a text field
		prompt1 = new JLabel("Enter the first grade: ");
		contentPane.add(prompt1);
		grade1 = new JTextField(10);
		contentPane.add(grade1);
		
		//Create and add a second prompt and then a text field
		prompt2 = new JLabel("Enter the second grade: ");
		contentPane.add(prompt2);
		grade2 = new JTextField(10);
		contentPane.add(grade2);
		
		//Create and add a second prompt and then a text field
		prompt3 = new JLabel("Enter the third grade: ");
		contentPane.add(prompt3);
		grade3 = new JTextField(10);
		contentPane.add(grade3);
		
		
		//Create and add average check box and label
		avg = new JCheckBox("Average");
		avg.addActionListener(this);
		contentPane.add(avg);		
		average = new JLabel(" ");
		contentPane.add(average);
		
		//Create and add maximum check box and label
		max = new JCheckBox("Maximum");
		max.addActionListener(this);
		contentPane.add(max);		
		maximum = new JLabel(" ");
		contentPane.add(maximum);
		
		//Create and add minimum check box and label
		min = new JCheckBox("Minimum");
		min.addActionListener(this);
		contentPane.add(min);		
		minimum = new JLabel(" ");
		contentPane.add(minimum);
		
		//Create and add button that will display the average of the grades
		calculate = new JButton("Calculate");
		calculate.setActionCommand("Calculate");
		calculate.addActionListener(this);
		contentPane.add(calculate);
		
		//Add content pane to frame
		frame.setContentPane(contentPane);
		
		//Size and then display the frame
		frame.pack();
		frame.setVisible(true);
	}//end SemesterAvg()
	
	/**
	 * Handle button click action event
	 */
	public void actionPerformed(ActionEvent event) {
		String eventName = event.getActionCommand();
		
		//Determine if the button is pressed
		if (eventName.equals("Calculate")) {
			//Read in info from text fields
			String g1 = grade1.getText();
			String g2 = grade2.getText();
			String g3 = grade3.getText();
			
			//If Average check box is selected, calculate and display the average
			if (avg.isSelected()) {
				double avgGrade;
				avgGrade = (Double.parseDouble(g1) + Double.parseDouble(g2) + Double.parseDouble(g3)) / 3.0;
				average.setText(Double.toString(avgGrade));
			} else {
				average.setText(" ");
			}
			
			//If Maximum check box is selected, calculate and display the maximum value
			if (max.isSelected()) {
				double maxValue;
				if (Double.parseDouble(g1) >= Double.parseDouble(g2) && Double.parseDouble(g1) >= Double.parseDouble(g3)) maxValue = Double.parseDouble(g1);
				else if (Double.parseDouble(g2) >= Double.parseDouble(g3)) maxValue = Double.parseDouble(g2);
				else maxValue = Double.parseDouble(g3);
				maximum.setText(Double.toString(maxValue));
			} else {
				maximum.setText(" ");
			}
			
			//If Minimum check box is selected, calculate and display the minimum value
			if (min.isSelected()) {
				double minValue;
				if (Double.parseDouble(g1) <= Double.parseDouble(g2) && Double.parseDouble(g1) <= Double.parseDouble(g3)) minValue = Double.parseDouble(g1);
				else if (Double.parseDouble(g2) <= Double.parseDouble(g3)) minValue = Double.parseDouble(g2);
				else minValue = Double.parseDouble(g3);
				minimum.setText(Double.toString(minValue));
			} else {
				minimum.setText(" ");
			}
		}
	}//end actionPerformed()
	
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new SemesterAvg();
			}
		});

	}

}

