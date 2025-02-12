public class Ressource {
    private int ID;
    private TypeRessource type;
    private String titre;
    private String sujet;
    private String auteur;
    private boolean disponible;

    Ressource(int ID, TypeRessource type, String titre, String sujet, String auteur) {
        this.ID = ID;
        this.type = type;
        this.titre = titre;
        this.sujet = sujet;
        this.auteur = auteur;
        this.disponible = true;
    }

    public int getID() {
        return ID;
    }

    public TypeRessource getType() {
        return type;
    }

    public String getTitre() {
        return titre;
    }

    public String getSujet() {
        return sujet;
    }

    public String getAuteur() {
        return auteur;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    

}
