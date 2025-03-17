package uqam.restaurant.paiement;

public class PaiementMobile implements ProcesseurPaiement {
    
    @Override
    public boolean traiterPaiement(double somme) {
        System.out.println("Paiement mobile de " + somme + " effectué avec succès.");
        return true;
    }
    
}
