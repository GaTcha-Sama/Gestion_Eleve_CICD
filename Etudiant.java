// cSpell:disable

// package cas1;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Etudiant {
    private String matricule;
    private String nom;
    private LocalDate dateNaissance;
    private Map<String, Double> notes;

    public Etudiant(String matricule, String nom, LocalDate dateNaissance) {
        this.matricule = matricule;
        this.nom = nom;
        this.dateNaissance = dateNaissance;
        this.notes = new HashMap<>();
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public void ajouterNote(String matiere, double note) {
        this.notes.put(matiere, note);
    }

    public double getMoyenne() {
        if (notes.isEmpty()) return 0.0;
        return notes.values().stream()
                   .mapToDouble(Double::doubleValue)
                   .average()
                   .orElse(0.0);
    }

    public void afficher() {
        System.out.println("Informations de l'étudiant :");
        System.out.println("Matricule : " + this.matricule);
        System.out.println("Nom : " + this.nom);
        System.out.println("Date de naissance : " + this.dateNaissance);
        System.out.println("Notes par matière :");
        notes.forEach((matiere, note) -> 
            System.out.println("- " + matiere + " : " + note));
        System.out.println("Moyenne générale : " + String.format("%.2f", getMoyenne()));
    }

    public int calculerAge() {
        return LocalDate.now().getYear() - this.dateNaissance.getYear();
    }
}