import java.time.format.DateTimeFormatter;
import java.util.Scanner;
public class Main {
    private static Etudiant[] etudiants;
    private static Scanner scanner = new Scanner(System.in);
    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static void main(String[] args) {

        System.out.print("Entrez le nombre d'etudiants: ");
        int nbEtud = scanner.nextInt();
        etudiants = new Etudiant[nbEtud];

        enregistrerEtudiant();

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
                    afficherMoyenne();
                    break;
                case 7:
                    System.out.println("Au revoir!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
            }
        }
    }

    private static void enregistrerEtudiant() {
        for (int i = 0; i < etudiants.length; i++) {
            System.out.println("Enregistrement de l'etudiant " + (i + 1) + ":");
            System.out.print("Nom: ");
            String nom = scanner.next();
            System.out.print("Matricule: ");
            String matricule = scanner.next();
            System.out.print("Date de naissance (dd/MM/yyyy): ");
            String dateNaissance = scanner.next();
            System.out.print("Notes: ");
            String notes = scanner.next();
        }
    }

    private static void afficherMenu() {
        System.out.println("\n ###### Menu: ######");
        System.out.println("1. Afficher par mérite");
        System.out.println("2. Afficher le premier étudiant");
        System.out.println("3. Ajouter le dernier étudiant");
        System.out.println("4. Afficher les notes");
        System.out.println("5. Réinitialiser la liste");
        System.out.println("6. Afficher la moyenne");
        System.out.println("7. Quitter");
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

    private static void afficherMoyenne() {
        System.out.println("Afficher la moyenne");
    }

    private static void reinitialiserListe() {
        System.out.println("Réinitialiser la liste");
    }
}



