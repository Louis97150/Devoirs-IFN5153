import java.util.*;

public class gestionUser {
    //Création dictonnaire
    public Map<String, Utilisateur> utilisateurs;

    public gestionUser(){
        this.utilisateurs = new HashMap<>();
    }
    
    //Ajout d'un utilisateur
    public void ajoutUser(int id, String nom, String role){
        String identifiant = String.valueOf(id); 
        //Si id n'est pas dans utilisateur
        if(!utilisateurs.containsKey(identifiant)){
            utilisateurs.put(identifiant, new Utilisateur(id, nom, role));
            System.out.println("Ajout réussi");
        }else{
            System.out.println("L'utilisateur existe déjà");
        }
    }

    //Modifier user
    public void modifUser(int id, String newName, String newRole){
        String identifiant = String.valueOf(id); 
        Utilisateur userToModify = utilisateurs.get(identifiant);
        if(userToModify != null){
            userToModify = new Utilisateur(id, newRole, newRole);
            utilisateurs.put(identifiant, userToModify);
            System.out.println("Modification réussie");
        }else{
            System.out.println("L'utilisateur n'existe pas");
        }
    }

    //Supprimer user 
    public void supprimerUser(int id){
        String identifiant = String.valueOf(id); 
        Utilisateur userToDelete = utilisateurs.get(identifiant);
        if(userToDelete != null){
            utilisateurs.remove(identifiant);
            System.out.println("Utilisateur supprimé");
        }else{
            System.out.println("Utilisateur introuvable");
        }
    }

    //Pénalité + 1
    public void penaliteEnPlus(int id){
        String identifiant = String.valueOf(id); 
        Utilisateur userPenalite = utilisateurs.get(identifiant);
        if(userPenalite != null){
            userPenalite.ajoutPenalite();
            System.out.println("Penalité ajoutée");
        }else{
            System.out.println("L'utilisateur est introuvables");
        }
    }

    //Pénalité - 1
    public void penaliteEnMoins(int id){
        String identifiant = String.valueOf(id); 
        Utilisateur userPenalite = utilisateurs.get(identifiant);
        if(userPenalite != null){
            userPenalite.enlevePenalite();
            System.out.println("Penalité enlevée");
        }else{
            System.out.println("L'utilisateur est introuvables");
        }
    }

    //Modif abonnement
    public void modifAbo(int id, boolean abo){
        String identifiant = String.valueOf(id); 
        Utilisateur userToModify = utilisateurs.get(identifiant);
        if(userToModify != null){
            //Supprimer abonnement
            if(abo){
                userToModify.aboActif();
            }
            //Activer abonnement
            else{
                userToModify.aboDesac();
            }
            System.out.println("Abonnement modifié");
        }else{
            System.out.println("L'utilisateur est introuvables");
        }
    }

    //Print user
    public void afficherUser(){
        for(Utilisateur user:utilisateurs.values()){
            System.out.println(user);
        }
    }
}
