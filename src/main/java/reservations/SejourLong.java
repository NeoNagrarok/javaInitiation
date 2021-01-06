package reservations;

import logements.Logement;
import outils.MyDate;

public class SejourLong extends Sejour implements ConditionsTarifairesInterface {

	public final int PROMOTION_EN_POURCENTAGE;
	int promotion;

	public SejourLong(MyDate dateArrivee, int nbNuits, Logement logement, int nbVoyageurs, int promotion_en_pourcentage) {
		super(dateArrivee, nbNuits, logement, nbVoyageurs);
		this.PROMOTION_EN_POURCENTAGE = promotion_en_pourcentage;
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
	public boolean verificationNombreDenuits() {
		return this.nbNuits >= 1 && this.nbNuits < 31;
	}

	/**
	 * Set tarif to the good value depending nights number, price per night and promotion
	 */
	@Override
	protected void miseAJourDuTarif() {
		int basePrice = this.nbNuits * this.logement.tarifParNuit;
		this.promotion = basePrice / 100 * this.PROMOTION_EN_POURCENTAGE;
		this.tarif = basePrice - this.promotion;
	}
}
