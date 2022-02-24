package model;

import java.awt.Color;
//import java.awt.GradientPaint;
//import java.awt.Graphics;
//import java.awt.Graphics2D;
//import java.awt.Paint;
import javax.swing.JPanel;

public class Pion extends JPanel {
    //private static final long serialVersionUID = 5162710183389028792L;
    private Case.ColorCase color;
    private boolean mouvement;
    //private Plateau plateau;


    public Pion(Case.ColorCase color, boolean mouvement) {
        this.mouvement = mouvement;
        this.color = color;
        switch(color) {
        case white :
            setForeground(Color.red);
            setBackground(new Color(255, 0, 0));
            break;
        case black :
            setForeground(Color.blue);
            setBackground(new Color(0, 0, 255));
            break;
            default:
        break;
        }
    }

    
    // public void printPion(Graphics graphic) {
    //     Paint paint;
	// 	Graphics2D g2d;
	// 	if (graphic instanceof Graphics2D) {
	// 		g2d = (Graphics2D) graphic;
	// 	}
	// 	else {
	// 		System.out.println("Error");
	// 		return;
	// 	}
	// 	paint = new GradientPaint(0,0, getBackground(), getWidth(), getHeight(), getForeground());
	// 	g2d.setPaint(paint);
	// 	graphic.fillOval(5, 5, getWidth()-10, getHeight()-10);
    // }

    public Case.ColorCase getColorPion() {
        return color;
    }

    public boolean isMouvement() {
        return mouvement;
    }

    public void setMouvement(boolean mouvement) {
        this.mouvement = mouvement;
    }
    
}
