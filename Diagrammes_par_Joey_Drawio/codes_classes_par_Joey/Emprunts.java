import java.util.*;

public class Emprunts {
    private List<Emprunt> lesEmprunts;

    Emprunts() {
        lesEmprunts = new ArrayList<>();
    }

    public List<Emprunt> getEmprunts() {
        return lesEmprunts;
    }

    public void ajouterEmprunt(Emprunt emprunt) {
        lesEmprunts.add(emprunt);
    }

    public Emprunt getEmprunt(int idEmprunt) {
        return lesEmprunts.get(idEmprunt);
    }    

}
