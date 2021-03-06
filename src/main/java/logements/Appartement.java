package logements;

import utilisateurs.Hote;

public final class Appartement extends Logement
{
	private final int numeroEtage;
	private final int superficieBalcon;

	public Appartement(
		Hote hote,
		int tarifParNuit,
		String adresse,
		int superficie,
		int nbVoyageurs,
		int numeroEtage,
		int superficieBalcon
	)
	{
		super(hote, tarifParNuit, adresse, superficie, nbVoyageurs);
		this.numeroEtage = numeroEtage;
		this.superficieBalcon = superficieBalcon;
	}

	public Logement copy()
	{
		return (Logement)(new Appartement(this.hote, this.tarifParNuit, this.adresse, this.superficie, this.nbVoyageurs, this.numeroEtage, this.superficieBalcon));
	}

	@Override
	public int getSuperficieTotale() {
		return this.superficie + this.superficieBalcon;
	}

	@Override
	public void afficher() {
		String[] floor = {"rez-de-chaussée.", "1er étage.", "ème"};
		this.hote.afficher();
		System.out.println("Le logement est situé " + this.adresse + " au " + (this.numeroEtage > 1 ? this.numeroEtage + floor[2] + " étage." : floor[this.numeroEtage]));
		System.out.println("Superficie : " + this.superficie + "m²");
		System.out.println("Balcon : " + (this.superficieBalcon > 0 ? " Oui (" + this.superficieBalcon + "m2)" : "Non"));
	}
	
}
