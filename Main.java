import java.util.Scanner;

public class Main {
    private static Etudiant[] etudiants;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.print("Entrez le nombre d'etudiants: ");
        int nbEtud = scanner.nextInt();
        etudiants = new Etudiant[nbEtud];

        while (true) {
            afficherMenu();
            int choix = scanner.nextInt();
            switch (choix) {
                case 1:
                    afficherParMerite();
                    break;
                case 2:
                    afficherPremierEtudiant();
                    break;
                case 3:
                    ajouterDernierEtudiant();
                    break;
                case 4:
                    afficherNotes();
                    break;
                case 5:
                    reinitialiserListe();
                    break;
                case 6:
                    System.out.println("Au revoir!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
            }
        }
    }

    private static void afficherMenu() {
        System.out.println("1. Afficher par mérite");
        System.out.println("2. Afficher le premier étudiant");
        System.out.println("3. Ajouter le dernier étudiant");
        System.out.println("4. Afficher les notes");
        System.out.println("5. Réinitialiser la liste");
        System.out.println("6. Quitter");
        System.out.print("Entrez votre choix: ");
    }

    private static void afficherParMerite() {
        System.out.println("Afficher par mérite");
    }
     
    private static void afficherPremierEtudiant() {
        System.out.println("Afficher le premier étudiant");
    }

    private static void ajouterDernierEtudiant() {
        System.out.println("Ajouter le dernier étudiant");
    }

    private static void afficherNotes() {
        System.out.println("Afficher les notes");
    }

    private static void reinitialiserListe() {
        System.out.println("Réinitialiser la liste");
    }
}



