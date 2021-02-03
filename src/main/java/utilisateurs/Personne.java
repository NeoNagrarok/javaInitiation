package utilisateurs;

import outils.ComparatorInterface;
import outils.IDisplayable;

public abstract class Personne implements IDisplayable, ComparatorInterface
{
	protected final String firstName;
	protected final String lastName;
	protected final int age;

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

	protected String getFirstName()
	{
		return "" + this.firstName;
	}

	protected String getLastName()
	{
		return "" + this.lastName;
	}

	protected int getAge()
	{
		return this.age;
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
