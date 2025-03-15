public class FactureSimple extends Facturation {
    @Override
    public void ajouterFacture(double somme) {
        if(somme < 0){
            throw new IllegalArgumentException("La somme ne peut pas être négative");
        }else{
            facture += somme;
            System.out.println("Facture augmentée de " + somme);
        }
    }

    @Override
    public double genereFacture() {
        double factureFinale = this.facture;
        this.facture = 0.0;
        System.err.println("Facture générée de " + factureFinale);
        return factureFinale;
    }
    
}
