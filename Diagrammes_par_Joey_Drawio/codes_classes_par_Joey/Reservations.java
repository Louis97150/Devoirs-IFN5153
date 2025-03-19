import java.util.*;

public class Reservations {
    private List<Reservation> lesReservations;

    Reservations() {
        lesReservations = new ArrayList<>();
    }

    public List<Reservation> getReservations() {
        return lesReservations;
    }

    public void ajouterReservation(Reservation Reservation) {
        lesReservations.add(Reservation);
    }

    public Reservation getReservation(int idReservation) {
        return lesReservations.get(idReservation);
    }    


}
