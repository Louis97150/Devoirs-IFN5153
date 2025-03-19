package uqam.restaurant.commande;

import java.util.Map;

public interface Menu {
    public String afficher();
    public double getPrix();
    public Map<String, Integer> getIngredients();
}
