package uqam.restaurant.stock;


import java.util.HashMap;
import java.util.Map;

public class Stock {
    private static Stock instance;
    private Map<String, Integer> mapIngredients;

    private Stock() {
        this.mapIngredients = new HashMap<>();
        mapIngredients.put("tomate", 1);
        mapIngredients.put("fromage", 3);
        mapIngredients.put("poulet", 5);
    }

    
    public static Stock getInstance() {
        if (instance == null) {
            instance = new Stock();
        }
        return instance;
    }

    
    public boolean confirmerIngredientExiste(String ingredientNom) {
        return mapIngredients.containsKey(ingredientNom);
    }

    
    public Map<String, Integer> getMapIngredients() {
        return new HashMap<>(mapIngredients); 
    }

    
    public void miseAJourIngredientQuantite(String ingredientNom, int updateMontant) {
        if (mapIngredients.containsKey(ingredientNom)) {
            int nouvelleQuantite = mapIngredients.get(ingredientNom) + updateMontant;
            if (nouvelleQuantite <= 0) {
                throw new IllegalStateException("Stock insuffisant pour " + ingredientNom);
            }
            mapIngredients.put(ingredientNom, nouvelleQuantite);
        } else {
            throw new IllegalArgumentException("Ingrédient " + ingredientNom + " non trouvé.");
        }
    }

    public void retirerIngredient(String ingredientNom) {
        mapIngredients.remove(ingredientNom);
    }

    
    public void ajouterIngredient(String ingredientNom, int quantite) {
        if (quantite <= 0) {
            throw new IllegalArgumentException("La quantité doit être 0 ou plus.");
        }
        mapIngredients.put(ingredientNom, quantite);
    }

    public int getQuantiteIngredient(String nom) {
        return mapIngredients.getOrDefault(nom, 0);
    }
}