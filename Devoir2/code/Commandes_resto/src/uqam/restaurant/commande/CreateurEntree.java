package uqam.restaurant.commande;

import java.util.Map;

public class CreateurEntree implements PlatFactory{

    @Override
    public Plat creerPlat(String nom, double prix, Map<String, Integer> ingredients) {
        return new Entree(nom, prix, ingredients);
    }

}
