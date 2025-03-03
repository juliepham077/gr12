package unit4;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

public class CatchGame implements KeyListener{
	JFrame window;
	Rectangle player;
	ArrayList<Ball> balls;
	DrawPanel pan;
	Timer timer;
	int tSpeed = 10, ballCount = 0;
	int strikes, score;
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new CatchGame();
			}
		});
	}//end main()
	
	CatchGame(){
		window = new JFrame();
		window.setTitle("Catch Game!");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.addKeyListener(this);
		window.addMouseMotionListener(new MouseAdapter() {
			public void mouseMoved(MouseEvent e) {
				int mx = e.getX();
				if (mx > pan.panW - player.width) player.x = pan.panW - player.width;
				else if (mx < 0) player.x = 0;
				else player.x = mx;
				pan.repaint();
			}
		});
		pan = new DrawPanel();
		
		player = new Rectangle(pan.panW/2, pan.panH - 50, 30, 40);
		balls = new ArrayList<Ball>();
		balls.add(new Ball());
		strikes = 0;
		score = 0;
		
		window.add(pan);
		
		window.pack();
		window.setVisible(true);
		
		timer = new Timer(tSpeed, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ballCount++;
				if (ballCount%50 == 0) balls.add(new Ball());
	
				for (Ball b: balls) {
					if (b.active) {
						b.move();
						
						if (player.intersects(b)) {
							score += 10;
							b.active = false;
						}
					}
				}
				
				pan.repaint();
				if (strikes == 3) {
					timer.stop();
					JOptionPane.showMessageDialog(null, "GAME OVER");
					window.dispose();
				}				
			}
		});
		timer.start();
	}//end constructor
	
	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_LEFT) player.x -= 40;			
		else if (key == KeyEvent.VK_RIGHT) player.x += 40;
			
		if (player.x < 0) player.x = 0;
		else if (player.x + player.width > pan.panW) player.x = pan.panW - player.width;
	}
	
	public void keyReleased(KeyEvent e) {}
	public void keyTyped(KeyEvent e) {}
	
	class DrawPanel extends JPanel{
		int panW, panH;
		DrawPanel(){
			panW = 800;
			panH = 600;
			this.setPreferredSize(new Dimension(panW, panH));
			this.setBackground(Color.black);
		}
		
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D)g;
			g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			
			g2.setPaint(Color.white);
			g2.setFont(new Font("Comic Sans", Font.BOLD, 50));
			String showScore = String.format("SCORE: %d", score);
			g2.drawString(showScore, 300, 80);
			
			g2.setPaint(Color.blue.brighter());
			g2.fillRect(player.x,  player.y,  player.width,  player.height);
			
			g2.setPaint(Color.yellow.darker());
			for (Ball b: balls) {
				if(b.active) g2.fillOval(b.x,  b.y,  b.width,  b.height);
			}
		}
	}
	
	public class Ball extends Rectangle{
		double speed;
		boolean active;
		Ball() {
			x = (int)(Math.random()*pan.panW/2) + 100;
			y = -height;
			height = 30;
			width = 20;
			speed = Math.random()*3.0 + 1.0;
			active = true;
		}
		
		/**
		 * Move a ball
		 */
		void move() {
			double yy = (double)y;
			if (active) yy += speed;
			//Deactivate any balls that reach the bottom of the screen
			if (yy > (double)pan.panH) {
				this.active = false;
				strikes++;
				yy = -40;
			}
			y = (int)yy;
		}
	}

}

