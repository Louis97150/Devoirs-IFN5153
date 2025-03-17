package uqam.restaurant.paiement;

public class SystemePaiement {
    private static SystemePaiement instance;
    private ProcesseurPaiement processeurPaiement;

    private SystemePaiement() {
        this.processeurPaiement = new PaiementCash();
    }

    public static SystemePaiement getInstance() {
        if (instance == null) {
            instance = new SystemePaiement();
        }
        return instance;
    }

    public void setProcesseurPaiement(ProcesseurPaiement processeurPaiement) {
        this.processeurPaiement = processeurPaiement;
    }

    public boolean effectuerPaiement(double somme, String typePaiement) {
        switch (typePaiement.toLowerCase()) {
            case "carte" -> setProcesseurPaiement(new PaiementCarte());
            case "mobile" -> setProcesseurPaiement(new PaiementMobile());
            case "cash" -> setProcesseurPaiement(new PaiementCash());
            default -> throw new IllegalAccessError("Type de paiement non supporté.");
        }
        return processeurPaiement.traiterPaiement(somme);
    }
}
