package uqam.restaurant.main;

import uqam.restaurant.commande.*;
import uqam.restaurant.facade.FacadeResto;
import uqam.restaurant.stock.Stock;

public class Main {
    public static void main(String[] args) {
        
        FacadeResto facade = new FacadeResto();

        
        Commande commande = new Commande("CMD001");

        
        MenuFactory factory = new MenuItalienFactory();
        MenuCompose menuItalien = new MenuCompose("Menu Italien", 5.0); // Remise de 5$
        menuItalien.ajouterItem(factory.creerEntree());
        menuItalien.ajouterItem(factory.creerPlatPrincipal());
        menuItalien.ajouterItem(factory.creerDessert());
        commande.ajouterItem(menuItalien);

        
        SelfService builder = new SelfService();
        MenuCompose menuSelfService = builder
                .ajouterEntree(new Entree("Salade Verte", 6.0))
                .ajouterPlatPrincipal(new PlatPrincipal("Steak", 20.0))
                .ajouterBoisson(new Boisson("Eau", 2.0))
                .build();
        commande.ajouterItem(menuSelfService);

        
        Plat plat = new PlatPrincipal("Burger", 10.0);
        Menu platAvecSupplement = new SupplementFromage(new SupplementSauce(plat));
        commande.ajouterItem(platAvecSupplement);

        
        commande.changerEtat("validée");
        System.out.println("Détails de la commande :");
        System.out.println(commande);

        
        facade.setCommande(commande);
        try {
            facade.majStock();
            System.out.println("Stock mis à jour :");
            Stock stock = Stock.getInstance();
            stock.getMapIngredients().forEach((ingredient, quantite) ->
                    System.out.println(ingredient + ": " + quantite));
        } catch (IllegalStateException e) {
            System.err.println("Erreur lors de la mise à jour du stock : " + e.getMessage());
        }

        boolean paiementReussi = facade.payerCommande(commande.getPrixTotal(), "carte");
        System.out.println("Paiement " + (paiementReussi ? "réussi" : "échoué"));
    }
}