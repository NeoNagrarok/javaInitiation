package reservations;

import java.io.FileWriter;
import java.io.IOException;

import menu.Menu;
import outils.IDisplayable;
import outils.MyDate;
import outils.dateArriveeException;
import outils.nombreDeNuitException;
import outils.nombreDeVoyageurException;
import utilisateurs.Voyageur;

public final class Reservation implements IDisplayable {
	private final String identifiant;
	private final Sejour sejour;
	private final Voyageur voyageur;
	private boolean estValidee;
	private MyDate dateDeReservation;

	public Reservation(Voyageur voyageur, Sejour sejour, boolean estValidee) throws Exception {
		if (!sejour.verificationDateArrivee())
			throw new dateArriveeException();

		if(!sejour.verificationNombreDeVoyageurs())
			throw new nombreDeVoyageurException();

		if (!sejour.verificationNombreDeNuits())
			throw new nombreDeNuitException();

		this.sejour = sejour;
		this.voyageur = voyageur;
		this.estValidee = estValidee;
		this.dateDeReservation = sejour.dateArrivee;
		this.identifiant = (new MyDate()).getTime() + "" + (int) (Math.random() * (1000000));
	}

	public void afficher() {
		this.sejour.afficher(this.voyageur + " a fait une réservation chez ");
	}

	public void log(String toLog) {
		try {
			FileWriter fw = new FileWriter("resa", true);
			fw.write(toLog);
			fw.close();
		} catch (IOException e) {
			System.out.println(Menu.RED + "Impossible d'écrire dans le fichier 'resa'" + Menu.RESET);
		}
	}
}
