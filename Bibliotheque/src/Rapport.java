import java.util.*;

public class Rapport {
    public List<Emprunt> emprunts;

    public Rapport(List<Emprunt> emprunts) {
        this.emprunts = emprunts;
    }

    public void genererRapportRessourcesEmpruntees() {
        Map<String, Integer> statistiques = new HashMap<>();

        for (Emprunt emprunt : emprunts) {
            String titre = emprunt.getRess().getTitre();
            statistiques.put(titre, statistiques.getOrDefault(titre, 0) + 1);
        }

        System.out.println("📊 Rapport des ressources les plus empruntées :");
        statistiques.entrySet().stream()
            .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
            .forEach(entry -> System.out.println(entry.getKey() + " : " + entry.getValue() + " emprunts"));
    }

    public void genererStatistiquesUtilisation() {
        Map<String, List<Integer>> statistiquesUtilisation = new HashMap<>();

        for (Emprunt emprunt : emprunts) {
            String utilisateur = emprunt.getUser().getNom();
            statistiquesUtilisation.putIfAbsent(utilisateur, new ArrayList<>());
            statistiquesUtilisation.get(utilisateur).add(1);
        }

        System.out.println("📊 Statistiques d'utilisation par utilisateur :");
        statistiquesUtilisation.forEach((user, count) ->
            System.out.println(user + " a emprunté " + count.size() + " ressources"));
    }
}