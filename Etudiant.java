import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Etudiant {
    private String matricule;
    private String nom;
    private LocalDate dateNaissance;
    private List<Double> notes;

    public Etudiant(String matricule, String nom, LocalDate dateNaissance) {
        this.matricule = matricule;
        this.nom = nom;
        this.dateNaissance = dateNaissance;
        this.notes = new ArrayList<>();
    }

    public String getMatricule() {
        return matricule;
    }

    public String getNom() {
        return nom;
    }

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public List<Double> getNotes() {
        return notes;
    }

    public void ajouterNote(double note) {
        this.notes.add(note);
    }

}