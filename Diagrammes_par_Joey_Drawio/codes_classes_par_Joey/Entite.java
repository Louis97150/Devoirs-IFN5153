public abstract class Entite {
    protected int ID;
    protected String courriel;
    protected String motDePasse;
    protected String prenom;
    protected String nom;


    public int getID() {
        return ID;
    }
    public String getCourriel() {
        return courriel;
    }
    public String getMotDePasse() {
        return motDePasse;
    }
    public String getPrenom() {
        return prenom;
    }
    public String getNom() {
        return nom;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

}
