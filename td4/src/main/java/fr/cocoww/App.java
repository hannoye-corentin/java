package fr.cocoww;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class App {

    public static void main(String[] args) {

        final int MAX_JUSTEPRIX = 100;
        final int MAX_GAMES = 10_000;

        int currentGame = 0;
        double totalTry = 0;

        while(currentGame != MAX_GAMES) {

            currentGame++;

            int justPrice = generatePrice(0, MAX_JUSTEPRIX);
            int userPrice = 0;

            // Liste des prix utilisés par la machine lors d'une partie (pour éviter les doublons)
            List<Number> userPrices = new ArrayList<Number>();

            int min = 1;
            int max = MAX_JUSTEPRIX;

            while(userPrice != justPrice) {
                    
                userPrice = generatePrice(min, max);

                int halfMax = max / 2;

                if(userPrice < justPrice) {
                    min = userPrice + 1;
                } else {
                    max = userPrice - 1;
                }

                // Prix déjà tenté || Prix hors rangée logique
                if(!userPrices.contains(userPrice)) {
                    
                    // Ajout du prix tenté dans une liste && incrémentation du total d'essais
                    userPrices.add(userPrice);
                    totalTry++;

                }

            }

        }
        System.out.println("\nEn moyenne, sur " + MAX_GAMES + " parties, il m'a fallu " + (totalTry / MAX_GAMES) + " tentatives");
        
    }

    public static int generatePrice(int min, int max) {

        Random rdm = new Random();

        int newPrice = (min == 0 ? (rdm.nextInt(max) + 1) : (rdm.nextInt(max - min + 1) + min));

        return newPrice;

    }
    
}
