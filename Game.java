import javax.swing.*;
import javax.swing.event.MouseInputListener;

import java.awt.*;

public class Game {

    protected JLabel plainJButton;

    public static void main(String args[]) throws InterruptedException {
        JFrame frame = new JFrame("Race");
        final ImageIcon icon = new ImageIcon(
                "C:/WINTER 2022/COMP 2800 Software Development/HomeAssignments/Assignment 4/RaceTrack.png");

        JLabel hare = new JLabel();
        JLabel turtle = new JLabel();
        hare.setIcon(
                new ImageIcon("C:/WINTER 2022/COMP 2800 Software Development/HomeAssignments/Assignment 4/hare.png"));
        turtle.setIcon(
                new ImageIcon("C:/WINTER 2022/COMP 2800 Software Development/HomeAssignments/Assignment 4/turtle.png"));
        frame.add(hare);
        frame.add(turtle);
        int xHare = 270;
        int xTurtle = 270;
        hare.setLocation(xHare, 150);
        turtle.setLocation(xHare, 300);
        hare.setSize(98, 77);
        turtle.setSize(98, 77);

        String hareSpeed = JOptionPane.showInputDialog("Enter speed of hare:");
        int hareS = Integer.parseInt(hareSpeed);

        String turtleSpeed = JOptionPane.showInputDialog("Enter speed of turtle:");
        int turtleS = Integer.parseInt(turtleSpeed);
        JOptionPane.showMessageDialog(null,
                "If you want hare to sleep then after pressing ok, click on the track within 2 seconds.");
        int countH = hareS;
        int countT = turtleS;

        JTextArea text = new JTextArea() {
            Image img = icon.getImage();
            // instance initializer
            {
                setOpaque(false);
            }

            public void paintComponent(Graphics graphics) {
                graphics.drawImage(img, 0, 0, this);
                super.paintComponent(graphics);
            }
        };
        JScrollPane pane = new JScrollPane(text);
        Container content = frame.getContentPane();
        content.add(pane, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(3);
        frame.setSize(1500, 1000);
        frame.setVisible(true);
        Thread.sleep(2000);

        JPanel panel = new JPanel();
        frame.add(panel);
        int x = 0;
        boolean key = false;
        x = MouseInfo.getPointerInfo().getLocation().x;
        if (x < 100 || x > 1250) {
            JOptionPane.showMessageDialog(null, "You should Click on the track.");
        }
        if (x > 100 && x < 200) {
            x = 200;
            key = true;
        }
        if (x > 200 && x < 300) {
            x = 300;
            key = true;
        }
        if (x > 300 && x < 400) {
            x = 400;
            key = true;
        }
        if (x > 400 && x < 500) {
            x = 500;
            key = true;
        }
        if (x > 500 && x < 600) {
            x = 600;
            key = true;
        }
        if (x > 600 && x < 700) {
            x = 700;
            key = true;
        }
        if (x > 700 && x < 800) {
            x = 800;
            key = true;
        }
        if (x > 800 && x < 900) {
            x = 900;
            key = true;
        }
        if (x > 900 && x < 1000) {
            x = 1000;
            key = true;
        }
        if (x > 1000 && x < 900) {
            x = 1000;
            key = true;
        }
        if (x > 1100 && x < 1000) {
            x = 1100;
            key = true;
        }
        if (x > 1200 && x < 1100) {
            x = 1200;
            key = true;
        }

        while (xHare <= 1210 || xTurtle <= 1210) {
            if (xHare >= 1210) {
                JOptionPane.showMessageDialog(null, "Hare is the winner.");
                break;
            }
            if (xTurtle >= 1210) {
                JOptionPane.showMessageDialog(null, "turtle is the winner.");
                break;

            }
            if (key) {

                if (xHare >= (x - 100) && xHare <= (x + 100)) {
                    Thread.sleep(1000);
                    xTurtle = xTurtle + turtleS;
                    xTurtle = xTurtle + turtleS;
                    xTurtle = xTurtle + turtleS;
                    x = 0;

                }

            }

            countH = hareS;
            countT = turtleS;
            xHare = xHare + hareS;
            xTurtle = xTurtle + turtleS;
            Thread.sleep(hareS);
            hare.setLocation(xHare, 150);
            Thread.sleep(turtleS);
            turtle.setLocation(xTurtle, 300);

        }

    }
}

class ImagePanel extends JPanel {

    private Image img;

    public ImagePanel(String img) {
        this(new ImageIcon(img).getImage());
    }

    public ImagePanel(Image img) {
        this.img = img;
        Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        setSize(size);
        setLayout(null);
    }

    public void paintComponent(Graphics g) {
        g.drawImage(img, 0, 0, null);
    }

}
