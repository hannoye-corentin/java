package fr.cocoww;

import java.util.Random;

public class App {
    
    public static void main(String[] args) {

        int total = 0;
        int nbrEssais = 5;
        int nbrEssaisJeu = 0;
        String lancerDes = "";

        Random generateur = new Random();

        while(true) {

            nbrEssaisJeu++;

            total = 0;
            lancerDes = "";

            for(int i = 0; i < nbrEssais; i++) {

                int lancer = (generateur.nextInt(6) + 1);

                total += lancer;

                lancerDes += (i == 4 ? lancer : lancer + ", ");

            }
            if(total == 20) {
                break;
            } else {
                System.out.println("Vous avez perdu... (" + total + ")");
            }

        }
        System.out.println("Vous avez gagné ! (en " + nbrEssaisJeu + " partie" + (nbrEssaisJeu > 1 ? "s" : "") + "), vos chiffres : " + lancerDes);

    }
    
}
