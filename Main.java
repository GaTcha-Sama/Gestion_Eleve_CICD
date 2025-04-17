public class Main {
    private static Etudiant[] etudiants;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.print("Entrez le nombre d'etudiants: ");
        int nbEtud = scanner.nextInt();
        etudiants = new Etudiant[nbEtud];

    }


}
