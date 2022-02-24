package utils;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import model.Plateau;
import model.Pion;

public class ListenerPion implements MouseListener {
     
    Plateau plateau;
    Pion pion;

    public ListenerPion(Pion pion, Plateau plateau) {
        this.pion = pion;
        this.plateau = plateau;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        try {
            plateau.movePosibility(pion);
        } catch (IOException e1) {
            e1.printStackTrace();
        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }
    
}
