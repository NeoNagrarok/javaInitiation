package utilisateurs;

import outils.ComparatorInterface;
import outils.IDisplayable;

public class Personne implements IDisplayable, ComparatorInterface
{
	String firstName;
	String lastName;
	int age;

	public Personne(String firstName, String lastName, int age)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}

	public void afficher()
	{
		System.out.println(this);
	}

	public String toString()
	{
		return this.firstName + " " + this.lastName + " (" + this.age + " ans)";
	}

	public ComparatorInterface getHigher(ComparatorInterface item)
	{
		if (!(item instanceof Personne) || this.age > ((Personne)item).age)
			return (ComparatorInterface)this;
		return item;
	};

	public ComparatorInterface getLower(ComparatorInterface item)
	{
		if (!(item instanceof Personne) || this.age < ((Personne)item).age)
			return (ComparatorInterface)this;
		return item;
	};
}
