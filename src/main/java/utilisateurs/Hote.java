package utilisateurs;

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
}
