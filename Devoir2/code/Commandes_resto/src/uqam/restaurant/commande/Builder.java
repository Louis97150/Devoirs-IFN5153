package uqam.restaurant.commande;

public interface Builder {
    Builder ajouterEntree(Entree entree);
    Builder ajouterPlatPrincipal(PlatPrincipal platPrincipal);
    Builder ajouterDessert(Dessert dessert);
    Builder ajouterBoisson(Boisson boisson);
    MenuCompose build();
}