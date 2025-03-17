package uqam.restaurant.commande;

import java.util.Map;

public class CreateurDessert implements PlatFactory{

    @Override
    public Plat creerPlat(String nom, double prix, Map<String, Integer> ingredients) {
        return new Dessert(nom, prix, ingredients);
    }
}
