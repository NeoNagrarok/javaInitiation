package reservations;

import logements.Logement;
import outils.MyDate;

public class SejourCourt extends Sejour implements ConditionsTarifairesInterface {

	public SejourCourt(MyDate dateArrivee, int nbNuits, Logement logement, int nbVoyageurs) {
		super(dateArrivee, nbNuits, logement, nbVoyageurs);
	}

	@Override
	public boolean beneficiePromotion() {
		return false;
	}

	@Override
	public int getTarif() {
		return this.tarif;
	}

	/**
	 * Verify if night number is between 1 included and 1 excluded.
	 * For 31 days, there is only 30 nights.
	 */
	@Override
	public boolean verificationNombreDenuits() {
		return this.nbNuits >= 1 && this.nbNuits < 6;
	}

	/**
	 * Set tarif to the good value depending nights number and price per night
	 */
	@Override
	protected void miseAJourDuTarif() {
		this.tarif = this.nbNuits * this.logement.tarifParNuit;
	}
}
