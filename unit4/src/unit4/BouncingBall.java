package unit4;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

public class BouncingBall extends MouseAdapter implements KeyListener{
	JFrame window;
	DrawPanel panel;
	ArrayList<Ball> balls;	//a list of Balls
	Timer timer;
	int T_SPEED = 10;
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new BouncingBall();
			}
		});

	}
	
	BouncingBall() {
		window = new JFrame("Many Bouncing Balls!");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.addKeyListener(this);
		window.addMouseListener(this);
			
		panel = new DrawPanel();
		window.add(panel);
		
		//make a list of 6 balls
		balls = new ArrayList<Ball>();
		for (int i = 0; i < 6; i++) {
			balls.add(new Ball());
		}
		
		window.pack();
		window.setVisible(true);
		
		timer = new Timer(T_SPEED, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//move each ball in the list
				for (Ball b: balls) {
					b.move();
					panel.repaint();
				}
				
			}
		});
		timer.start();
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if(timer.isRunning()) timer.stop();
		else timer.restart();
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		if(timer.isRunning()) timer.stop();
		else timer.restart();
	}
	
	public void keyTyped(KeyEvent e) {}
	public void keyReleased(KeyEvent e) {}
	
	class DrawPanel extends JPanel {
		int panW, panH;
		DrawPanel() {
			panW = 800;
			panH = 500;
			
			this.setPreferredSize(new Dimension(panW, panH));
			this.setBackground(Color.BLACK);
		}
		
		@Override
		public void paintComponent(Graphics g) {
			panW = this.getWidth();
			panH = this.getHeight();
			
			super.paintComponent(g);
			Graphics2D g2d = (Graphics2D)g;
			g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			
			//Draw the balls
			for (Ball b: balls) {
				g2d.setPaint(b.c);
				g2d.fillOval(b.x,  b.y,  b.r,  b.r);
			}
			this.setPreferredSize(new Dimension(panW, panH));
		}
	}
	
	class Ball {
		int x, y;	//position
		double xx, yy;	//position, but doubles
		double vx, vy;	//speed
		int r;	//radius of ball
		Color c;
		
		static final double g = 0.1; //gravity
		
		Ball() {
			x = (int)(Math.random()*600);
			y = (int)(Math.random()*300);
			xx = (double)x;
			yy = (double)y;
			vx = 2.0;
			vy = 0.8;
			r = 20;
			c = new Color((int)(Math.random()*256), (int)(Math.random()*256), (int)(Math.random()*256));
		}
		
		public void move() {
			this.vy = vy + g;
			
			this.xx += vx;
			this.yy += vy;
			//check collisions on sides
			if ((int)xx + r > panel.panW) {
				this.xx = (double)(panel.panW - r);
				this.vx *= -1;
			} else if (xx < 0.0) {
				this.xx = 0.0;
				this.vx *= -1;
			}
			//check collision with floor and ceiling
			if ((int)yy + r > panel.panH) {
				this.yy = (double)(panel.panH - r);
				this.vy *= -1;
			} else if (yy < 0.0) {
				this.yy = 0.0;
				this.vy *= -1;
			}
			//update int positions
			this.x = (int)xx;
			this.y = (int)yy;
		}
	}

}


