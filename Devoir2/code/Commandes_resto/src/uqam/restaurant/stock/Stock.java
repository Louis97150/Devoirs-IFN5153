package uqam.restaurant.stock;


import java.util.HashMap;
import java.util.Map;

public class Stock {
    private static Stock instance;
    private Map<String, Integer> mapIngredients;

    private Stock() {
        this.mapIngredients = new HashMap<>();
        remplirStock();
    }

    
    public static Stock getInstance() {
        if (instance == null) {
            instance = new Stock();
            
        }
        return instance;
    }

    //Fonction pour remplir le stock quand on initialise le Singleton
    private void remplirStock() {
        this.ajouterIngredient("tomate", 15);
        this.ajouterIngredient("fromage", 13);
        this.ajouterIngredient("poulet", 15);
        this.ajouterIngredient("laitue", 20);
        this.ajouterIngredient("concombre", 17);
        this.ajouterIngredient("steak", 25);
        this.ajouterIngredient("creme glace", 13);
        this.ajouterIngredient("mozzarella", 15);
        this.ajouterIngredient("basilic", 15);
        this.ajouterIngredient("pate pizza", 20);
        this.ajouterIngredient("sauce tomate", 15);
        this.ajouterIngredient("oeuf", 30);
        this.ajouterIngredient("sucre", 25);
        this.ajouterIngredient("mascarpone", 12);
        this.ajouterIngredient("miso", 15);
        this.ajouterIngredient("oignon", 10);
        this.ajouterIngredient("dashi", 9);
        this.ajouterIngredient("champignon", 15);
        this.ajouterIngredient("riz", 30);
        this.ajouterIngredient("brocoli", 21);
        this.ajouterIngredient("pain", 34);
    }

    
    public void miseAJourIngredientQuantite(String ingredientNom, int updateMontant) throws IllegalStateException, IllegalArgumentException {
        if (mapIngredients.containsKey(ingredientNom.toLowerCase())) {
            int nouvelleQuantite = mapIngredients.get(ingredientNom.toLowerCase()) + updateMontant;
            if (nouvelleQuantite <= 0) {
                throw new IllegalStateException("Stock insuffisant pour " + ingredientNom.toLowerCase());
            }
            System.out.println(ingredientNom.toLowerCase() + ": " + mapIngredients.get(ingredientNom.toLowerCase()) + " -> " + nouvelleQuantite);
            mapIngredients.put(ingredientNom.toLowerCase(), nouvelleQuantite);
        } else {
            throw new IllegalArgumentException("Ingrédient " + ingredientNom.toLowerCase() + " non trouvé.");
        }
    }

    public void retirerIngredient(String ingredientNom) {
        mapIngredients.remove(ingredientNom.toLowerCase());
    }

    
    public void ajouterIngredient(String ingredientNom, int quantite) {
        if (quantite <= 0) {
            throw new IllegalArgumentException("La quantité doit être 0 ou plus.");
        }
        mapIngredients.put(ingredientNom.toLowerCase(), quantite);
    }

    public int getQuantiteIngredient(String nom) {
        return mapIngredients.getOrDefault(nom, 0);
    }
}