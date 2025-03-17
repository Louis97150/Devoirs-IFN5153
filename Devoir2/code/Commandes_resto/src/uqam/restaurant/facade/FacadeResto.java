package uqam.restaurant.facade;

import uqam.restaurant.commande.Commande;
import uqam.restaurant.paiement.SystemePaiement;
import uqam.restaurant.stock.Stock;

public class FacadeResto {
    private Commande commande;
    private Stock stock;
    private SystemePaiement paiement;

    public FacadeResto() {
        this.stock = Stock.getInstance();
        this.paiement = SystemePaiement.getInstance();
    }

    public void majStock() {
        if (commande != null) {
            for (var item : commande.getListeItems()) {
                item.getIngredients().forEach((ingredient, quantite) -> {
                    stock.miseAJourIngredientQuantite(ingredient, -quantite);
                });
            }
        }
    }

    public boolean payerCommande(double somme, String typePaiement) {
        return paiement.effectuerPaiement(somme, typePaiement);
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public Commande getCommande() {
        return commande;
    }
}