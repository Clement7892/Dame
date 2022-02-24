package model;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Paint;

import javax.swing.JPanel;

//import utils.ListenerCase;


public class Case extends JPanel{
    //private static final long serialVersionUID = 5162710183389028792L;
    
    public enum ColorCase {
        white,
        blue,
        red,
        black;
    }
    
    ColorCase color;
    boolean caseSelect;
    Plateau plateau;

    public ColorCase getColor(){
        return color;
    }


    
    public Case(ColorCase color) {
        setLayout(new GridLayout(1,0));
        this.color = color;
        initColorCase();
    }

    public void initColorCase() {
        switch(color) {
            case white :
                setBackground(Color.white);
                setForeground(new Color(20,20,20));
                break;
            case black :
                setBackground(Color.black);
                setForeground(new Color(20, 20, 20));
                break;
                default:
        break;
        }
    }

    // public void printColorCase(Graphics graphic) {
    //     Paint paintColor;
    //     Graphics2D graphic2D;
    //     if (graphic instanceof Graphics2D) {
    //         graphic2D = (Graphics2D) graphic;
    //     } else {
    //         System.out.println("Error");
    //         return;
    //     }
    //     paintColor = new GradientPaint(0,0, getBackground(), getWidth(), getHeight(), getForeground());
    //     graphic2D.setPaint(paintColor);
    //     graphic.fillRect(0,0, getWidth(), getHeight());
    // }
    
    public boolean isSelectionne() {
        return caseSelect;
    }

    

    public void getCaseSelect(boolean caseSelect) {
        this.caseSelect = caseSelect;
        if(caseSelect) {
            setBackground(Color.darkGray);
            setForeground(Color.DARK_GRAY);
        } else {
            initColorCase();
        }
    }
}
