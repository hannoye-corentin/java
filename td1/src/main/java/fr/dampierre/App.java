package fr.dampierre;

import java.util.Scanner;

public class App {

    // CONSTANTES

    final static int SECONDS_IN_MINUTE = 60;
    final static int SECONDS_IN_HOUR = SECONDS_IN_MINUTE * SECONDS_IN_MINUTE;
    
    public static void main(String[] args) {

        // Algorithme permettant de calculer les secondes écoulées depuis 00:00.
        System.out.println("\n-----------------\nEx. 1\n-----------------");

        ex1Java();

        // Instanciation d'un scanner pour les exercices suivants...
        Scanner scanner = new Scanner(System.in);

        // Algorithme permettant de calculer les secondes écoulées depuis 00:00 avec entrée utilisateur.
        System.out.println("\n-----------------\nEx. 2\n-----------------");

        ex2Java(scanner);

        // Algorithme permettant de calculer les secondes avant 00:00.
        System.out.println("\n-----------------\nEx. 3\n-----------------");

        ex3Java(scanner);

        // Algorithme permettant de calculer le pourcentage du temps écoulé entre l'heure du 1er exercice et celui-ci.
        System.out.println("\n-----------------\nEx. 4\n-----------------");

        ex4Java();

        // Algorithme permettant de réaliser le jeu du juste-prix avec un seul essai, (1-100).
        System.out.println("\n-----------------\nEx. 5\n-----------------");

        ex5Java(scanner);

    }

    public static void ex1Java() {

        int hours = 12;
        int minutes = 34;
        int seconds = 56;

        int tempsEcouleDepuisMinuit = (hours * SECONDS_IN_HOUR) + (minutes * SECONDS_IN_MINUTE) + (seconds);

        System.out.println("Il est " + hours + " h " + minutes + " m " + seconds + " s.");
        System.out.println("Il s'est écoulé " + tempsEcouleDepuisMinuit + " seconds depuis minuit.");

    }

    public static void ex2Java(Scanner scanner) { // Variante de l'exercice 1 avec la saisie par l'utilisateur

        System.out.print("Veuillez saisir heure : ");
        int hours = scanner.nextInt();

        System.out.print("Veuillez saisir minute : ");
        int minutes = scanner.nextInt();

        System.out.print("Veuillez saisir seconde : ");
        int seconds = scanner.nextInt();

        int tempsEcouleDepuisMinuit = (hours * SECONDS_IN_HOUR) + (minutes * SECONDS_IN_MINUTE) + (seconds);

        System.out.println("Il est " + hours + " h " + minutes + " m " + seconds + " s.");
        System.out.println("Il s'est écoulé " + tempsEcouleDepuisMinuit + " seconds depuis minuit.");

    }

    public static void ex3Java(Scanner scanner) {

        int HOURS_IN_DAY = 24;

        System.out.print("Veuillez saisir heure : ");
        int hours = scanner.nextInt();

        System.out.print("Veuillez saisir minute : ");
        int minutes = scanner.nextInt();

        System.out.print("Veuillez saisir seconde : ");
        int seconds = scanner.nextInt();

        int tempsEcouleDepuisMinuit =  (SECONDS_IN_MINUTE * SECONDS_IN_MINUTE * HOURS_IN_DAY) - (hours * SECONDS_IN_HOUR + minutes * SECONDS_IN_MINUTE + seconds);

        System.out.println("Il est " + hours + " h " + minutes + " m " + seconds + " s.");
        System.out.println("Il y a encore " + tempsEcouleDepuisMinuit + " seconds avant minuit.");

    }

    public static void ex4Java() {

        // On soustrait le nombre de secondes de 12h34m56s au nombre de secondes de 15h27m12s

        int hoursStart = 12;
        int minutesStart = 34;
        int secondsStart = 56;

        int hours = 15;
        int minutes = 27;
        int seconds = 12;

        int tempsEntreHoraires = ((hours * SECONDS_IN_HOUR) + (minutes * SECONDS_IN_MINUTE) + (seconds)) - ((hoursStart * SECONDS_IN_HOUR) + (minutesStart * SECONDS_IN_MINUTE) + (secondsStart));

        double tempsEcoulePourcentage = (100 * tempsEntreHoraires / 86000);

        System.out.println("Depuis le 1er exercice, " + tempsEcoulePourcentage + "% du temps de la journée entière (24h) s'est écoulé.");

    }

    public static void ex5Java(Scanner scanner) {

        System.out.println("Je pense à un nombre entre 1 et 100 inclus. Devinez lequel.");

        // Math.random() nous renvoie un double entre 0.0 et 1.0 il faut donc le multiplier par le nombre de possiblités possibles en l'occurrence 100 - le min (1) + 1 + le min.

        int nbrADeviner = (int)(Math.random() * (100 - 1 + 1) + 1); // Nombre aléatoire entre 1 et 100 inclus, (int) nous permet d'avoir un entier (de caster) en retour, qui permettra aussi d'enlever la virgule car Math.random() nous renvoie un double (0.0) -> (0).

        System.out.print("Entrez un nombre : ");
        int nbrUtilisateur = scanner.nextInt(); // Optionel : Méthode hasNextInt combinée avec un while pour plus de sécurité, ici on fait confiance à l'utilisateur, aucune erreur/exeception ne sera traitée.

        System.out.println("Vous proposez : " + nbrUtilisateur);

        if(nbrUtilisateur == nbrADeviner) {

            System.out.println("Bravo le nombre était " + nbrADeviner + " !");

        } else {

            System.out.println("Le nombre auquel je pensais était : " + nbrADeviner);
            System.out.println("Vous étiez à " + Math.abs(nbrADeviner - nbrUtilisateur) + " de la bonne réponse."); // Math.abs() permet d'avoir la différence.

        }
        // PS: Si il n'y avait qu'une seule instruction par bloc, on aurait pu utiliser une condition ternaire, (x > y ? a : b).

        scanner.close(); // Pour finir on ferme le scanner (optionel)

    }
    
}
