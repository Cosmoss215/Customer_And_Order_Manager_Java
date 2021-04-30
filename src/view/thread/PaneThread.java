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
    private BufferedImage bonhomme;
    private BufferedImage bonhomme2;
    private BufferedImage currentBox;
    private BufferedImage currentBonhomme;
    private int boboxPos = 0;
    private int boxPos;
    private int direction = 1;

    public PaneThread() {
        try {
            box = ImageIO.read(new File("src/resource/boxB.png"));
            box2 = ImageIO.read(new File("src/resource/boxB2.png"));
            currentBox = box;
            MovementThread thread = new MovementThread(this);
            thread.start();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void move(){
        try {
            box = ImageIO.read(new File("src/resource/boxB.png"));
            box2 = ImageIO.read(new File("src/resource/boxB2.png"));

            boxPos += direction;
            if (boxPos + currentBox.getWidth() > getWidth()) {
                boxPos = getWidth() - currentBox.getWidth();
                direction *= -1;
                currentBox = box2;
                currentBonhomme = bonhomme2;
            } else if (boxPos < 0) {
                boxPos = 0;
                direction *= -1;
                currentBox = box;
                currentBonhomme = bonhomme;
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
        g.drawImage(currentBox, boxPos, y,this);

    }
}

