package model;

import java.awt.GridLayout;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JPanel;

import utils.ListenerCase;
import utils.ListenerPion;

public class Plateau extends JPanel {
    private static final long serialVersionUID = -5116101128118950844L;

    public Case caseChoseIsActive;
    private static int longueur = 9;
    private static int largeur = 9;
    private boolean playerBlackTurn;
    Pion p;

    public Plateau(int size) {
        playerBlackTurn = false;
        setLayout(new GridLayout(longueur,largeur));
        for(int i = 0; i < longueur; i++) {
            for(int j = 0; j < largeur; j++) {
                if((i%2 == 0 && j%2 == 0) || (i%2 != 0 && j%2 != 0)) { 
                    addCase(Case.ColorCase.black);
                } else {
                    addCase(Case.ColorCase.white);
                }
            }
        }
        initPlateau();
    }

    public void initPlateau(){
        for(int j = 0; j < 9*3; j+=2){
            getCase(j).add(creatPionOnPlateau(Case.ColorCase.black, false));
			getCase(longueur*largeur-j-1).add(creatPionOnPlateau(Case.ColorCase.white, true));
		}
    }

    public void movePosibility(Pion p) throws IOException {
        if((p.getColorPion().equals(Case.ColorCase.black) && playerBlackTurn) || (p.getColorPion().equals(Case.ColorCase.white) && !playerBlackTurn)){
            int i = 0;
            int j = 0;
            for(int k = 0; k < longueur*largeur; k++){
                getCase(k).getCaseSelect(false);
                if(getCase(k).getComponentCount() != 0 && getCase(k).getComponent(0).equals(p)) {
                    caseChoseIsActive = getCase(k);
                    i = k / longueur;
                    j = k % largeur;
                    try (BufferedWriter sortieMouvementTxt = new BufferedWriter(new FileWriter("test.txt", true))) {
                        sortieMouvementTxt.write(p.getColorPion() + " "  + i + " " + j + "\n" );
                    }
                }
            }
            selectCasesForMoves(i, j, p.getColorPion());
        }
    }

    public Case getCase(int i, int j) {
        return (Case) getComponent(j+i * 9);
    }

    public Case getCase(int i) {
        return (Case)getComponent(i);
    }

    public void addCase(Case.ColorCase color) {
        Case caseAdded = new Case(color);
        caseAdded.addMouseListener(new ListenerCase(caseAdded, this));
        add(caseAdded);
    }

    public void selectCasesForMoves(int i, int j, Case.ColorCase color) throws IOException {
        Pion pionMouved = (Pion)(getCase(i, j).getComponent(0));
        if(pionMouved.isMouvement()){
			if(i-1>=0 && j-1>=0 && getCase(i-1, j-1).getComponentCount()==0){
				getCase(i-1, j-1).getCaseSelect(true);
			}
			else if(i-2>=0 && j-2>=0 && getCase(i-2, j-2).getComponentCount()==0 && !((Pion)(getCase(i-1, j-1).getComponent(0))).getColorPion().equals(color)){
				getCase(i-2, j-2).getCaseSelect(true);
			}
			if(i-1>=0 && j+1<longueur && getCase(i-1, j+1).getComponentCount()==0){
				getCase(i-1, j+1).getCaseSelect(true);
			}
			else if(i-2>=0 && j+2<largeur && getCase(i-2, j+2).getComponentCount()==0 && !((Pion)(getCase(i-1, j+1).getComponent(0))).getColorPion().equals(color)){
				getCase(i-2, j+2).getCaseSelect(true);
			}
            // try (BufferedWriter sortieMouvementTxt = new BufferedWriter(new FileWriter("test.txt", true))) {
            //     sortieMouvementTxt.write(pionMouved.getColorPion() + " "  + i + " " + j + "\n" );
            // }
		}
		else{
			if(i+1<longueur && j+1<longueur && getCase(i+1, j+1).getComponentCount()==0){
				getCase(i+1, j+1).getCaseSelect(true);
			}
			else if(i+2<largeur && j+2<largeur && getCase(i+2, j+2).getComponentCount()==0 && !((Pion)(getCase(i+1, j+1).getComponent(0))).getColorPion().equals(color)){
				getCase(i+2, j+2).getCaseSelect(true);
			}
			if(i+1<longueur && j-1>=0 && getCase(i+1, j-1).getComponentCount()==0){
				getCase(i+1, j-1).getCaseSelect(true);
			}
			else if(i+2<largeur && j-2>=0 && getCase(i+2, j-2).getComponentCount()==0 && !((Pion)(getCase(i+1, j-1).getComponent(0))).getColorPion().equals(color)){
				getCase(i+2, j-2).getCaseSelect(true);
			}
			// try (BufferedWriter sortieMouvementTxt = new BufferedWriter(new FileWriter("test.txt", true))) {
            //     sortieMouvementTxt.write(pionMouved.getColorPion() + " "  + i + " " + j + " " + "\n");
            // }

		}
    }

    public void mouvementPion(Case caseChose) {
        caseChose.add(caseChoseIsActive.getComponent(0));
        for(int i = 0; i<largeur*longueur; i++) {
            getCase(i).getCaseSelect(false);
        }
        
        if(Math.abs(getLignePlateau(caseChose) - getLignePlateau(caseChoseIsActive)) == 2) {
            int i = (getLignePlateau(caseChose) + getLignePlateau(caseChoseIsActive)) / 2;
            int j = (getColonnePlateau(caseChose) + getColonnePlateau(caseChoseIsActive))/2;
            getCase(i, j).removeAll();
            getCase(i, j).validate();
            getCase(i, j).repaint();
        }
        
        playerBlackTurn = !playerBlackTurn;
        caseChoseIsActive.removeAll();
        caseChoseIsActive.repaint();
        caseChoseIsActive = null;
        caseChose.repaint();
        if(getLignePlateau(caseChose) == 0) {
            Pion pion = (Pion)(caseChose.getComponent(0));
            pion.setMouvement(false);
        }
        if(getLignePlateau(caseChose) == 9 - 1 ) {
            Pion pion = (Pion)(caseChose.getComponent(0));
            pion.setMouvement(true);
        }
    }

    public int getLignePlateau(Case caseChose) {
        int i = 0;
        for(int j = 0; j < longueur*largeur; j+=2) {
            if(getCase(j).equals(caseChose)) {
                i = j/9;
            }
        }
        return i;
    }

    public int getColonnePlateau(Case caseChose) {
        int i = 0;
        for(int j = 0; j < longueur * largeur; j+=2) {
            if(getCase(j).equals(caseChose)) {
                i = j % 9;
            }
        }
        return i;
    }

    public void addCaseToPlateau(Case.ColorCase color) {
        Case caseAdded = new Case(color);
        caseAdded.addMouseListener(new ListenerCase(caseAdded, this ));
        add(caseAdded);
    }

    public Pion creatPionOnPlateau(Case.ColorCase color, boolean mouvement) {
        Pion pionAdded = new Pion(color, mouvement);
        pionAdded.addMouseListener(new ListenerPion(pionAdded, this));
        return pionAdded;
    }
}