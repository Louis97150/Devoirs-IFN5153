package uqam.restaurant.commande;

import java.util.Map;

public class PlatPrincipal extends Plat {
    public PlatPrincipal(String nom, double prix) {
        super(nom, prix);
    }

    public PlatPrincipal(String nom, double prix, Map<String, Integer> ingredients) {
        super(nom, prix, ingredients);
    }

    @Override
    public String afficher() {
        return "Plat principal : " + super.afficher();
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}