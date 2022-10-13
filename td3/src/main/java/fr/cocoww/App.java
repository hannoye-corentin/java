package fr.cocoww;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class App {
    
    public static void main(String[] args) {

        int total = 0;
        int nbrEssais = 5;
        int nbrEssaisJeu = 0;
        List<String> lancerDes = new ArrayList<>();
        String lancerDesJoin;

        Random generateur = new Random();

        while(true) {

            nbrEssaisJeu++;

            if(total != 0) {
                total = 0;
                lancerDes.clear();
            }

            for(int i = 0; i < nbrEssais; i++) {

                int lancer = (generateur.nextInt(6) + 1);

                total += lancer;

                lancerDes.add(String.valueOf(lancer));

            }
            lancerDesJoin = String.join(", ", lancerDes);
            if(total == 20) {
                break;
            } else {
                System.out.println("\u001B[31mVous avez perdu... (" + lancerDesJoin + " = " + total + ")");
            }

        }
        System.out.println("\u001B[32mVous avez gagné ! (en " + nbrEssaisJeu + " partie" + (nbrEssaisJeu > 1 ? "s" : "") + "), vos chiffres : " + lancerDesJoin + "\u001B[0m");

    }
    
}
