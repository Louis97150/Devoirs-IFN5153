package uqam.restaurant.commande;

import java.util.Map;

public class Dessert extends Plat {
    public Dessert(String nom, double prix) {
        super(nom, prix);
        ingredients.put("sucre", 1);
    }

    public Dessert(String nom, double prix, Map<String, Integer> ingredients) {
        super(nom, prix, ingredients);
    }

    @Override
    public String afficher() {
        return "Dessert : " + super.afficher();
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}