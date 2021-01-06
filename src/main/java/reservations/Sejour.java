package reservations;

import logements.Logement;
import outils.MyDate;

public class Sejour
{
	MyDate dateArrivee;
	int nbNuits;
	Logement logement;
	int nbVoyageurs;

	public Sejour(MyDate dateArrivee, int nbNuits, Logement logement, int nbVoyageurs)
	{
		this.dateArrivee = dateArrivee;
		this.nbNuits = nbNuits;
		this.logement = logement;
		this.nbVoyageurs = nbVoyageurs;
	}

	public void afficher()
	{
		this.logement.afficher();
		System.out.println(
			"La date d'arrivée est le " +
			this.dateArrivee +
			" pour " +
			this.nbNuits +
			" nuits."
		);
		System.out.println("Le prix de ce séjour est de " + (this.nbNuits * logement.tarifParNuit) + "€.");
	}
}
