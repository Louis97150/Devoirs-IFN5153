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

    public void verfierStock() throws IllegalStateException {
        if (commande != null) {
            for (var item : commande.getListeIngredients().entrySet()) {
                if (stock.getQuantiteIngredient(item.getKey().toLowerCase()) < item.getValue()) {
                    throw new IllegalStateException("Stock insuffisant pour " + item.getKey().toLowerCase());
                }
            }

            commande.changerEtat("valide");
        }
    }

    public void majStock() throws IllegalStateException, IllegalArgumentException{
        if (commande != null) {
            for (var item : commande.getListeIngredients().entrySet()) {
                stock.miseAJourIngredientQuantite(item.getKey().toLowerCase(), -item.getValue());
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

    public Stock getStock() {
        return this.stock;
    }
}