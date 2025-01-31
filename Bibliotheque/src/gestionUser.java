import java.util.*;

public class gestionUser {
    //Création dictonnaire
    public Map<String, Utilisateur> utilisateurs;

    public gestionUser(){
        this.utilisateurs = new HashMap<>();
    }
    
    //Ajout d'un utilisateur
    public void ajoutUser(String id, String nom, String role){
        //Si id n'est pas dans utilisateur
        if(!utilisateurs.containsKey(id)){
            utilisateurs.put(id, new Utilisateur(id, nom, role));
            System.out.println("Ajout réussi");
        }else{
            System.out.println("L'utilisateur existe déjà");
        }
    }

    //Modifier user
    public void modifUser(String id, String newName, String newRole){
        Utilisateur userToModify = utilisateurs.get(id);
        if(userToModify != null){
            userToModify = new Utilisateur(id, newRole, newRole);
            utilisateurs.put(id, userToModify);
            System.out.println("Modification réussie");
        }else{
            System.out.println("L'utilisateur n'existe pas");
        }
    }

    //Supprimer user 
    public void supprimerUser(String id){
        Utilisateur userToDelete = utilisateurs.get(id);
        if(userToDelete != null){
            utilisateurs.remove(id);
            System.out.println("Utilisateur supprimé");
        }else{
            System.out.println("Utilisateur introuvable");
        }
    }

    //Pénalité + 1
    public void penaliteEnPlus(String id){
        Utilisateur userPenalite = utilisateurs.get(id);
        if(userPenalite != null){
            userPenalite.ajoutPenalite();
            System.out.println("Penalité ajoutée");
        }else{
            System.out.println("L'utilisateur est introuvables");
        }
    }

    //Pénalité - 1
    public void penaliteEnMoins(String id){
        Utilisateur userPenalite = utilisateurs.get(id);
        if(userPenalite != null){
            userPenalite.enlevePenalite();
            System.out.println("Penalité enlevée");
        }else{
            System.out.println("L'utilisateur est introuvables");
        }
    }

    //Modif abonnement
    public void annulAbo(String id, boolean abo){
        Utilisateur userToModify = utilisateurs.get(id);
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
