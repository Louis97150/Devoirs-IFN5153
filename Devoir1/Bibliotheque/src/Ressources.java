public class Ressources {
    public String titre;
    public String auteur;
    public String type;
    public String sujet;
    public boolean dispo;

    public Ressources(String titre, String auteur, String type, String sujet, boolean dispo){
        this.titre = titre;
        this.auteur = auteur;
        this.type = type;
        this.sujet = sujet;
        this.dispo = dispo;
    }

    public void setSujet(String sujet){
        this.sujet = sujet;
    }

    public void setAuteur(String auteur){
        this.auteur = auteur;
    }

    public void setType(String type){
        this.type = type;
    }

    public void setTitre(String titre){
        this.titre = titre;
    }

    public void setDispo(boolean dispo){
        this.dispo = dispo;
    }

    public boolean getDispo(){
        return dispo;
    }
    
    public String getTitre(){
        return titre;
    }
    public String getAuteur(){
        return auteur;
    }
    public String getType(){
        return type;
    }
    public String getSujet(){
        return sujet;
    }


    @Override
    public String toString(){
        return "Titre: '"+titre+'\''+"\n" +
        "Disponnibilité: "+dispo;
    }
}
