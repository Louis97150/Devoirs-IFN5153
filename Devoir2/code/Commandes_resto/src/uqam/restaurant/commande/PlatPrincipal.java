package uqam.restaurant.commande;

public class PlatPrincipal extends Plat {
    public PlatPrincipal(String nom, double prix) {
        super(nom, prix);
        ingredients.put("poulet", 2);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}