package main;

import javax.annotation.processing.Filer;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import model.Plateau;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {  
    
        JFrame frame = new JFrame("Jeu de Dames");
        JButton buttonStart = new JButton("Start Game");
        buttonStart.setBounds(0,0,200,200);
        buttonStart.addActionListener(new ActionListener() {                    
            @Override
            public void actionPerformed(ActionEvent e) { 
                frame.remove(buttonStart);
                frame.setSize(600, 600);                 
                frame.add(new Plateau(9));
                frame.setVisible(true);
            }
        });
        frame.add(buttonStart); 
        frame.setSize(200, 200);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }


}