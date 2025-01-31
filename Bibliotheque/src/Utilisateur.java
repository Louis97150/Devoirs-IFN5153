//Création de la classe utilisateur
public class Utilisateur {
    public String role;
    public String id;
    public String nom;
    public int penalites;
    public boolean abonnement;

    public Utilisateur(String id, String role, String nom){
        this.id = id;
        this.role = role;
        this.nom = nom;
    }

    //Getter
    public String getId(){
        return id;
    }

    public String getRole(){
        return role;
    }

    public String getNom(){
        return nom;
    }

    public boolean abonnementValide(){
        return abonnement;
    }

    public int getPenalite(){
        return penalites;
    }

    public void aboActif(){
        this.abonnement = true;
    }

    public void aboDesac(){
        this.abonnement = false;
    }

    public void ajoutPenalite(){
        this.penalites++;
    }

    public void enlevePenalite(){
        if(this.penalites>0){
            this.penalites--;
        }
    }

    //Affichage simple de user
    @Override
    public String toString() {
        if(penalites>1){
            return "Utilisateur{" + 
            "id= '" + id+'\'' +","+
            " nom= '" + nom + '\''+","+
            " rôle= '"+role+'\''+"," +
            " abonnement= " +abonnement+","+
            " pénalités= "+penalites+"}";
        }
        return "Utilisateur{" + 
        "id= '" + id+'\'' +","+
        " nom= '" + nom + '\''+","+
        " rôle= '"+role+'\''+"," +
        " abonnement= " +abonnement+","+
        " pénalité= "+penalites+"}";
    }
}
