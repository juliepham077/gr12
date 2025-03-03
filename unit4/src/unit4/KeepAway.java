package unit4;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class KeepAway extends MouseAdapter implements MouseMotionListener{
	JFrame window;
	DrawPanel panel;
	Ball b;
	Timer timer;
	int tSpeed = 5;
	int mx, my;
	Rectangle button;
	boolean select = false;
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new KeepAway();
			}
		});
	}
	
	KeepAway(){
		window = new JFrame();
		window.setTitle("Keep Away");
		panel = new DrawPanel();
		b = new Ball();
		button = new Rectangle(10, 10, 80, 40);
		window.addMouseListener(this);
		window.addMouseMotionListener(this);
		
		window.add(panel);
		window.pack();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		
		timer = new Timer(tSpeed, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				b.move();
				panel.repaint();
			}
		});
		timer.start();
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		mx = e.getX();
		my = e.getY();
		if (button.contains(mx, my)) {			
			b.c = new Color((int)(Math.random()*256), (int)(Math.random()*256), (int)(Math.random()*256));
			panel.repaint();
		}
	}
	
	@Override
	public void mouseMoved(MouseEvent e) {
		mx = e.getX();
		my = e.getY();
		
		if (b.contains(mx, my)) {
			timer.stop();
			JOptionPane.showMessageDialog(null, "GAME OVER");
			window.dispose();
		}
		
	}
	
	public void mouseDragged(MouseEvent e) {}
	
	private class DrawPanel extends JPanel {
		int panW = 600, panH = 400;
		
		DrawPanel() {
			this.setPreferredSize(new Dimension(panW, panH));
			this.setBackground(Color.black);
		}
		
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D)g;
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			
			g2.setPaint(b.c);
			g2.fillOval(b.x,  b.y,  b.width,  b.height);
			
			g2.setPaint(Color.gray);
			g2.fillRect(button.x,  button.y,  button.width,  button.height);
			g2.setPaint(Color.white);
			g2.drawRect(button.x,  button.y,  button.width,  button.height);
			g2.setFont(new Font("Arial", Font.PLAIN, 15));
			g2.drawString("Click Me", 20, 40);
		}
	}
	
	class Ball extends Rectangle{
		Color c;
		double xx, yy;
		double vx = 4.0, vy = 2.5;
		
		Ball() {
			x = (int)(Math.random()*panel.panW/2);
			y = (int)(Math.random()*panel.panH/2);
			xx = (double)x;
			yy = (double)y;
			width = 50;
			height = 50;
			c = new Color((int)(Math.random()*256), (int)(Math.random()*256), (int)(Math.random()*256));
		}
		
		void move() {
			xx += vx;
			yy += vy;
			if (xx > panel.panW - width) {
				xx = (double)(panel.panW - width);
				vx = - vx;
			} else if (xx < 0.0) {
				xx = 0.0;
				vx = -vx;
			}
			if (yy > panel.panH - height) {
				yy = (double)(panel.panH - height);
				vy = - vy;
			} else if (yy < 0.0) {
				yy = 0.0;
				vy = -vy;
			}
			x = (int)xx;
			y = (int)yy;
		}
	}

}
