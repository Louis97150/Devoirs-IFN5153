import java.util.*;

public class GererRess {
    public Map<String, Map<String, Map<String, List<Ressources>>>> ressource;

    public GererRess(){
        this.ressource = new HashMap<>();
    }

    public void ajoutRessource(String type, String titre, String auteur, String sujet, boolean dispo){
        // Créer la nouvelle ressource
        Ressources nouvelleRessource = new Ressources(titre, auteur, type, sujet, dispo);
    
        // Utiliser computeIfAbsent sur la map 'ressource' (et non sur une instance de Ressources)
        Map<String, Map<String, List<Ressources>>> types = ressource.computeIfAbsent(type, k -> new HashMap<>());
        Map<String, List<Ressources>> sujets = types.computeIfAbsent(sujet, k -> new HashMap<>());
        List<Ressources> ressourcesParAuteur = sujets.computeIfAbsent(auteur, k -> new ArrayList<>());
    
        // Vérifier si la ressource existe déjà
        boolean existeDeja = ressourcesParAuteur.stream().anyMatch(r ->r.getTitre().equalsIgnoreCase(titre));
    
        if (!existeDeja) {
            // Ajouter la ressource si elle n'existe pas déjà
            ressourcesParAuteur.add(nouvelleRessource);
            System.out.println("La ressource a bien été ajoutée.");
        } else {
            // Ne pas ajouter la ressource si elle existe déjà
            System.out.println("La ressource n'a pas été ajoutée car elle existe déjà.");
        }
    }
    

    public void suppRes(String titre){
        for (Iterator<Map.Entry<String, Map<String, Map<String, List<Ressources>>>>> typeIterator = ressource.entrySet().iterator(); typeIterator.hasNext();) {
            Map.Entry<String, Map<String, Map<String, List<Ressources>>>> typeEntry = typeIterator.next();
            Map<String, Map<String, List<Ressources>>> sujets = typeEntry.getValue();
    
            for (Iterator<Map.Entry<String, Map<String, List<Ressources>>>> sujetIterator = sujets.entrySet().iterator(); sujetIterator.hasNext();) {
                Map.Entry<String, Map<String, List<Ressources>>> sujetEntry = sujetIterator.next();
                Map<String, List<Ressources>> auteurs = sujetEntry.getValue();
    
                for (Iterator<Map.Entry<String, List<Ressources>>> auteurIterator = auteurs.entrySet().iterator(); auteurIterator.hasNext();) {
                    Map.Entry<String, List<Ressources>> auteurEntry = auteurIterator.next();
                    List<Ressources> ressources = auteurEntry.getValue();

                    boolean ressourceSupprimee = ressources.removeIf(r -> r.getTitre().equalsIgnoreCase(titre));
    
                    if (ressourceSupprimee) {
                        if (ressources.isEmpty()) {
                            auteurIterator.remove();
                        }
    
                        if (auteurs.isEmpty()) {
                            sujetIterator.remove();
                        }
    
                        if (sujets.isEmpty()) {
                            typeIterator.remove();
                        }
    
                        System.out.println("Ressource supprimée avec succès.");
                        return;
                    }
                }
            }
        }
        System.out.println("Ressource non supprimée car non trouvée.");
    }
    

    public void modifRess(String titre, String nsujet, String nauteur, String ntype, String ntitre, boolean dispo){
        for(Map<String, Map<String, List<Ressources>>> types:ressource.values() ){
            for(Map<String, List<Ressources>> sujets: types.values()){
                for(List<Ressources> auteur:sujets.values()){
                    for(Ressources res: auteur){
                        if(res.getTitre().equalsIgnoreCase(titre)){
                            suppRes(titre);
                            auteur.remove(res);

                            res.setSujet(nsujet);
                            res.setAuteur(nauteur);
                            res.setType(ntype);
                            res.setTitre(ntitre);
                            res.setDispo(dispo);

                            Map<String, Map<String, List<Ressources>>> typesMap = ressource.computeIfAbsent(ntype, k -> new HashMap<>());
                            Map<String, List<Ressources>> sujetsMap = typesMap.computeIfAbsent(nsujet, k -> new HashMap<>());
                            List<Ressources> auteurList = sujetsMap.computeIfAbsent(nauteur, k -> new ArrayList<>());

                            auteurList.add(res);
                            System.out.println("Ressource modifiée avec succès.");
                            return;
                        }
                    }
                }
            }
        }
        System.out.println("Ressource non modifiée car non trouvée.");
    }

    public void afficherRessources() {
        for (Map.Entry<String, Map<String,  Map<String, List<Ressources>>>> typeEntry : ressource.entrySet()) {
            System.out.println("Type : " + typeEntry.getKey());
            for (Map.Entry<String,  Map<String, List<Ressources>>> sujetEntry : typeEntry.getValue().entrySet()) {
                System.out.println("Sujet : " + sujetEntry.getKey());
                for(Map.Entry<String, List<Ressources>> auteur : sujetEntry.getValue().entrySet()){
                    System.out.println("Auteur : " + auteur.getKey());
                    for (Ressources res : auteur.getValue()) {
                        System.out.println(res);
                    }
                }
            }
            System.out.println("\n");
        }
    }
}