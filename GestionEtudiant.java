import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class GestionEtudiant {
    private static Etudiant[] etudiants;
    private static List<String> matieres;
    private static Scanner scanner = new Scanner(System.in);
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static void main(String[] args) {
        initialiserMatieres();
        
        System.out.print("\nEntrez le nombre d'étudiants : ");
        int nbEtud = scanner.nextInt();
        etudiants = new Etudiant[nbEtud];

        enregistrerEtudiants();

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
                    afficherDernierEtudiant();
                    break;
                case 4:
                    reinitialiserListe();
                    break;
                case 5:
                    System.out.println("Au revoir !");
                    scanner.close();
                    return;
                default:
                    System.out.println("Choix invalide !");
            }
        }
    }

    private static void initialiserMatieres() {
        matieres = new ArrayList<>();
        matieres.add("Mathématiques");
        matieres.add("Physique");
        matieres.add("Informatique");
        matieres.add("Français");
        matieres.add("Anglais");
    }

    private static void afficherMenu() {
        System.out.println("\n=== MENU ===");
        System.out.println("1. Afficher les étudiants par ordre de mérite");
        System.out.println("2. Afficher les informations du premier étudiant");
        System.out.println("3. Afficher les informations du dernier étudiant");
        System.out.println("4. Réinitialiser la liste de la classe");
        System.out.println("5. Quitter");
        System.out.print("Votre choix : ");
    }

    private static void enregistrerEtudiants() {
        scanner.nextLine(); 

        for (int i = 0; i < etudiants.length; i++) {
            System.out.println("\nEnregistrement de l'étudiant " + (i+1));
            System.out.print("Matricule : ");
            String matricule = scanner.nextLine();
            
            System.out.print("Nom : ");
            String nom = scanner.nextLine();
            
            System.out.print("Date de naissance (dd/MM/yyyy) : ");
            String dateStr = scanner.nextLine();
            LocalDate dateNaissance = LocalDate.parse(dateStr, DATE_FORMATTER);
            
            etudiants[i] = new Etudiant(matricule, nom, dateNaissance);

            System.out.println("Saisie des notes :");
            for (String matiere : matieres) {
                System.out.print(matiere + " : ");
                double note = scanner.nextDouble();
                etudiants[i].ajouterNote(matiere, note);
                scanner.nextLine(); 
            }
        }
    }

    private static void afficherParMerite() {
        if (etudiants == null || etudiants.length == 0) {
            System.out.println("Aucun étudiant enregistré.");
            return;
        }

        Etudiant[] etudiantsTries = etudiants.clone();
        Arrays.sort(etudiantsTries, Comparator.comparingDouble(Etudiant::getMoyenne).reversed());

        System.out.println("\nClassement par ordre de mérite :");
        for (int i = 0; i < etudiantsTries.length; i++) {
            System.out.println("\n" + (i + 1) + "e place :");
            etudiantsTries[i].afficher();
        }
    }

    private static void afficherPremierEtudiant() {
        if (etudiants == null || etudiants.length == 0) {
            System.out.println("Aucun étudiant enregistré.");
            return;
        }

        Etudiant premier = Arrays.stream(etudiants)
                                .max(Comparator.comparingDouble(Etudiant::getMoyenne))
                                .orElse(null);
        
        if (premier != null) {
            System.out.println("\nPremier de la classe :");
            premier.afficher();
        }
    }

    private static void afficherDernierEtudiant() {
        if (etudiants == null || etudiants.length == 0) {
            System.out.println("Aucun étudiant enregistré.");
            return;
        }

        Etudiant dernier = Arrays.stream(etudiants)
                                .min(Comparator.comparingDouble(Etudiant::getMoyenne))
                                .orElse(null);
        
        if (dernier != null) {
            System.out.println("\nDernier de la classe :");
            dernier.afficher();
        }
    }

    private static void reinitialiserListe() {
        etudiants = null;
        System.out.print("Entrez le nouveau nombre d'étudiants : ");
        int nbEtud = scanner.nextInt();
        etudiants = new Etudiant[nbEtud];
        enregistrerEtudiants();
        System.out.println("Liste réinitialisée avec succès !");
    }
}