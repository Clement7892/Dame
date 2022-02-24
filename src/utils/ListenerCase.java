package utils;

import java.awt.event.MouseListener;
import java.io.IOException;
import java.awt.event.MouseEvent;

import model.*;

public class ListenerCase implements MouseListener {
    
    Case caseColor;
    Plateau grill;

    public ListenerCase(Case case1, Plateau plateau) {
        super();
        this.caseColor = case1;
        this.grill = plateau;
    } 

    @Override
    public void mouseClicked(MouseEvent e) {
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(caseColor.isSelectionne()){
            grill.mouvementPion(caseColor);
            
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
