import java.util.*;

public class Utilisateurs {
     private List<Utilisateur> lesUtilisateurs;

    Utilisateurs() {
        lesUtilisateurs = new ArrayList<>();
    }

    public List<Utilisateur> getUtilisateurs() {
        return lesUtilisateurs;
    }

    public void ajouterUtilisateur(Utilisateur Utilisateur) {
        lesUtilisateurs.add(Utilisateur);
    }

    public Utilisateur supprimerUtilisateur(int idUtilisateur) {
        return lesUtilisateurs.remove(idUtilisateur);
    }

    public Utilisateur getUtilisateur(int idUtilisateur) {
        return lesUtilisateurs.get(idUtilisateur);
    }

    public void setUtilisateur(int idUtilisateur, Utilisateur nouveauUtilisateur) {
        lesUtilisateurs.set(idUtilisateur, nouveauUtilisateur);
    }

}
