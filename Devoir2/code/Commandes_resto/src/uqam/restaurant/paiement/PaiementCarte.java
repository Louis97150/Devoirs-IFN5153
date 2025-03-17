package uqam.restaurant.paiement;

public class PaiementCarte implements ProcesseurPaiement {
    
    @Override
    public boolean traiterPaiement(double somme) {
        System.out.println("Paiement par carte de " + somme + " effectué avec succès.");
        return true;
    }
    
}
