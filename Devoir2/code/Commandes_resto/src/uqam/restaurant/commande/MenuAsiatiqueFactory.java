package uqam.restaurant.commande;

public class MenuAsiatiqueFactory implements MenuFactory {
    @Override
    public Entree creerEntree() {
        return new Entree("Soupe Miso", 5.0);
    }

    @Override
    public PlatPrincipal creerPlatPrincipal() {
        return new PlatPrincipal("Poulet Teriyaki", 15.0);
    }

    @Override
    public Dessert creerDessert() {
        return new Dessert("Mochi", 4.0);
    }
}