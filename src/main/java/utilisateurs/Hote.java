package utilisateurs;

import outils.ComparatorInterface;

public class Hote extends Personne
{
	int delaiDeReponse;

	public Hote(String firstName, String lastName, int age, int delaiDeReponse)
	{
		super(firstName, lastName, age);
		this.delaiDeReponse = delaiDeReponse;
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
