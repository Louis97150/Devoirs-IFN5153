public abstract class Facturation {
    public double facture;

    public Facturation(){
        this.facture = 0.0;
    }

    public abstract void ajouterFacture(double somme);

    public abstract double genereFacture();

    public double getFacture(){
        return facture;
    }
}
