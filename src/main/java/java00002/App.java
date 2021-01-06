package java00002;

import logements.Appartement;
import logements.Logement;
import logements.Maison;
import outils.MyDate;
import outils.Utile;
import reservations.Reservation;
import reservations.Sejour;
import reservations.SejourCourt;
import reservations.SejourLong;
import utilisateurs.Hote;
import utilisateurs.Voyageur;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Voyageur personneUn = new Voyageur(
            "Maxime",
            "Albert",
            29
        );
        // personneUn.afficher();
        Logement logementUn = new Appartement(
            new Hote(
                "Peter",
                "Bardu",
                28,
                12
            ),
            40,
            "81 rue Colbert, 37000 Tours",
            140,
            2,
            15,
            10
        );
        // logementUn.afficher();
        Sejour sejourUn = new SejourLong(new MyDate("12/05/2016"), 4, logementUn, 2, 50);
        // sejourUn.afficher();
        Reservation reservationUn = new Reservation(personneUn, sejourUn, true);
        reservationUn.afficher();

        Utile.separator();

        Sejour sejourDeux = new SejourCourt(new MyDate("12/05/2016"), 4, logementUn, 2);
        reservationUn = new Reservation(personneUn, sejourDeux, true);
        reservationUn.afficher();

        System.out.println();
        Utile.getDate(5, 12, 2022);
        // System.out.println(new MyDate());
    }
}
