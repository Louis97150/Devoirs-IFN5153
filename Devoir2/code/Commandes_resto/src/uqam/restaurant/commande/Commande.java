package uqam.restaurant.commande;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Commande {
    private String idCommande;
    private Date date;
    private String etat;
    private double prixTotal;
    private List<Menu> listeItems;

    public Commande(String idCommande) {
        this.idCommande = idCommande;
        this.date = new Date();
        this.etat = "en attente";
        this.prixTotal = 0.0;
        this.listeItems = new ArrayList<>();
    }

    private double calculerPrixTotal() {
        this.prixTotal = listeItems.stream().mapToDouble(Menu::getPrix).sum();
        return prixTotal;
    }

    public void ajouterItem(Menu item) {
        listeItems.add(item);
        calculerPrixTotal();
    }

    public void changerEtat(String nouvelEtat) {
        this.etat = nouvelEtat;
    }

    public List<Menu> getListeItems() {
        return new ArrayList<>(listeItems);
    }

    public Map<String, Integer> getListeIngredients() {
        Map<String, Integer> mapIngredients = new HashMap<>();
        for (Menu item : listeItems) {
            item.getIngredients().forEach((ingredient, quantite) -> {
                if (mapIngredients.containsKey(ingredient)) {
                    mapIngredients.put(ingredient, quantite + mapIngredients.get(ingredient));
                } else {
                    mapIngredients.put(ingredient, quantite);
                }
                
            });
            
        }

        return mapIngredients;
    }

    public double getPrixTotal() {
        return prixTotal;
    }

    public String getEtat() {
        return etat;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Commande #" + idCommande + " (" + etat + ")\n");
        for (Menu item : listeItems) {
            sb.append(item.afficher()).append("\n");
        }
        sb.append("Prix total : ").append(prixTotal).append("$");
        return sb.toString();
    }
}