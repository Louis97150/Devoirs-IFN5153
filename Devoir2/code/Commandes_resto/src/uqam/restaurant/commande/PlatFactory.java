package uqam.restaurant.commande;

import java.util.*;

public interface PlatFactory {
    public abstract Plat creerPlat(String nom, double prix, Map<String, Integer> ingredients);

}
