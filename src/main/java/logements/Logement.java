package logements;

import outils.ComparatorInterface;
import outils.IDisplayable;
import utilisateurs.Hote;

public abstract class Logement implements IDisplayable, ComparatorInterface
{
	protected Hote hote;
	protected int tarifParNuit;
	protected String adresse;
	protected int superficie;
	protected int nbVoyageurs;
	protected String name;

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
		return new Hote(this.hote);
	}

	public int getTarifParNuit() {
		return this.tarifParNuit;
	}

	public String getAdresse() {
		return "" + this.adresse;
	}

	public int getSuperficie() {
		return this.superficie;
	}

	public int getNbVoyageurs() {
		return this.nbVoyageurs;
	}

	public String getName()
	{
		return "" + this.name;
	}

	public void setName(String name)
	{
		this.name = "" + name;
	}

	public ComparatorInterface getHigher(ComparatorInterface item)
	{
		if (!(item instanceof Logement) || this.tarifParNuit > ((Logement)item).getTarifParNuit())
			return (ComparatorInterface)this;
		return item;
	};

	public ComparatorInterface getLower(ComparatorInterface item)
	{
		if (!(item instanceof Logement) || this.tarifParNuit < ((Logement)item).getTarifParNuit())
			return (ComparatorInterface)this;
		return item;
	};

	public abstract int getSuperficieTotale();
	public abstract void afficher();
	public abstract Logement copy();
}
