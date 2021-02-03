package logements;

import utilisateurs.Hote;

public final class Maison extends Logement
{
	private final int superficieJardin;
	private final boolean possedePiscine;

	public Maison(
		Hote hote,
		int tarifParNuit,
		String adresse,
		int superficie,
		int nbVoyageurs,
		int superficieJardin,
		boolean possedePiscine
	)
	{
		super(hote, tarifParNuit, adresse, superficie, nbVoyageurs);
		this.superficieJardin = superficieJardin;
		this.possedePiscine = possedePiscine;
	}

	public Logement copy()
	{
		return (Logement)(new Maison(this.hote, this.tarifParNuit, this.adresse, this.superficie, this.nbVoyageurs, this.superficieJardin, this.possedePiscine));
	}

	public int getSuperficieJardin()
	{
		return this.superficieJardin;
	}

	public boolean getPossedePiscine()
	{
		return this.possedePiscine;
	}

	@Override
	public int getSuperficieTotale()
	{
		return this.superficie + this.superficieJardin;
	}

	@Override
	public void afficher()
	{
		this.hote.afficher();
		System.out.println("Le logement est situé au " + this.adresse);
		System.out.println("Superficie : " + this.superficie + "m²");
		System.out.print("Jardin : " + (this.superficieJardin > 0 ? "Oui (" + this.superficieJardin + "m²)" : "Non"));
		System.out.println();
		System.out.println("Piscine : " + (this.possedePiscine ? "Oui" : "Non"));
	}
	
}
