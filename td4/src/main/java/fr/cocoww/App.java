package fr.cocoww;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        final int MAX_JUSTEPRIX = 100;

        Scanner scanner = new Scanner(System.in);
        Random rdm = new Random();

        final int maxGames = 10_000;
        double currentGame = 0;

        double totalTry = 0;

        while(currentGame != maxGames) {

            currentGame++;

            int justePrix = (rdm.nextInt(MAX_JUSTEPRIX) + 1);
            int userPrix = 0;

            List<Number> alreadyUsedPrix = new ArrayList<Number>();

            while(userPrix != justePrix) {

                if(userPrix == 0) {
                    // 1er essai
                    userPrix = (rdm.nextInt(MAX_JUSTEPRIX) + 1);
                } else {
                    if(justePrix <= (MAX_JUSTEPRIX / 2)) {
                        if(justePrix < (MAX_JUSTEPRIX / 2 / 2)) {
                            // 1-25
                            userPrix = (rdm.nextInt(MAX_JUSTEPRIX / 2 / 2) + 1);
                        } else {
                            // 25-50
                            userPrix = (rdm.nextInt(
                                (MAX_JUSTEPRIX / 2) -
                                (MAX_JUSTEPRIX / 2 / 2) + 1) +
                                (MAX_JUSTEPRIX / 2 / 2)
                            );
                        }
                    } else if(justePrix >= (MAX_JUSTEPRIX / 2)) {
                        if(justePrix > (MAX_JUSTEPRIX / 2) + (MAX_JUSTEPRIX / 2 / 2)) {
                            // 75-100
                            userPrix = (rdm.nextInt(
                                MAX_JUSTEPRIX -
                                ((MAX_JUSTEPRIX / 2) + (MAX_JUSTEPRIX / 2 / 2)) + 1) +
                                ((MAX_JUSTEPRIX / 2) + (MAX_JUSTEPRIX / 2 / 2))
                            );

                        } else {
                            // 50-75
                            userPrix = (rdm.nextInt(
                                (MAX_JUSTEPRIX / 2) + (MAX_JUSTEPRIX / 2 / 2) -
                                (MAX_JUSTEPRIX / 2) + 1) +
                                (MAX_JUSTEPRIX / 2)
                            );

                        }

                    }

                }
                if(alreadyUsedPrix.contains(userPrix)) {
                    continue;
                }
                alreadyUsedPrix.add(userPrix);
                totalTry++;

            }

        }
        scanner.close();
        System.out.println("En moyenne, sur " + maxGames + " parties, il m'a fallut " + (totalTry / maxGames) + " tentatives");
        
    }
    
}
