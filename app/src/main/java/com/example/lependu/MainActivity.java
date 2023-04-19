package com.example.lependu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    String affichage = "";
    TextView score, mot;
    ImageView img;
    Button a;
    Jeu jeu1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            init();
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e);
        }
    }

    public void init () throws IllegalArgumentException {

        score = findViewById(R.id.score);
        mot = findViewById(R.id.mot);
        img = findViewById(R.id.img);
        a = findViewById(R.id.a);
        //a.setClickable(false);
        //a.setBackgroundColor();

        //déclaration d'un nouveau jeu
        ArrayList<String> listMots = new ArrayList<>();
        listMots.add("opiniatre");
        listMots.add("magie");
        listMots.add("aube");
        listMots.add("souterrein");
        listMots.add("kiosque");
        listMots.add("ornement");
        listMots.add("legende");
        listMots.add("ammoniaque");
        listMots.add("nuage");
        listMots.add("montagne");

        jeu1 = new Jeu(listMots);

        //afficher le mots a deviner avec des étoiles
        String motADeviner = jeu1.getMotADeviner();

        for(int i  = 0; i<motADeviner.length(); i++){
            affichage = affichage +"#";
        }
        mot.setText(affichage);
        //System.out.println(motADeviner);

    }


    public void lettre_OnClick (View view){

        Button btn_lettre = ((Button)view) ;
        btn_lettre.setClickable(false);
        btn_lettre.setBackgroundColor(-7829368);//Couleur grise ;
        String lettre_btn = btn_lettre.getText().toString();
        char[] tableauChaine = lettre_btn.toCharArray();
        char lettre = tableauChaine[0];
        ArrayList<Integer> listIndex = new ArrayList<>();
        listIndex = jeu1.essayerUneLettre(lettre);

        //on affiche toutes les occurrences de la lettre au bon endroit si cette dernière est contenue dans le mot caché
        if (listIndex.size() > 0){
            for (int i = 0; i<listIndex.size(); i++){
               affichage = affichage.replace(affichage.charAt(listIndex.get(i)), lettre);
            }
        }
        mot.setText(affichage);

        //on affiche le score
        score.setText(jeu1.getPointage());

        // on rafraichie l'image
        rafraichirImage(jeu1.getNbErreurs());

        //on affiche le statut (le traitement se fera au niveau de la fonction)
        afficherStatut("");


    }


    public void rafraichirImage(int nbErrreurs){

        //rafraichissement de l'image selon le nombre des erreurs
        if(nbErrreurs == 1){
            img.setImageResource(R.drawable.err01);
        }
        else if(nbErrreurs == 2){
            img.setImageResource(R.drawable.err02);
        }
        else if(nbErrreurs == 3){
            img.setImageResource(R.drawable.err03);
        }
        else if (nbErrreurs == 4) {
            img.setImageResource(R.drawable.err04);
        }
        else if (nbErrreurs == 5) {
            img.setImageResource(R.drawable.err05);
        }
        else if(nbErrreurs == 6){
            img.setImageResource(R.drawable.err06);
        }
    }


    public void afficherStatut(String message){

        //affichage d'une victoire
        if (jeu1.estReussi(jeu1.getMotADeviner()) == true){
            message =message + "Félicitation! vous avez gagné!";
            Intent i = new Intent(this, StatutActivity.class);
            i.putExtra("MESSAGE", message);
            startActivity(i);

        }

        //affichage d'une défaite
        else if(jeu1.getNbErreurs() == 6){
            message = message +"Vous avez perdu, le mot était : "+ jeu1.getMotADeviner();
            Intent i = new Intent(this, StatutActivity.class);
            i.putExtra("MESSAGE", message);
            startActivity(i);
        }

    }

    // à implémenter
    public void renitialiserJeu_onClick(View view) throws IllegalArgumentException {

            //rénitialisation du jeu
            ArrayList<String> listMots = new ArrayList<>();
            listMots.add("opiniatre");
            listMots.add("magie");
            listMots.add("aube");
            listMots.add("souterrein");
            listMots.add("kiosque");
            listMots.add("ornement");
            listMots.add("legende");
            listMots.add("ammoniaque");
            listMots.add("nuage");
            listMots.add("montagne");
            jeu1 =new Jeu(listMots);

            //rénitialisation de l'image
            img.setImageResource(R.drawable.acceuil);

            //rénitialisation du score
            score.setText(0);

            //rénitialisation du mot à deviner
            String motADeviner = jeu1.getMotADeviner();

            for(int i  = 0; i<motADeviner.length(); i++){
                affichage = affichage +"#";
                }
            mot.setText(affichage);
    }
}