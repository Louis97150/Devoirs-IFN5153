package uqam.restaurant.commande;

public class Entree extends Plat {
    public Entree(String nom, double prix) {
        super(nom, prix);
        ingredients.put("tomate", 1); 
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}