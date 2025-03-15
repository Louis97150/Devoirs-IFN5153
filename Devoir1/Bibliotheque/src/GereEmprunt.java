import java.util.*;
public class GereEmprunt{
    public Map<String, Map<String, Map<String, List<Ressources>>>> ressource;
    public List<Emprunt> reservations;

    public GereEmprunt() {
        this.ressource = new HashMap<>();
        this.reservations = new ArrayList<>();
    }

    public void reserverRessource(String titre, Utilisateur utilisateur, Date jResa, Date retour) {
        for (Map<String, Map<String, List<Ressources>>> types : ressource.values()) {
            for (Map<String, List<Ressources>> sujets : types.values()) {
                for (List<Ressources> auteurs : sujets.values()) {
                    for (Ressources res : auteurs) {
                        if (res.getTitre().equalsIgnoreCase(titre)) {
                            if (res.getDispo()) {
                                Emprunt nouvelleReservation = new Emprunt(res, utilisateur, jResa, retour);
                                nouvelleReservation.setUtilise();
                                reservations.add(nouvelleReservation);
                                System.out.println("Ressource réservée avec succès jusqu'au " + nouvelleReservation.getDateRetour());
                                return;
                            } else {
                                System.out.println("La ressource est indisponible, inutile de la réserver.");
                                return;
                            }
                        }
                    }
                }
            }
        }
        System.out.println("Ressource non trouvée.");
    }

    public void annulerReservation(String titre, Utilisateur utilisateur) {
        reservations.removeIf(res -> 
            res.getRess().getTitre().equalsIgnoreCase(titre) &&
            res.getUser().equals(utilisateur)
        );
        System.out.println("Réservation annulée");
    }

    public void notifierDisponibilite(Ressources ressource) {
        for (Emprunt res : reservations) {
            if (res.getRess().equals(ressource)) {
                System.out.println("Notification envoyée à " + res.getUser().getNom());
            }
        }
    }

    public void retard(){
        Date today = new Date();

        for(Emprunt resa : reservations){
            if(resa.getDateRetour().after(today)){
                resa.user.ajoutPenalite();
                System.out.println("🚨 Retard");
            }else{
                System.out.println("✅ Pas de retard");
            }
        }
    }

    public void afficherEmprunts() {
        if (reservations.isEmpty()) {
            System.out.println("Aucun emprunt enregistré.");
            return;
        }
    
        System.out.println("📚 Liste des emprunts :");
        for (Emprunt emprunt : reservations) {
            System.out.println("Titre      : " + emprunt.getRess().getTitre());
            System.out.println("Auteur     : " + emprunt.getRess().getAuteur());
            System.out.println("Type       : " + emprunt.getRess().getType());
            System.out.println("Sujet      : " + emprunt.getRess().getSujet());
            System.out.println("Emprunteur : " + emprunt.getUser().getNom());
            System.out.println("Date d'emprunt : " + emprunt.getDateResa());
            System.out.println("Date de retour prévue : " + emprunt.getDateRetour());
    
            retard();
        }
    }
    

}