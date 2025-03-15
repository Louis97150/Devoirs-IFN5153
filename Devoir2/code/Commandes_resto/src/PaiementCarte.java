public class PaiementCarte implements ProcesseurPaiement {
    
    @Override
    public boolean traiterPaiement(double somme) {
        System.out.println("Le paiement par carte de " + somme + "$ a été effectué");
        return true;
    }
    @Override
    public boolean rembourser(double somme){
        System.out.println("Le remborusement par carte de " + somme + "$ a été effectué");
        return true;
    }
    
}
