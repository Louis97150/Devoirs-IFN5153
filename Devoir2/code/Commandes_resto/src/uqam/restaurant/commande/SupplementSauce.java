package uqam.restaurant.commande;

import java.util.Map;

public class SupplementSauce extends Supplement {
    private double coutSupplement;

    public SupplementSauce(Menu platDecore) {
        super(platDecore);
        this.coutSupplement = 1.0;
    }

    @Override
    public String afficher() {
        return platDecore.afficher() + " + sauce (" + coutSupplement + "$)";
    }

    @Override
    public double getPrix() {
        return platDecore.getPrix() + coutSupplement;
    }

    @Override
    public Map<String, Integer> getIngredients() {
        return platDecore.getIngredients();
    }
}