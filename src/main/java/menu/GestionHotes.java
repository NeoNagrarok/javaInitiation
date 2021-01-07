package menu;

import utilisateurs.Hote;

public class GestionHotes {

	static void listerHotes() {
		System.out.println(
			"-------------------------------------\n"	+
			"Liste des Hôtes \n"						+
			"Saisir une option : \n"					+
			"1 : Ajoutez un hôte\n"						+
			"2 : Supprimer un hôte\n"					+
			"3 : Retour"
		);

		switch (Menu.choix(3)) {
			case 1:
				try {
					GestionHotes.ajouterHote();
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			case 2:
				GestionHotes.supprimerHote();
				break;
			case 3:
				Menu.listerMenu();
				break;
			default:
				break;
		}
	}

	private static void supprimerHote() {
	}

	private static void ajouterHote() throws Exception {
		System.out.print("Entrez le prénom : ");
		String firstName = Menu.sc.nextLine();
		System.out.print("\nEntrez le nom : ");
		String lastName = Menu.sc.nextLine();
		System.out.print("\nEntrez l'âge : ");
		int age = Menu.sc.nextInt();

		Hote hote = new Hote(firstName, lastName, age, 12);
		hote.afficher();
	}
}
