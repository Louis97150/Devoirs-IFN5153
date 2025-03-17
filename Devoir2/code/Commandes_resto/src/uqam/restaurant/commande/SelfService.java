package uqam.restaurant.commande;

public class SelfService implements Builder {
    private MenuCompose menu;

    public SelfService() {
        this.menu = new MenuCompose("Menu Self-Service", 0.0);
    }

    @Override
    public Builder ajouterEntree(Entree entree) {
        menu.ajouterItem(entree);
        return this;
    }

    @Override
    public Builder ajouterPlatPrincipal(PlatPrincipal platPrincipal) {
        menu.ajouterItem(platPrincipal);
        return this;
    }

    @Override
    public Builder ajouterDessert(Dessert dessert) {
        menu.ajouterItem(dessert);
        return this;
    }

    @Override
    public Builder ajouterBoisson(Boisson boisson) {
        menu.ajouterItem(boisson);
        return this;
    }

    @Override
    public MenuCompose build() {
        return menu;
    }
}