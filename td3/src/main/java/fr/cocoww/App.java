package fr.cocoww;

import java.util.Random;

public class App {
    
    public static void main(String[] args) {

        int total = 0;
        int nbrEssais = 5;

        Random generateur = new Random();

        for(int i = 0; i < nbrEssais; i++) {

            int lancer = (generateur.nextInt(6) + 1);

            total += lancer;

        }
        System.out.println(total == 20 ? "Vous avez gagné !" : "Perdu ! ");

    }
    
}
