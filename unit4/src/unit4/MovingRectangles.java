package unit4;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MovingRectangles extends JFrame implements MouseMotionListener, KeyListener{
	Rectangle rk, rm;
	DrawPanel panel;
	//Timer timer;
	//int t_speed = 10;
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new MovingRectangles();
			}
		});
	}
	
	MovingRectangles() {
		this.setTitle("Moving Rectangles");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.addKeyListener(this);
		this.addMouseMotionListener(this);
		
		rk = new Rectangle(20, 20, 100, 60);
		rm = new Rectangle(300, 300, 100, 60);
		
		panel = new DrawPanel();
		this.add(panel);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
		//timer = new Timer(t_speed)
	}
	
	public void mouseDragged(MouseEvent e) {}
	@Override
	public void mouseMoved(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		
		//Update the x of rectangle. Ensure rectangle stays within screen
		if (x > (panel.panW - rm.width)) rm.x = (panel.panW - rm.width);
		else if (x < 0) rm.x = 0;
		else rm.x = x;
		
		//Update the y of rectangle. Ensure rectangle stays within screen
		if (y > (panel.panH - rm.height)) rm.y = (panel.panH - rm.height);
		else if (y < 0) rm.y = 0;
		else rm.y = y;
		
		panel.repaint();
	}
	
	public void keyTyped(KeyEvent e) {}
	public void keyReleased(KeyEvent e) {}
	
	@Override
	public void keyPressed(KeyEvent e) {
		int direction = e.getKeyCode();
		System.out.print(direction);
		
		if (direction == KeyEvent.VK_UP) {
			rk.y -= 10;
			System.out.print("test");
		}
		else if (direction == KeyEvent.VK_DOWN) rk.y += 10;
		else if (direction == KeyEvent.VK_LEFT) rk.x -= 10;
		else if (direction == KeyEvent.VK_RIGHT) rk.x += 10;
		//Update the x of rectangle. Ensure rectangle stays within screen
		if (rk.x > (panel.panW - rk.width)) rk.x = (panel.panW - rk.width);
		else if (rk.x < 0) rk.x = 0;
				
		//Update the y of rectangle. Ensure rectangle stays within screen
		if (rk.y > (panel.panH - rk.height)) rk.y = (panel.panH - rk.height);
		else if (rk.y < 0) rk.y = 0;
		
		panel.repaint();
	}
	
	class DrawPanel extends JPanel {
		int panW, panH;
		
		DrawPanel(){
			panW = 800;
			panH = 600;
			this.setPreferredSize(new Dimension(panW, panH));
			this.setBackground(Color.DARK_GRAY);
		}
		
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D)g;
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			
			g2.setPaint(Color.BLUE);
			g2.fillRect(rk.x,  rk.y,  rk.width,  rk.height);
			
			g2.setPaint(Color.GREEN);
			g2.fillRect(rm.x,  rm.y,  rm.width,  rm.height);
		}
	}

}

