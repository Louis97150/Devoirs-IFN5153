package uqam.restaurant.commande;

import java.util.Map;

public interface Menu {
    String afficher();
    double getPrix();
    Map<String, Integer> getIngredients();
}
