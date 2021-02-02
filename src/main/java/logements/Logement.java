package logements;

import outils.ComparatorInterface;
import outils.IDisplayable;
import utilisateurs.Hote;

public abstract class Logement implements IDisplayable, ComparatorInterface
{
	Hote hote;
	public int tarifParNuit;
	String adresse;
	int superficie;
	int nbVoyageurs;
	String name;

	public Logement(Hote hote, int tarifParNuit, String adresse, int superficie, int nbVoyageurs)
	{
		this.hote = hote;
		this.tarifParNuit = tarifParNuit;
		this.adresse = adresse;
		this.superficie = superficie;
		this.nbVoyageurs = nbVoyageurs;
		this.name = "";
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

	public String getName()
	{
		return this.name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public ComparatorInterface getHigher(ComparatorInterface item)
	{
		if (!(item instanceof Logement) || this.tarifParNuit > ((Logement)item).tarifParNuit)
			return (ComparatorInterface)this;
		return item;
	};

	public ComparatorInterface getLower(ComparatorInterface item)
	{
		if (!(item instanceof Logement) || this.tarifParNuit < ((Logement)item).tarifParNuit)
			return (ComparatorInterface)this;
		return item;
	};

	public abstract int getSuperficieTotale();
	public abstract void afficher();

}
