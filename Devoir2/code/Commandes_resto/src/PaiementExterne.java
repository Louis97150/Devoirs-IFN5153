public class PaiementExterne implements ProcesseurPaiement {
    
    public ServiceExterne service;

    public PaiementExterne(){
        this.service = new ServiceExterne();
    }

    @Override
    public boolean traiterPaiement(double somme) {
        try {
            service.envoyerPaiement(somme);
            return true;
        } catch (Exception e) {
            System.err.println("Erreur lors du paiement externe : " + e.getMessage());
            return false;
        }
    }
    @Override
    public boolean rembourser(double somme){
        try {
            service.rembourser(somme);
            return true;
        } catch (Exception e) {
            System.err.println("Erreur lors du remboursement externe : " + e.getMessage());
            return false;
        }
    }
}
