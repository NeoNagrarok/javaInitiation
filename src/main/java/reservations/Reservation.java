package reservations;

import outils.MyDate;
import utilisateurs.Voyageur;

public class Reservation {
	String identifiant;
	Sejour sejour;
	Voyageur voyageur;
	boolean estValidee;
	MyDate dateDeReservation;

	public Reservation(Voyageur voyageur, Sejour sejour, boolean estValidee)
	{
		this.sejour = sejour;
		this.voyageur = voyageur;
		this.estValidee = estValidee;
		this.dateDeReservation = sejour.dateArrivee;
		this.identifiant = (new MyDate()).getTime() + "" + (int) (Math.random() * (1000000));
	}

	public void afficher()
	{
		System.out.print(this.voyageur + " a fait une réservation chez ");
		this.sejour.afficher();
	}
}
