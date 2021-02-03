package utilisateurs;

import outils.ComparatorInterface;

public final class Hote extends Personne
{
	private final int delaiDeReponse;

	public Hote(String firstName, String lastName, int age, int delaiDeReponse)
	{
		super(firstName, lastName, age);
		this.delaiDeReponse = delaiDeReponse;
	}

	public Hote(Hote src)
	{
		super(src.getFirstName(), src.getLastName(), src.getAge());
		this.delaiDeReponse = src.getDelaiDeReponse();
	}

	private int getDelaiDeReponse() {
		return this.delaiDeReponse;
	}

	@Override
	public void afficher()
	{
		System.out.println(this + " qui s'engage à répondre dans " + (this.delaiDeReponse == 1 ? "l'heure" : "les " + this.delaiDeReponse + " heures"));
	}

	@Override
	public ComparatorInterface getHigher(ComparatorInterface item)
	{
		if (!(item instanceof Hote) || this.delaiDeReponse > ((Hote)item).delaiDeReponse)
			return (ComparatorInterface)this;
		return item;
	};

	@Override
	public ComparatorInterface getLower(ComparatorInterface item)
	{
		if (!(item instanceof Hote) || this.delaiDeReponse < ((Hote)item).delaiDeReponse)
			return (ComparatorInterface)this;
		return item;
	};
}
