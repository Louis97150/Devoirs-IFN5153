package uqam.restaurant.commande;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MenuCompose implements Menu {
    private String nom;
    private List<Menu> items;
    private double remise;

    public MenuCompose(String nom, double remise) {
        this.nom = nom;
        this.remise = remise;
        this.items = new ArrayList<>();
    }

    public void ajouterItem(Menu item) {
        items.add(item);
    }

    @Override
    public String afficher() {
        StringBuilder sb = new StringBuilder(nom + " (remise: " + remise + "$)\n");
        for (Menu item : items) {
            sb.append("  - ").append(item.afficher()).append("\n");
        }
        return sb.toString();
    }

    @Override
    public double getPrix() {
        double total = items.stream().mapToDouble(Menu::getPrix).sum();
        return total - remise;
    }

    @Override
    public Map<String, Integer> getIngredients() {
        Map<String, Integer> totalIngredients = new HashMap<>();
        for (Menu item : items) {
            item.getIngredients().forEach((ingredient, quantite) -> {
                totalIngredients.merge(ingredient, quantite, Integer::sum);
            });
        }
        return totalIngredients;
    }
}