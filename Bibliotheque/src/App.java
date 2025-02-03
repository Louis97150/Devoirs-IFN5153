import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        // Création d'utilisateurs
        Utilisateur user1 = new Utilisateur(1, "Etudiant", "Alice");
        Utilisateur user2 = new Utilisateur(2, "Professeur", "Bob");

        // Création de ressources
        Ressources livre1 = new Ressources("Java Basics", "John Doe", "Livre", "Programmation", false);
        Ressources livre2 = new Ressources("Data Structures", "Jane Doe", "Livre", "Informatique", false);
        Ressources livre3 = new Ressources("Machine Learning", "AI Expert", "Livre", "IA", false);

        // Création d'emprunts
        List<Emprunt> emprunts = new ArrayList<>();
        emprunts.add(new Emprunt(livre1, user1, new Date(), new Date()));
        emprunts.add(new Emprunt(livre1, user2, new Date(), new Date()));
        emprunts.add(new Emprunt(livre2, user1, new Date(), new Date()));
        emprunts.add(new Emprunt(livre3, user1, new Date(), new Date()));
        emprunts.add(new Emprunt(livre3, user2, new Date(), new Date()));

        // Création du rapport
        Rapport rapport = new Rapport(emprunts);

        // Générer et afficher les rapports
        System.out.println("=== Rapport des ressources les plus empruntées ===");
        rapport.genererRapportRessourcesEmpruntees();

        System.out.println("\n=== Statistiques d'utilisation des ressources ===");
        rapport.genererStatistiquesUtilisation();
    }
}
