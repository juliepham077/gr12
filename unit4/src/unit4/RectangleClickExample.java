package unit4;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RectangleClickExample extends JFrame {

    private Rectangle rectangle;

    public RectangleClickExample() {
        setTitle("Rectangle Click Example");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a rectangle with initial position and size
        rectangle = new Rectangle(100, 100, 100, 50);

        // Add a mouse listener to the frame
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Check if the mouse click is inside the rectangle
                if (rectangle.contains(e.getPoint())) {
                    showMessage("Mouse clicked inside the rectangle!");
                }
            }
        });
    }

    private void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        // Draw the rectangle on the frame
        g.drawRect(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                RectangleClickExample example = new RectangleClickExample();
                example.setVisible(true);
            }
        });
    }
}
