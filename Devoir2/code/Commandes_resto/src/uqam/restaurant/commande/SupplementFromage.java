package uqam.restaurant.commande;

public class SupplementFromage extends Supplement {
    private double coutSupplement;

    public SupplementFromage(Menu platDecore) {
        super(platDecore);
        this.coutSupplement = 2.0;
        platDecore.getIngredients().merge("fromage", 1, Integer::sum);
    }

    @Override
    public String afficher() {
        return platDecore.afficher() + " + fromage";
    }

    @Override
    public double getPrix() {
        return platDecore.getPrix() + coutSupplement;
    }
}