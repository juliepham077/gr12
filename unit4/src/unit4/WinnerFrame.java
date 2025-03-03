package unit4;
/*
 * Julie Pham
 * Dec 15, 2023
 * Winner Frame for Dot Game
 */
import javax.swing.*;
import java.awt.*;

public class WinnerFrame {
	 JFrame introFrame;
	    JPanel panel;
	    Image img = null;
	    DrawPanel pan;

	    WinnerFrame() {
	        introFrame = new JFrame("You Win!!!!!!");
	        introFrame.setSize(500, 520);
	        introFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        //Create panel
	        panel = new JPanel();
	        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
	        panel.setPreferredSize(new Dimension(500, 520));
	        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
	        //DrawPanel for image
	        pan = new DrawPanel();
	        //Title
	        Font font = new Font("Arial", Font.BOLD, 24);
	        JLabel label = new JLabel("WOOHOOOOOOO!!!!!");
	        label.setFont(font);
	        label.setAlignmentX(Component.CENTER_ALIGNMENT);
	        panel.add(label);
	        //Image
	        img = loadImage("/win.jpg");
	        panel.add(pan);

	        introFrame.add(panel);
	        introFrame.setLocationRelativeTo(null);
	        introFrame.setVisible(true);
	    }

	    Image loadImage(String filename) {
	        Image image = null;
	        java.net.URL imageURL = this.getClass().getResource(filename);
	        if (imageURL != null) {
	            ImageIcon icon = new ImageIcon(imageURL);
	            image = icon.getImage();
	        } else {
	            JOptionPane.showMessageDialog(null, "An image failed to load: " + filename, "ERROR", JOptionPane.ERROR_MESSAGE);
	        }
	        return image;
	    }

	    private class DrawPanel extends JPanel {
	        DrawPanel() {}
	        @Override
	        public void paintComponent(Graphics g) {
	            g.drawImage(img, 20, 20, panel.getWidth()-60, 400, null);
	        }
	    }
}

