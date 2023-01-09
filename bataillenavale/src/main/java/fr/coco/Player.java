package fr.coco;

import java.util.Scanner;

public class Player {

    private String name;
    private Grid grid;
    
    public Player(String name) {

        this.name = name;
        this.grid = new Grid();

    }

    public void startLocation() {
        
        Scanner scanner = new Scanner(System.in);

        int i = 0;

        while(i <= 4) {

            System.out.print("Veuillez entrer des coordonnées pour votre navire : ligne colonne : ");

            String location = scanner.nextLine();

            String[] locations = location.split(" ");

            grid.add

            i++;

        }
        scanner.close();

    }

}
