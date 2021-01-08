package reservations;

import logements.Logement;
import outils.MyDate;

public class SejourLong extends Sejour implements ConditionsTarifairesInterface {

	public final int PROMOTION_EN_POURCENTAGE = 20;
	int promotion;

	public SejourLong(MyDate dateArrivee, int nbNuits, Logement logement, int nbVoyageurs) {
		super(dateArrivee, nbNuits, logement, nbVoyageurs);
		this.miseAJourDuTarif();
	}

	@Override
	public boolean beneficiePromotion() {
		return true;
	}

	@Override
	public int getTarif() {
		return this.tarif;
	}

	@Override
	public void afficher(String voyageur)
	{
		System.out.println("Bienvenu chez AirBnB");
		System.out.println("Réservation n°1");
		System.out.print(voyageur);
		this.logement.afficher();
		System.out.println(
			"La date d'arrivée est le " +
			this.dateArrivee +
			" pour " +
			this.nbNuits +
			" nuits."
		);
		System.out.println("Le prix de ce séjour est de " + this.getTarif() + "€ " + (this.beneficiePromotion() ? "(" + this.promotion + "€ de promotion)" : "") + ".");
	}

	/**
	 * Verify if night number is between 1 included and 1 excluded.
	 * For 31 days, there is only 30 nights.
	 */
	@Override
	public boolean verificationNombreDeNuits() {
		return this.nbNuits >= 6 && this.nbNuits < 31;
	}

	/**
	 * Set tarif to the good value depending nights number, price per night and promotion
	 */
	@Override
	protected void miseAJourDuTarif() {
		int basePrice = this.nbNuits * this.logement.tarifParNuit;
		this.promotion = (int)((float)(basePrice / 100.0) * this.PROMOTION_EN_POURCENTAGE);
		this.tarif = basePrice - this.promotion;
	}
}
