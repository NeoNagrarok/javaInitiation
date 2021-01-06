package reservations;

import logements.Logement;
import outils.MyDate;

public class SejourCourt extends Sejour implements ConditionsTarifairesInterface {

	int tarif;

	public SejourCourt(MyDate dateArrivee, int nbNuits, Logement logement, int nbVoyageurs) {
		super(dateArrivee, nbNuits, logement, nbVoyageurs);
		this.tarif = this.nbNuits * this.logement.tarifParNuit;
	}

	@Override
	public boolean beneficiePromotion() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getTarif() {
		// TODO Auto-generated method stub
		return this.tarif;
	}
	
}
