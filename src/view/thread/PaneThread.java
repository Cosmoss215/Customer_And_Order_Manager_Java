package view.thread;

import exception.ThreadException;

//import ressource.*;
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
    private int boxPos;
    private int direction = 1;

    public PaneThread() throws ThreadException {
        try {
            box = ImageIO.read(new File("src/resource/boxB.png"));
            box2 = ImageIO.read(new File("src/resource/boxB2.png"));
            currentBox = box;
            MovementThread thread = new MovementThread(this);
            thread.start();
        } catch (IOException ex) {
            throw new ThreadException();
        }
    }

    public void move() throws ThreadException {
        try {
            box = ImageIO.read(new File("src/resource/boxB.png"));
            box2 = ImageIO.read(new File("src/resource/boxB2.png"));

            boxPos += direction;
            if (boxPos + currentBox.getWidth() > getWidth()) {
                boxPos = getWidth() - currentBox.getWidth();
                direction *= -1;
                currentBox = box2;
            } else if (boxPos < 0) {
                boxPos = 0;
                direction *= -1;
                currentBox = box;
            }
            repaint();
        } catch (IOException ioException) {
                throw new ThreadException();
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

