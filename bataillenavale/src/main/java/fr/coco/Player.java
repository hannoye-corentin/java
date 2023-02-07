package fr.coco;

import java.util.Scanner;

public class Player {

    private static final Scanner scanner = new Scanner(System.in);

    private String name;
    private Grid grid;

    public Player(String name) {

        this.name = name;
        this.grid = new Grid();

    }

    public Player startLocation() {

        System.out.println(this.name + ", entrez les coordonnées de vos navires, sous la forme 'L C'");
        System.out.println("(L représente la ligne entre 0 et " + String.valueOf(Game.GRID_MAX_CASES) + " et C la colonne entre 0 et " + String.valueOf(Game.GRID_MAX_CASES) + ").");

        int i = 1;

        while(i <= Game.nbBoatPerPlayer) {

            System.out.print("Entrez les coordonnées du navire " + i + " : ");

            String location = scanner.nextLine();

            if(this.grid.addBoat(location)) {
                i++;
            }

        }
        this.grid.displayGrid();

        for(int l = 1; l <= 100; l++) {
            System.out.println();
        }

        return this;

    }

    public String getName() {
        return this.name;
    }

    public Grid getGrid() {
        return this.grid;
    }

    public boolean shoot(Player defender) {

        System.out.print(this.name + ", entrez les coordonnées de votre tir : ");

        String shoot = scanner.nextLine();

        return this.grid.addShoot(this, defender, shoot);

    }

    public void displayStatistics() {

        System.out.println(this.getName());
        this.getGrid().displayGrid();

    }

}
