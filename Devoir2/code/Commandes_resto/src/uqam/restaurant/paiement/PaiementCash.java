package uqam.restaurant.paiement;

public class PaiementCash implements ProcesseurPaiement {
    
    @Override
    public boolean traiterPaiement(double somme) {
        System.out.println("Paiement en espèces de " + somme + " effectué avec succès.");
        return true;
    }
    
}
