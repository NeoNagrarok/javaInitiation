package utilisateurs;

import outils.IDisplayable;

public class Personne implements IDisplayable
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
}
