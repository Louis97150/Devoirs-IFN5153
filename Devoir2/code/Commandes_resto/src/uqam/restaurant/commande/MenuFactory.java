package uqam.restaurant.commande;

public interface MenuFactory {
    Entree creerEntree();
    PlatPrincipal creerPlatPrincipal();
    Dessert creerDessert();
}