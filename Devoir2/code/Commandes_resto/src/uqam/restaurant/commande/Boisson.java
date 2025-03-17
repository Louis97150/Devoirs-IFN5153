package uqam.restaurant.commande;

import java.util.HashMap;
import java.util.Map;

public class Boisson implements Menu{
    private String nom;
    private double prix;

    public Boisson(String nom, double prix) {
        this.nom = nom;
        this.prix = prix;
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
        return new HashMap<>();
    }
}
