package uqam.restaurant.commande;

import java.util.*;

public class Entree extends Plat {
    public Entree(String nom, double prix) {
        super(nom, prix);
        ingredients.put("tomate", 1); 
    }

    public Entree(String nom, double prix, Map<String, Integer> ingredients) {
        super(nom, prix, ingredients);
    }

    @Override
    public String afficher() {
        return "Entrée : " + super.afficher();
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}