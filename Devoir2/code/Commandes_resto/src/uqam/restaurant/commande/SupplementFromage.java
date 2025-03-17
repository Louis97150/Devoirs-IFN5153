package uqam.restaurant.commande;

import java.util.Map;

public class SupplementFromage extends Supplement {
    private double coutSupplement;

    public SupplementFromage(Menu platDecore) {
        super(platDecore);
        this.coutSupplement = 2.0;        
    }

    @Override
    public String afficher() {
        return platDecore.afficher() + " + fromage (" + coutSupplement + "$)";
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