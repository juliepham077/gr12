package unit4;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MoveBall extends JFrame implements ActionListener{
	JFrame window;
	JPanel panel;
	JButton left, right, up, down;
	Ball ball;
	DrawPanel pan;
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new MoveBall();
			}
		});
	}//end main()
	
	MoveBall() {
		window = new JFrame("Move A Ball");
		window.setSize(500, 500);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//Set up the panel
		panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
		panel.setPreferredSize(new Dimension(500, 475));
		//panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		//Create ball
		ball = new Ball();
		
		//Create DrawPanel
		pan = new DrawPanel();
		panel.add(pan);

		//Up button
		up = new JButton("up");
		up.setActionCommand("up");
		up.addActionListener(this);
		panel.add(up);
		
		panel.add(Box.createRigidArea(new Dimension(500, 0)));
		
		//Left button
		left = new JButton("left");
		left.setActionCommand("left");
		left.addActionListener(this);
		panel.add(left);
		
		//Right button
		right = new JButton("right");
		right.setActionCommand("right");
		right.addActionListener(this);
		panel.add(right);
		
		panel.add(Box.createRigidArea(new Dimension(500, 0)));
		
		//Down button
		down = new JButton("down");
		down.setActionCommand("down");
		down.addActionListener(this);
		panel.add(down);
		
		//Pack and display the window
		window.add(panel);
		window.pack();
		window.setLocationRelativeTo(null);
		window.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "left") ball.moveLeft();
		if (e.getActionCommand() == "right") ball.moveRight();
		if (e.getActionCommand() == "up") ball.moveUp();
		else if (e.getActionCommand() == "down") ball.moveDown();
		pan.repaint();
	}
	
	class DrawPanel extends JPanel {
		int panW, panH;
		
		DrawPanel(){
			panW = 500;
			panH = 300;
			this.setPreferredSize(new Dimension(panW, panH));
			this.setBackground(Color.CYAN);
		}
		
		@Override
		public void paintComponent(Graphics g) {
			panW = this.getWidth();
			panH = this.getHeight();
			super.paintComponent(g);
			Graphics2D g2d = (Graphics2D)g;
			g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			g2d.setBackground(Color.CYAN);
			g2d.setPaint(Color.RED);
			g2d.fillOval(ball.x, ball.y, ball.r, ball.r);
			this.setPreferredSize(new Dimension(panW, panH));
		}
	}
	
	class Ball {
		int x, y; //position
		int r; //radius
		
		Ball() {
			x=230;
			y=130;
			r=40;
		}
		
		void moveLeft() {
			x-=5;
		}
		
		void moveRight() {
			x+=5;
		}
		
		void moveUp() {
			y-=5;
		}
		
		void moveDown() {
			y+=5;
		}
	}
}
