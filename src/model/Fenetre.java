package model;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GradientPaint;
import java.awt.Color;

public class Fenetre extends JButton {



    public void startButton(Graphics graphic) {
        Graphics2D graphic2D = (Graphics2D)graphic;
        GradientPaint gp = new GradientPaint(0,0, Color.blue, 0, 20, Color.cyan,true);
        graphic2D.setPaint(gp);
        graphic.fillRect(0,0, getWidth(), getHeight());
    }

    public static void initMenu(){




        JFrame frame = new JFrame();
        frame.setTitle("Welcome!");
        frame.setSize(600, 600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton start = new JButton("Start");
        start.setToolTipText("Click to use library");

        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
    }
    
}
