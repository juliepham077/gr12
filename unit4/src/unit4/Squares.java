package unit4;
import java.awt.*;
import javax.swing.*;
public class Squares extends JPanel{

	public static void main(String[] args) {
		JFrame window = new JFrame();
		window.setSize(300,300);
		
		Squares panel = new Squares();
		window.add(panel);
		window.setVisible(true);
	}
	
	Squares() {}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.BLUE);
		
		//Draw 4 20x20 squares, one in each corner
		g.fillRect(0,  0,  20, 20);
		g.fillRect(280,  0,  20, 20);
		g.fillRect(280,  280,  20, 20);
		g.fillRect(0,  280,  20, 20);
		
		//Change the color to orange and draw a diamond
		g.setColor(Color.ORANGE);
		Polygon diamond = new Polygon();
		diamond.addPoint(getWidth()/2, 0);
		diamond.addPoint(getWidth(), getHeight()/2);
		diamond.addPoint(getWidth()/2, getHeight());
		diamond.addPoint(0, getHeight()/2);
		g.fillPolygon(diamond);
	}

}

