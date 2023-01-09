package fr.coco;

public class Game {

    private static String welcomeMsg = "\nBienvenue dans Guerre Marine !\n";
    private static Player player1;
    private static Player player2;
    
    public void start() {

        System.out.println(welcomeMsg);

        player1 = new Player("J1");
        player2 = new Player("J2");

        player1.startLocation();

    }

}
