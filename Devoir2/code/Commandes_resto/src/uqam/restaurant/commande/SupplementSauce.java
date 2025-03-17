package uqam.restaurant.commande;

public class SupplementSauce extends Supplement {
    private double coutSupplement;

    public SupplementSauce(Menu platDecore) {
        super(platDecore);
        this.coutSupplement = 1.0;
        platDecore.getIngredients().merge("sauce", 1, Integer::sum);
    }

    @Override
    public String afficher() {
        return platDecore.afficher() + " + sauce";
    }

    @Override
    public double getPrix() {
        return platDecore.getPrix() + coutSupplement;
    }
}