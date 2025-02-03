import java.util.*;

public class Emprunt {
    public Ressources ressource;
    public Utilisateur user;
    public Date jResa;
    public Date retour;
    public boolean confirme;

    public Emprunt(Ressources ressources, Utilisateur user, Date jResa, Date retour){
        this.ressource = ressources;
        this.user = user;
        this.jResa = jResa;
        this.retour = retour;
    }

    public Ressources getRess(){
        return ressource;
    } 

    public Utilisateur getUser(){
        return user;
    } 

    public Date getDateResa(){
        return jResa;
    } 

    public Date getDateRetour(){
        return retour;
    }

    public void setUtilise(){
        this.confirme = false;
    }

    public void setLibre(){
        this.confirme = true;
    }

}