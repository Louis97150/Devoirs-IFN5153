import java.util.*;

public class Ressources {
    private List<Ressource> lesRessources;

    Ressources() {
        lesRessources = new ArrayList<>();
    }
    
    public List<Ressource> getRessources() {
        return lesRessources;
    }

    public void ajouterRessource(Ressource ressource) {
        lesRessources.add(ressource);
    }

    public Ressource supprimerRessource(int idRessource) {
        return lesRessources.remove(idRessource);
    }

    public Ressource getRessource(int idRessource) {
        return lesRessources.get(idRessource);
    }

    public void setRessource(int idRessource, Ressource nouvelleRessource) {
        lesRessources.set(idRessource, nouvelleRessource);
    }
}
