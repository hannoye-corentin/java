package fr.cocoww;

import java.util.Scanner;

public class App {

    /*
        CONSIGNE EX.:

        Écrire une méthode qui demande une lettre à l'utilisateur et qui retourne la couleur correspondante. Les lettres valides sont R, V, B. Les couleurs correspondantes sont rouge, vert, bleu. L'utilisateur peut entrer la lettre en minuscule ou en majuscule. La méthode doit retourner « connais pas » si l'entrée utilisateur n'est pas valide. C'est la méthode appelante (main) qui se chargera d'effectuer l'affichage de la couleur choisie.
    */
    
    public static void main(String[] args) {

        String color = choiceColor(); // La méthode "choiceColor()" nous renvoie "quelque chose" en l'occurrence une valeur de type String, nous stockons cette valeur dans une variable pour ensuite l'afficher et la manipuler à l'avenir si nécessaire...

        if(color.equalsIgnoreCase("R")) { // String.equalsIgnoreCase() sont rôle est (comme son nom l'indique) d'évaluer la valeur tout en ignorant la casse (A == a).

            System.out.println("Vous avez choisi le rouge.");

        } else if(color.equalsIgnoreCase("V")) { // ...

            System.out.println("Vous avez choisi le vert.");

        } else if(color.equalsIgnoreCase("B")) { // ...

            System.out.println("Vous avez choisi le bleu.");

        } else { // Si aucune des 3 conditions est vraies alors nous affichons "Connais pas.".

            System.out.println("Connais pas.");

        }
        
    }

    public static String choiceColor() { // Méthode choiceColor(), retournant la valeur saisie par l'utilisateur (String), d'où le mot clé "String" à la place de "void".

        Scanner scanner = new Scanner(System.in); // Instanciation d'un nouvel objet de type Scanner.

        System.out.print("Quelle couleur souhaitez-vous ? "); // Affichage à l'utilisateur pour lui faire savoir ce qu'on attend de lui (UX).
        String userColor = scanner.next(); // Scanner.next() attend la prochaine chaîne de caractères saisie par l'utilisateur.

        scanner.close(); // Fermeture du scanner (Optionel).

        return userColor; // Enfin nous retournons la valeur stockée dans "userColor" à la suite du Scanner.next().

    }
    
}
