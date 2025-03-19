package uqam.restaurant.commande;

import java.util.Map;

public class MenuAsiatiqueFactory implements MenuFactory {
    
    private Entree creerEntree() {
        return new Entree("Soupe Miso", 5.0,
                            Map.of("miso", 1,"dashi", 1));
    }

    private PlatPrincipal creerPlatPrincipal() {
        return new PlatPrincipal("Poulet Teriyaki", 15.0,
                            Map.of("poulet", 1, "oignon", 1, "champignon", 2, "riz", 2, "brocoli", 1));
    }

    private Dessert creerDessert() {
        return new Dessert("Mochi", 4.0,
                            Map.of("riz", 1, "sucre", 1));
    }

    @Override
    public MenuCompose creerMenu() {
        MenuCompose menuAsiatique = new MenuCompose("Menu asiatique", 3.00);

        menuAsiatique.ajouterItem(creerEntree());
        menuAsiatique.ajouterItem(creerPlatPrincipal());
        menuAsiatique.ajouterItem(creerDessert());

        return menuAsiatique;

    }
}