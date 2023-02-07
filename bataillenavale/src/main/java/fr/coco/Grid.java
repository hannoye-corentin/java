package fr.coco;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import fr.coco.Game.GAME_STATUS;

public class Grid {

    private static final String ERR_MSG_INVALID = "Coordonnées invalides. Veuillez réessayer.";

    // private List<int[]> boatsLocations = new ArrayList<int[]>();
    // private List<int[]> enemyShoots = new ArrayList<int[]>();

    private int[][] boatsLocations = {};
    private int[][] enemyShoots = {};

    private int deadBoats = 0;

    public void displayGrid() {

        this.deadBoats = 0;

        System.out.println();

        for(int r = 0; r <= Game.GRID_MAX_CASES + 1; r++) {

            if(r == 0) {
                System.out.print(" ");
            } else {
                System.out.print((r - 1) + " ");
            }
            
            for(int c = 0; c <= Game.GRID_MAX_CASES; c++) {

                if(r == 0) {
                    
                    System.out.print(" " + c);

                } else {

                    int[] _case = {r - 1, c};

                    if(Game.G_STATUS == GAME_STATUS.PRE_MATCH) {

                        if(listContainsItem(this.boatsLocations, _case)) {

                            System.out.print("@ ");

                        } else {

                            System.out.print("- ");

                        }

                    } else if(Game.G_STATUS == GAME_STATUS.IN_MATCH || Game.G_STATUS == GAME_STATUS.AFTER_MATCH) {

                        if(listContainsItem(this.boatsLocations, _case) && listContainsItem(this.enemyShoots, _case)) {

                            System.out.print("X ");
                            this.deadBoats++;

                        } else if(listContainsItem(this.enemyShoots, _case)) {

                            System.out.print("O ");

                        } else if(listContainsItem(this.boatsLocations, _case) && Game.G_STATUS == GAME_STATUS.AFTER_MATCH) {

                            System.out.print("@ ");

                        } else {

                            System.out.print("- ");

                        }

                    }

                }

            }
            System.out.println();

        }
        System.out.println();

    }

    private static boolean listContainsItem(int[][] list, int[] _case) {

        List<int[]> _list = Arrays.asList(list);

        for (int[] item : _list) {

            if(Arrays.equals(item, _case)) {
                return true;
            }

        }
        return false;

    }

    private static boolean listAddItem(int[][] list, int[] _case) {

        List<int[]> _list = new ArrayList<int[]>(Arrays.asList(list));

        if(_list.add(_case)) {

            list = _list.toArray(list);

            return true;

        }
        return false;

    }

    public boolean addBoat(String location) {

        int[] _case = checkCoordinateFormat(location);

        if(_case != null) {

            if(!listContainsItem(this.boatsLocations, _case)) {

                listAddItem(this.boatsLocations, _case);

                return true;

            } else {

                System.out.println("Vous avez déjà un navire à cet endroit. Veuillez réessayer.");

            }

        }
        return false;

    }

    public boolean addShoot(Player attacker, Player defender, String location) {

        int[] _case = checkCoordinateFormat(location);

        if(_case != null) {

            Grid dGrid = defender.getGrid();

            if(!listContainsItem(dGrid.enemyShoots, _case)) {

                if(listContainsItem(dGrid.boatsLocations, _case)) {

                    System.out.println(attacker.getName() + " A COULÉ UN NAVIRE DU " + defender.getName() + " !");

                } else {

                    System.out.println(attacker.getName() + " COUP DANS L'EAU !");

                }

                listAddItem(dGrid.enemyShoots, _case);
                dGrid.displayGrid();

                return true;
    
            } else {

                System.out.println("Vous avez déjà ciblé cet endroit. Choisissez des coordonnées différentes.");

            }

        }
        return false;

    }
    
    private static int[] checkCoordinateFormat(String location) {

        if(location.trim().matches(String.format("^[0-%s] [0-%s]$", Game.GRID_MAX_CASES, Game.GRID_MAX_CASES))) {

            String[] _case = location.trim().split(" ");

            return new int[] {Integer.parseInt(_case[0]), Integer.parseInt(_case[1])};

        } else {

            System.out.println(ERR_MSG_INVALID);

        }
        return null;

    }

    public int getNumberDeadBoats() {
        return this.deadBoats;
    }

}
