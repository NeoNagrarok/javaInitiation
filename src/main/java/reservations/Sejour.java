package reservations;

import logements.Logement;
import outils.IDisplayable;
import outils.MyDate;

public abstract class Sejour implements SejourInterface, IDisplayable
{
	MyDate dateArrivee;
	int nbNuits;
	Logement logement;
	int nbVoyageurs;
	int tarif;

	public Sejour(MyDate dateArrivee, int nbNuits, Logement logement, int nbVoyageurs)
	{
		this.dateArrivee = dateArrivee;
		this.nbNuits = nbNuits;
		this.logement = logement;
		this.nbVoyageurs = nbVoyageurs;
		this.miseAJourDuTarif();
	}

	public void afficher(String voyageur)
	{
		System.out.print(voyageur);
		this.logement.afficher();
		System.out.println(
			"La date d'arrivée est le " +
			this.dateArrivee +
			" pour " +
			this.nbNuits +
			" nuits."
		);
		System.out.println("Le prix de ce séjour est de " + (this.nbNuits * this.logement.tarifParNuit) + "€.");
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
		System.out.println("Le prix de ce séjour est de " + (this.nbNuits * this.logement.tarifParNuit) + "€.");
	}

	/**
	 * Verify if start date is valid.
	 * Start date must be greater or egual than today plus 24h to be valid
	 * 24 hours, 60 minutes, 60 secondes, 60 millisecondes are used for the comparison
	 */
	@Override
	public boolean verificationDateArrivee() {
		return this.dateArrivee.getTime() >= System.currentTimeMillis() + 24 * 60 * 60 * 1000;
	}

	/**
	 * Verify if the trvelers number is valid.
	 */
	@Override
	public boolean verificationNombreDeVoyageurs() {
		return this.nbVoyageurs <= this.logement.getNbVoyageurs();
	}

	protected abstract void miseAJourDuTarif();
}
