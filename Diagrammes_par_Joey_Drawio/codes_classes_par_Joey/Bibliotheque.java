import java.util.*;

public class Bibliotheque {

    private Admins admins;
    private Emprunts emprunts;
    private Reservations reservations;
    private Ressources ressources;
    private Utilisateurs utilisateurs;

    Bibliotheque(Admins admins, Emprunts emprunts, Reservations reservations, Ressources ressources, Utilisateurs utilisateurs) {
        this.admins = admins;
        this.emprunts = emprunts;
        this.reservations = reservations;
        this.ressources = ressources;
        this.utilisateurs = utilisateurs;
    }

    public void genererStatistiques() {
        Map<String, Integer> statistiques = new HashMap<>();

        for (Emprunt emprunt : emprunts.getEmprunts()) {
            String titre = ressources.getRessource(emprunt.getIdRessource()).getTitre();
            statistiques.put(titre, statistiques.getOrDefault(titre, 0) + 1);
        }

        System.out.println("Rapport des ressources les plus empruntées :");
        statistiques.entrySet().stream()
            .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
            .forEach(entry -> System.out.println(entry.getKey() + " : " + entry.getValue() + " emprunts"));

    }

}
