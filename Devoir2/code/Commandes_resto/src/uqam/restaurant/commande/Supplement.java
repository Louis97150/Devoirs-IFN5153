package uqam.restaurant.commande;

import java.util.Map;

public abstract class Supplement implements Menu {
    protected Menu platDecore;

    public Supplement(Menu platDecore) {
        this.platDecore = platDecore;
    }
}