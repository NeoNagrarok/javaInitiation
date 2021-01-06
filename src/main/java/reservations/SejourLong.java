package reservations;

import logements.Logement;
import outils.MyDate;

public class SejourLong extends Sejour implements ConditionsTarifairesInterface {

	public final int PROMOTION_EN_POURCENTAGE;
	int promotion;
	int tarif;

	public SejourLong(MyDate dateArrivee, int nbNuits, Logement logement, int nbVoyageurs, int promotion_en_pourcentage) {
		super(dateArrivee, nbNuits, logement, nbVoyageurs);
		this.PROMOTION_EN_POURCENTAGE = promotion_en_pourcentage;
		int basePrice = this.nbNuits * this.logement.tarifParNuit;
		this.promotion = basePrice / 100 * this.PROMOTION_EN_POURCENTAGE;
		this.tarif = basePrice - this.promotion;
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
}
