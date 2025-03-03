package unit4;
/*
 * Julie Pham
 * Dec 15, 2023
 * Intro Frame for Dot Game
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IntroFrame {
    JFrame introFrame;
    JPanel panel;
    Image img = null;
    DrawPanel pan;

    IntroFrame() {
        introFrame = new JFrame("Intro Frame");
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
        JLabel label = new JLabel("FOLLOW THE DOTS");
        label.setFont(font);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(label);
        //image
        img = loadImage("/minion.png");
        panel.add(pan);
        //instructions
        font = new Font("Arial", Font.PLAIN, 14);
        String[] textLines = {
                "There are nine dots arranged in a 3 x 3.",
                "They will light up in a specific order.",
                "Starting with 3 dots, you have to click",
                "them in the order that they light up.",
                "A new dot will be added each time you get it right.",
                "You win when you click 6 in a row correctly.",
                "You lose if you click the wrong dot."
        };
        for (String line : textLines) {
            JLabel inst = new JLabel(line);
            inst.setFont(font);
            inst.setAlignmentX(Component.CENTER_ALIGNMENT);
            panel.add(inst);
        }

        panel.add(Box.createRigidArea(new Dimension(0,10)));
        //play button
        JButton playButton = new JButton("Play");
        playButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(playButton);

        introFrame.add(panel);
        introFrame.setLocationRelativeTo(null);
        introFrame.setVisible(true);

        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                introFrame.dispose();
                new Assignment6(); // Start the main game
            }
        });
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
            g.drawImage(img, 20, 20, panel.getWidth()-60, 230, null);
        }
    }
}
