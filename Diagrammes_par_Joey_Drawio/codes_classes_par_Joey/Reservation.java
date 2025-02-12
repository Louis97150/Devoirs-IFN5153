import java.util.Date;

public class Reservation {
    private int ID;
    private Date dateReserv;
    private boolean annuler;
    private boolean confirmer;
    private int idUtilisateur;
    private int idRessource;

    Reservation(int ID, Date dateReserv, int idUtilisateur, int idRessource) {
        this.ID = ID;
        this.dateReserv = dateReserv;
        this.annuler = false;
        this.confirmer = false;
        this.idUtilisateur = idUtilisateur;
        this.idRessource = idRessource;
    }

    public int getID() {
        return ID;
    }

    public Date getDateReserv() {
        return dateReserv;
    }

    public boolean isAnnuler() {
        return annuler;
    }

    public boolean isConfirmer() {
        return confirmer;
    }

    public int getIdUtilisateur() {
        return idUtilisateur;
    }

    public int getIdRessource() {
        return idRessource;
    }

    public void setAnnuler(boolean annuler) {
        this.annuler = annuler;
    }

    public void setConfirmer(boolean confirmer) {
        this.confirmer = confirmer;
    }

    


}
