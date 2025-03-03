package unit4;
import java.awt.*;
import javax.swing.*;
import java.util.Random;
public class DrawingPractice extends JPanel{

	public static void main(String[] args) {
		JFrame window = new JFrame();
		window.setSize(500,500);
		window.setLocationRelativeTo(null);
		
		DrawingPractice panel = new DrawingPractice();
		window.add(panel);
		window.setVisible(true);
	}
	
	DrawingPractice (){ }
		
	@Override
	public void paintComponent(Graphics gc) {
		super.paintComponent(gc);
		Random rand = new Random();
		Color c1 = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
		Color c2 = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
		Color c3 = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
		Color c4 = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
		Color c5 = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
		Color c6 = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
		
		//Set the color and draw an oval
		gc.setColor(c1);
		gc.fillOval(0, 0, 20, 40);
		
		gc.setColor(c2);
		gc.fillOval(50, 50, 20, 40);
		
		gc.setColor(c3);
		gc.fillOval(100, 100, 20, 40);
		
		gc.setColor(c4);
		gc.fillOval(150, 150, 20, 40);
		
		gc.setColor(c5);
		gc.fillOval(0, 150, 20, 40);
		
		gc.setColor(c6);
		gc.fillOval(200, 0, 20, 40);
		
	}
	

}
