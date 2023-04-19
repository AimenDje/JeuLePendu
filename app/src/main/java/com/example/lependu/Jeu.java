package com.example.lependu;

import java.util.ArrayList;
import java.util.Random;

public class Jeu {

    private int pointage ;
    private int nbErreurs;
    private String motAdeviner;

    public Jeu(ArrayList<String> mots) throws IllegalArgumentException {
        Random random = new Random();
        int indexMotAleatoire = random.nextInt(mots.size()) ;

        if(mots.isEmpty()){
            throw new IllegalArgumentException("Liste des mots Vide!");
        }
        pointage = 0;
        nbErreurs = 0;
        motAdeviner = mots.get(indexMotAleatoire).toUpperCase();
    }

    public ArrayList<Integer> essayerUneLettre(char lettre){
        ArrayList<Integer> listIndex = new ArrayList<Integer>();

        boolean lettreTrouvee = false;
        for(int i = 0; i<motAdeviner.length();i++){
            if(motAdeviner.charAt(i) == lettre){
                listIndex.add(i) ;
                lettreTrouvee = true;
                pointage = pointage +1;
            }

        }
        if(!lettreTrouvee){
            nbErreurs = pointage + 1;
        }
        return listIndex;

    }

    public void setMotAdeviner(String motAdeviner) {
        this.motAdeviner = motAdeviner;
    }

    /*public void setPointage(int pointage) {
        //this.pointage = pointage;
    }*/

   /* public void setNbErreurs(int nbErreurs) {
        this.nbErreurs = nbErreurs;
    }*/

    public String getMotADeviner() {
        return motAdeviner ;
    }

    public int getPointage() {
        return pointage;
    }

    public int getNbErreurs() {
        return nbErreurs;
    }

    public boolean estReussi(String mot){
        boolean retour = false;
        if(mot.length() == pointage){
            retour = true;
        }
        return retour;
    }
}
