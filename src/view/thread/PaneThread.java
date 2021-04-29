package view.thread;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PaneThread extends JPanel {
    private BufferedImage box;
    private BufferedImage box2;
    private BufferedImage currentBox;
    private int xPos = 0;
    private int direction = 2;

    public PaneThread() {
        try {
            box = ImageIO.read(new File("src/resource/box.png"));
            box2 = ImageIO.read(new File("src/resource/box2.png"));
            currentBox = box;
            MovementThread thread = new MovementThread(this);
            thread.start();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void move(){
        try {
            box = ImageIO.read(new File("src/resource/box.png"));
            box2 = ImageIO.read(new File("src/resource/box2.png"));

            xPos += direction;
            if (xPos + currentBox.getWidth() > getWidth()) {
                xPos = getWidth() - currentBox.getWidth();
                direction *= -1;
                currentBox = box2;
            } else if (xPos < 0) {
                xPos = 0;
                direction *= -1;
                currentBox = box;
            }
            repaint();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
    @Override
    public Dimension getPreferredSize() {
        return box == null ? super.getPreferredSize() : new Dimension(box.getWidth() * 2, box.getHeight()*2);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int y = getHeight() - box.getHeight();
        g.drawImage(currentBox, xPos, y,this);

    }
}

