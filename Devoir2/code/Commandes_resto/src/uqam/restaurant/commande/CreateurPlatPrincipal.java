package uqam.restaurant.commande;

import java.util.Map;

public class CreateurPlatPrincipal implements PlatFactory{

    @Override
    public Plat creerPlat(String nom, double prix, Map<String, Integer> ingredients) {
        return new PlatPrincipal(nom, prix, ingredients);
    }
}
