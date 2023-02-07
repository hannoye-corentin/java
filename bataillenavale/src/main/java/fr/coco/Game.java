package fr.coco;

public class Game {

    public enum GAME_STATUS {
        PRE_MATCH, IN_MATCH, AFTER_MATCH
    }

    public static GAME_STATUS G_STATUS = GAME_STATUS.PRE_MATCH;

    public static final int GRID_MAX_CASES = 4;

    private final String WELCOME_MSG = "\nBienvenue dans Guerre Marine !\n";

    public static int nbBoatPerPlayer = 5;

    private Player player1;
    private Player player2;

    public void start() {

        System.out.println(this.WELCOME_MSG);

        this.player1 = new Player("JOUEUR 1").startLocation();
        this.player2 = new Player("JOUEUR 2").startLocation();

        Player attacker = this.player1;
        Player defender = this.player2;
        Player _defender;

        G_STATUS = GAME_STATUS.IN_MATCH;

        while(this.player1.getGrid().getNumberDeadBoats() != nbBoatPerPlayer && this.player2.getGrid().getNumberDeadBoats() != nbBoatPerPlayer) {

            if(attacker.shoot(defender)) {

                if(this.player1.getGrid().getNumberDeadBoats() == nbBoatPerPlayer || this.player2.getGrid().getNumberDeadBoats() == nbBoatPerPlayer) {
                    break;
                }

                _defender = attacker;
                attacker = (attacker == this.player1 ? this.player2 : this.player1);
                defender = _defender;

            }

        }

        G_STATUS = GAME_STATUS.AFTER_MATCH;

        System.out.println("Grilles finales :\n");
        attacker.displayStatistics();
        defender.displayStatistics();

        System.out.println(attacker.getName() + " remporte la partie ! " + (nbBoatPerPlayer - attacker.getGrid().getNumberDeadBoats()) + " DE VOS NAVIRES SONT ENCORE À FLÔT");

    }

}
