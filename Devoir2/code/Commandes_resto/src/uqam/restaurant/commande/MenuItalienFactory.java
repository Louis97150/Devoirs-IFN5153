package uqam.restaurant.commande;

import java.util.Map;

public class MenuItalienFactory implements MenuFactory {

    private Entree creerEntree() {
        return new Entree("Salade Caprese", 8.0,
                            Map.of("tomate", 1,"mozzarella", 1,"basilic", 1));
    }

    private PlatPrincipal creerPlatPrincipal() {
        return new PlatPrincipal("Pizza Margherita", 12.0,
                            Map.of("pate pizza", 1, "sauce tomate", 1,"mozzarella", 1));
    }

    private Dessert creerDessert() {
        return new Dessert("Tiramisu", 6.0,
                            Map.of("Oeuf", 1,"Sucre", 1, "mascarpone", 1));
    }

    @Override
    public MenuCompose creerMenu() {
        MenuCompose menuItalien = new MenuCompose("Menu italien", 5.00);

        menuItalien.ajouterItem(creerEntree());
        menuItalien.ajouterItem(creerPlatPrincipal());
        menuItalien.ajouterItem(creerDessert());
        System.out.println(menuItalien.afficher());

        return menuItalien;

    }
}