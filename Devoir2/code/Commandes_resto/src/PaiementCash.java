public class PaiementCash implements ProcesseurPaiement {
    
    @Override
    public boolean traiterPaiement(double somme) {
        System.out.println("Le paiement en cash de " + somme + "$ a été effectué");
        return true;
    }
    @Override
    public boolean rembourser(double somme){
        System.out.println("Le remborusement en cash de " + somme + "$ a été effectué");
        return true;
    }
    
}
