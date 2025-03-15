public interface ProcesseurPaiement {
    boolean traiterPaiement(double somme);

    boolean rembourser(double somme);
}
