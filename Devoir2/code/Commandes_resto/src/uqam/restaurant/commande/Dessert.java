package uqam.restaurant.commande;

public class Dessert extends Plat {
    public Dessert(String nom, double prix) {
        super(nom, prix);
        ingredients.put("sucre", 1);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}