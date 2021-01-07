package menu;

import utilisateurs.Hote;

public class GestionHotes {

	static void listerHotes() {
		System.out.println("-------------------------------------\n" + "Liste des Hôtes\n");
		int size = Menu.listHote.size();
		for (int i = 0; i < size; i++) {
			System.out.print((i + 1) + " : ");
			Menu.listHote.get(i).afficher();
		}
		System.out.println(
				"\nSaisir une option : \n" + "1 : Ajoutez un hôte\n" + "2 : Supprimer un hôte\n" + "3 : Retour");

		switch (Menu.choix(3)) {
			case 1:
				try {
					GestionHotes.ajouterHote();
				} catch (Exception e) {
					System.out.println("Mauvais entrée, réessayez");
					Menu.sc.nextLine();
				}
				GestionHotes.listerHotes();
				break;
			case 2:
				try {
					GestionHotes.supprimerHote();
				} catch (Exception e) {
					System.out.println("Mauvais entrée, réessayez");
					Menu.sc.nextLine();
				}
				GestionHotes.listerHotes();
				break;
			case 3:
				Menu.listerMenu();
				break;
			default:
				break;
		}
	}

	private static void supprimerHote() throws Exception {
		System.out.println("Entre l'indice à supprimer : ");
		int indice = Menu.choix(Menu.listHote.size(), true) - 1;
		Menu.listHote.remove(indice);
		System.out.println("Hôte définitivement supprimé !");
	}

	private static void ajouterHote() throws Exception {
		System.out.print("Entrez le prénom : ");
		String firstName = Menu.sc.next();
		System.out.print("Entrez le nom : ");
		String lastName = Menu.sc.next();
		System.out.print("Entrez l'âge : ");
		int age = Menu.sc.nextInt();

		Hote hote = new Hote(firstName, lastName, age, 12);
		Menu.listHote.add(hote);
		System.out.println("Hôte ajouté avec succès !");
	}
}
