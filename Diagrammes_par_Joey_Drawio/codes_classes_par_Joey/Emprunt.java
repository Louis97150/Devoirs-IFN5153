import java.util.Date;

public class Emprunt {
    private int ID;
    private Date dateRetourPrevu;
    private Date dateRetour;
    private Date dateEmprunt;
    private int idUtilisateur;
    private int idRessource;

    Emprunt(int ID, Date dateRetourPrevu, Date dateEmprunt, int idUtilisateur, int idRessource) {
        this.ID = ID;
        this.dateRetourPrevu = dateRetourPrevu;
        this.dateRetour = null;
        this.dateEmprunt = dateEmprunt;
        this.idUtilisateur = idUtilisateur;
        this.idRessource = idRessource;
    }

    public int getID() {
        return ID;
    }

    public Date getDateRetourPrevu() {
        return dateRetourPrevu;
    }

    public Date getDateRetour() {
        return dateRetour;
    }

    public Date getDateEmprunt() {
        return dateEmprunt;
    }

    public int getIdUtilisateur() {
        return idUtilisateur;
    }

    public int getIdRessource() {
        return idRessource;
    }

    public void setDateRetour(Date dateRetour) {
        this.dateRetour = dateRetour;
    }

    
}
