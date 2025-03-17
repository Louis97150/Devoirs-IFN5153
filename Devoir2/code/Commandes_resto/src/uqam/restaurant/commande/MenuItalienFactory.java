package uqam.restaurant.commande;

public class MenuItalienFactory implements MenuFactory {
    @Override
    public Entree creerEntree() {
        return new Entree("Salade Caprese", 8.0);
    }

    @Override
    public PlatPrincipal creerPlatPrincipal() {
        return new PlatPrincipal("Pizza Margherita", 12.0);
    }

    @Override
    public Dessert creerDessert() {
        return new Dessert("Tiramisu", 6.0);
    }
}