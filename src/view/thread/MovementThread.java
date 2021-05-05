package view.thread;

import exception.ThreadException;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MovementThread extends Thread{
    private PaneThread pane;
    public MovementThread(PaneThread pane) {
        super("MouvementThread");
        this.pane = pane;
    }
    @Override
    public void run(){
        while(true){
            try{
                Thread.sleep(10);
                    pane.move();
                pane.repaint();
            } catch (ThreadException | InterruptedException e) {
                try {
                    throw new ThreadException();
                } catch (ThreadException threadException) {
                    JOptionPane.showMessageDialog(null,threadException.getMessage(), "QueryException",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        }
    }

}
