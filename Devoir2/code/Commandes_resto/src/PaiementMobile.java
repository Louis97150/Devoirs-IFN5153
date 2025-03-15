public class PaiementMobile implements ProcesseurPaiement {
    
    @Override
    public boolean traiterPaiement(double somme) {
        System.out.println("Le paiement par mobile de " + somme + "$ a été effectué");
        return true;
    }
    @Override
    public boolean rembourser(double somme){
        System.out.println("Le remborusement par mobile de " + somme + "$ a été effectué");
        return true;
    }
    
}
