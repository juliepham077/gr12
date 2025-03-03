package unit4;
/*
 * Julie Pham
 * Dec 15, 2023
 * Dot Game
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//test
public class Assignment6 extends MouseAdapter implements ActionListener{
	JFrame frame;
	JPanel panel;
	DrawPanel pan;
	Dot[][] grid; //array of all dots
	Dot[] order = new Dot[6]; //array of dots that light up
	JButton start;
	Timer shine; //light up dot
	ActionListener light; //light up specific dots
	int count = 3;
	int x, y;
	int r = 100;
	int n, a, b, s = 0;
	int click = 0, mx, my;
	boolean right = false;
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new IntroFrame();
			}
		});
	}//end main()
	
	Assignment6() {
		//Set up frame
		frame = new JFrame("Assignment 6");
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addMouseListener(this);
		frame.addMouseMotionListener(this);

		//Set up the panel
		panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
		panel.setPreferredSize(new Dimension(500, 560));

		grid = new Dot[3][3];
		for (int i = 0; i < 3; i ++) {
			y=150*i + 50;
			for (int j = 0; j < 3; j ++) {
				x=150*j + 50;
				grid[i][j] = new Dot(x, y, r);
			}
		}
		
		//Create DrawPanel
		pan = new DrawPanel();
		panel.add(pan); 
		
		//Start button
		start = new JButton("start");
		start.setActionCommand("start");
		start.addActionListener(this);
		panel.add(start);
		
		//Pack and display the window
		frame.add(panel);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		//Light up specific dots
		light = new ActionListener() {
			@Override
		    public void actionPerformed(ActionEvent e) {
		        if (right) {
		            reset();
		            panel.repaint();
		            shine.restart();
		        } else if (n == count) {
		            shine.stop();
		            reset();
		            panel.repaint();
		        } else if (n != count) {
		            a = (int)(Math.random() * 3);
		            b = (int)(Math.random() * 3);
		            check();		            
		            if (order[n] != null) {
		                order[n].lightUp();
		            } else if (order[n] == null) {
		                order[n] = grid[a][b];
		                grid[a][b].lightUp();
		            }

		            panel.repaint();
		            n++;
		        }
		    }
		};
	
		shine = new Timer(200, light); //light up dot one by one
		shine.setInitialDelay(500);
		
	}
	/**
	 * checks if dot is already lit and generates a new dot to light up if exists
	*/
	public void check() {
		while (grid[a][b].color == Color.CYAN) {
			a = (int)(Math.random()*3);
			b = (int)(Math.random()*3);
		}
	}
	/**
	 * Reset dots to be gray again
	 */
	public void reset() {
		for (int i = 0; i < 3; i ++) {
			for (int j = 0; j < 3; j ++) {
				grid[i][j].lightDown();
			}
		}
		n=0;
		click = 0;
		right = false;
	}	
	/**
	 * for start button
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "start" && s==0) {
			n=0;
			shine.start(); //start the lighting up
			s++;
		}
		else if (e.getActionCommand() == "start" && s!=0) {//handles if user clicks start again (do not restart light up)
			JOptionPane.showMessageDialog(null, "Please click on the dots in the order that they light up.");
		}
	}
	/**
	 * check if mouse click is in dot
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
	    mx = e.getX();
	    my = e.getY();
	    if (order[click].contains(mx, my)) { //if mouse is in the right dot
	        order[click].lightUp();
	        panel.repaint();
	        click++;
		    if (click==count) {
		    	if (click==6) {
		    		new WinnerFrame();
			        frame.dispose();
		    	}
		    	count++;
		    	right = true;
		    	shine.restart();
		    }
	    }
		else { //if mouse not in right dot
	    	for (int i = 0; i < 3; i ++) {
				for (int j = 0; j < 3; j ++) {
					if (grid[i][j].contains(mx, my)) {//if mouse is in a dot
						order[click].wrong();
				        panel.repaint();
				        JOptionPane.showMessageDialog(null, "WRONG! GAME OVER");
				        frame.dispose();
					}
				}
			}
	    }
	}
	
	//Draws graphics
	class DrawPanel extends JPanel {
		int panW, panH;
		
		DrawPanel(){
			panW = 500;
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
			g2d.setBackground(Color.BLACK);
			for (int i = 0; i < 3; i ++) {
				for (int j = 0; j < 3; j ++) {
					g2d.setPaint(grid[i][j].color);
					g2d.fillOval(grid[i][j].x, grid[i][j].y, grid[i][j].width, grid[i][j].height);
				}
			}
			this.setPreferredSize(new Dimension(panW, panH));
		}
	}
	
	class Dot extends Rectangle {
	    int r; // radius
	    Color color;

	    Dot(int x, int y, int r) {
	        this.x = x;
	        this.y = y;
	        this.width = r;
	        this.height = r;
	        this.color = Color.gray;
	    }

	    void lightUp() {
	        color = Color.cyan;
	    }

	    void lightDown() {
	        color = Color.gray;
	    }

	    void wrong() {
	        color = Color.RED;
	    }
	}
}

