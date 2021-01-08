package logements;

import utilisateurs.Hote;

public class Maison extends Logement
{
	int superficieJardin;
	boolean possedePiscine;

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
