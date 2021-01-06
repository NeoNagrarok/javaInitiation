package logements;

import utilisateurs.Hote;

public abstract class Logement
{
	Hote hote;
	public int tarifParNuit;
	String adresse;
	int superficie;
	int nbVoyageurs;

	public Logement(Hote hote, int tarifParNuit, String adresse, int superficie, int nbVoyageurs)
	{
		this.hote = hote;
		this.tarifParNuit = tarifParNuit;
		this.adresse = adresse;
		this.superficie = superficie;
		this.nbVoyageurs = nbVoyageurs;
	}

	public Hote getHote() {
		return this.hote;
	}

	public int getTarifParNuit() {
		return this.tarifParNuit;
	}

	public String getAdresse() {
		return this.adresse;
	}

	public int getSuperficie() {
		return this.superficie;
	}

	public int getNbVoyageurs() {
		return this.nbVoyageurs;
	}

	public abstract int getSuperficieTotale();
	public abstract void afficher();

}
