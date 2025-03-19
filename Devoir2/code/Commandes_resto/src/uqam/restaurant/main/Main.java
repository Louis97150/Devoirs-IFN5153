package uqam.restaurant.main;

import java.util.Map;

import uqam.restaurant.commande.*;
import uqam.restaurant.facade.FacadeResto;
import uqam.restaurant.stock.Stock;

public class Main {
    public static void main(String[] args) {

        FacadeResto facade = new FacadeResto();

        //Création de plats et menus régionaux
        CreateurEntree creEntree = new CreateurEntree();
        CreateurPlatPrincipal crePrincipal = new CreateurPlatPrincipal();
        CreateurDessert creDessert = new CreateurDessert();

        Entree salade = (Entree) creEntree.creerPlat("Salade verte", 6, Map.of("laitue", 1, "tomate", 1, "concombre", 1));
        PlatPrincipal steak = (PlatPrincipal) crePrincipal.creerPlat("Steak", 20.0, Map.of("steak", 1));
        Dessert cremeGlace = (Dessert) creDessert.creerPlat("Crème glacé", 3, Map.of("creme glace", 1));
        PlatPrincipal burger = (PlatPrincipal) crePrincipal.creerPlat("Burger", 15.50, Map.of("pain", 2, "steak", 1, "tomate", 1, "fromage", 1));

        MenuFactory factoryItalien = new MenuItalienFactory();
        MenuCompose menuItalien = factoryItalien.creerMenu();
        

        // Produire une commande
        Commande commande = new Commande("CMD001");
       
        commande.ajouterItem(menuItalien);

        SelfService builder = new SelfService();
        MenuCompose menuSelfService = builder
                .ajouterEntree(salade)
                .ajouterPlatPrincipal(steak)
                .ajouterBoisson(new Boisson("Eau", 2.0))
                .build();
        commande.ajouterItem(menuSelfService);        
        
        Menu platAvecSupplement = new SupplementFromage(new SupplementSauce(burger));
        commande.ajouterItem(platAvecSupplement);
        
        // Compléter la commande:
        try {
            facade.setCommande(commande);

            // Affiché les détails de la commande:
            System.out.println("Détails de la commande :");
            System.out.println(commande + "\n");

            // Valider les quantités d'ingrédients
            facade.verfierStock();
        
            

            System.out.println("Stock mis à jour :");
            facade.majStock();
            
            System.out.println();
            boolean paiementReussi = facade.payerCommande(commande.getPrixTotal(), "carte");
            System.out.println("Paiement " + (paiementReussi ? "réussi" : "échoué"));
            if (paiementReussi) {
                facade.getCommande().changerEtat("Payer");
            }
        } catch (IllegalStateException | IllegalArgumentException e) {
            System.err.println("Erreur lors de la mise à jour du stock : " + e.getMessage());
            System.out.println("La commande ne peut pas procédé dù à un manque d'ingrédients!");
            facade.getCommande().changerEtat("Refuser");
        }

        
    }
}