package uqam.restaurant.commande;

import java.util.HashMap;
import java.util.Map;

public abstract class Plat implements Menu {
    protected String nom;
    protected double prix;
    protected Map<String, Integer> ingredients;

    public Plat(String nom, double prix) {
        this.nom = nom;
        this.prix = prix;
        this.ingredients = new HashMap<>();
    }

    @Override
    public String afficher() {
        return nom + " (" + prix + "$)";
    }

    @Override
    public double getPrix() {
        return prix;
    }

    @Override
    public Map<String, Integer> getIngredients() {
        return new HashMap<>(ingredients);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Plat cloned = (Plat) super.clone();
        cloned.ingredients = new HashMap<>(this.ingredients);
        return cloned;
    }
}