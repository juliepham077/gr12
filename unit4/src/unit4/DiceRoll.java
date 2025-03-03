package unit4;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;
public class DiceRoll extends JPanel implements ActionListener {

	JFrame window;
	JPanel panel;
	JLabel prompt;
	JButton play;
	
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new DiceRoll();
			}
		});

	}
	
	DiceRoll() {
	    
		//Set up the frame
		window = new JFrame("DiceRoll");
		window.setSize(500,500);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Set up the panel
		panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		
		//Add the prompt label
		prompt = new JLabel("Roll Die");
		prompt.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(prompt);
		
		
		panel.add(Box.createRigidArea(new Dimension(500, 500)));
		
		play = new JButton("Rollllllllllllllllllllllllllllllllllllllllllllllll");
		play.setAlignmentX(Component.CENTER_ALIGNMENT);
		play.setActionCommand("Roll");
		play.addActionListener(this);
		panel.add(play);
		
		//Pack and display the window
		window.add(panel);
		window.pack();
		window.setLocationRelativeTo(null);
		window.setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		String eventName = play.getActionCommand();
		if (eventName.equals("Roll")) {
			DiceRoll draw = new DiceRoll();
			DrawingPanel drawPanel = draw.new DrawingPanel();
			window.add(drawPanel);
		    window.setVisible(true);
		}
	}
/*
		
}*/
	private class DrawingPanel extends JPanel {
	      DrawingPanel() { }
	      @Override
	      public void paintComponent(Graphics g) {
	        super.paintComponent(g);
	        int size = 40;
	        int place = 240;
	        Random rand = new Random();
		    int roll = rand.nextInt(6) +1;
		    g.setColor(Color.BLACK);
		    switch (roll) {
		    	case 1:
		    		g.drawOval(place, place, size, size); 
		    		g.fillOval(place, place, size, size); 
		    		break;
		    	case 2:
		    		g.drawOval(place - 50, place+50, size, size);
		    		g.fillOval(place - 50, place+50, size, size); 
		    		g.drawOval(place+50, place-50, size, size);
		    		g.fillOval(place+50, place-50, size, size); 
		    		break;
		    	case 3:
		    		g.drawOval(place+100, place-100, size, size);
		    		g.fillOval(place+100, place-100, size, size); 
		    		g.drawOval(place, place, size, size);
		    		g.fillOval(place, place, size, size); 
		    		g.drawOval(place+100, place-100, size, size);
		    		g.fillOval(place+100, place-100, size, size); 
		    		break;
		    	case 4:
		    		g.drawOval(place+100, place-100, size, size);
		    		g.fillOval(place+100, place-100, size, size); 
		    		g.drawOval(place, place, size, size);
		    		g.fillOval(place, place, size, size); 
		    		g.drawOval(place+100, place-100, size, size);
		    		g.fillOval(place+100, place-100, size, size); 
		    		break;
		    	case 5:
		    		g.drawOval(place+100, place-100, size, size);
		    		g.fillOval(place+100, place-100, size, size); 
		    		g.drawOval(place, place, size, size);
		    		g.fillOval(place, place, size, size); 
		    		g.drawOval(place+100, place-100, size, size);
		    		g.fillOval(place+100, place-100, size, size); 
		    		g.drawOval(place-100, place+100, size, size);
		    		g.fillOval(place-100, place+100, size, size); 
		    		g.drawOval(place, place, size, size);
		    		g.fillOval(place, place, size, size); 
		    		break;
		    	case 6:
		    		g.drawOval(240, 240, size, size); 
		    		break;
		    	default:
		    		g.drawOval(240, 240, size, size); 
		    		g.fillOval(240, 240, size, size); 
			    }
			}
      }
}
