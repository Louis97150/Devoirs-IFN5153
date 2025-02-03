public class App {
    public static void main(String[] args) throws Exception {
        GererRess res = new GererRess();
        res.ajoutRessource("type", "titre", "auteur", "sujet", true);
        res.modifRess("titre", "nsujet", "nauteur", "ntype", "ntitre", false);
        res.afficherRessources();
    }
}
