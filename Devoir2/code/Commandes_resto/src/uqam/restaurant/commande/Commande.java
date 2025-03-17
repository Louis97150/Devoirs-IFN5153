package uqam.restaurant.commande;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    public void ajouterItem(Menu item) {
        listeItems.add(item);
        calculerPrixTotal();
    }

    public void changerEtat(String nouvelEtat) {
        this.etat = nouvelEtat;
    }

    public double calculerPrixTotal() {
        this.prixTotal = listeItems.stream().mapToDouble(Menu::getPrix).sum();
        return prixTotal;
    }

    public List<Menu> getListeItems() {
        return new ArrayList<>(listeItems);
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