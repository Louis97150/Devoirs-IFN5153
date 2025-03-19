import java.util.*;

public class Admins {
    private List<Admin> lesAdmins;

    Admins() {
        lesAdmins = new ArrayList<>();
    }

    public List<Admin> getAdmins() {
        return lesAdmins;
    }

    public void ajouterAdmin(Admin admin) {
        lesAdmins.add(admin);
    }

    public Admin supprimerAdmin(int idAdmin) {
        return lesAdmins.remove(idAdmin);
    }

    public Admin getAdmin(int idAdmin) {
        return lesAdmins.get(idAdmin);
    }

    public void setAdmin(int idAdmin, Admin nouveauAdmin) {
        lesAdmins.set(idAdmin, nouveauAdmin);
    }

}
