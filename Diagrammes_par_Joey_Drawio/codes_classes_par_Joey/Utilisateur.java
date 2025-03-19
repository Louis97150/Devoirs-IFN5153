public class Utilisateur extends Entite{
    private TypeUtilisateur type;
    private boolean abonnement;
    private float penalite;

    Utilisateur(int ID, String courriel, String motDePasse, String prenom, String nom, TypeUtilisateur typeUtilisateur) {
        this.ID = ID;
        this.courriel = courriel;
        this.motDePasse = motDePasse;
        this.prenom = prenom;
        this.nom = nom;
        this.type = typeUtilisateur;
        this.abonnement = true;
        this.penalite = 0;
    }

    public TypeUtilisateur getType() {
        return type;
    }

    public boolean isAbonnement() {
        return abonnement;
    }

    public float getPenalite() {
        return penalite;
    }

    public void setAbonnement(boolean abonnement) {
        this.abonnement = abonnement;
    }

    public void setPenalite(float penalite) {
        this.penalite = penalite;
    }

    

}
