package menu;

import utilisateurs.Voyageur;

public class GestionVoyageur {

	public static void listerVoyageur() {
		System.out.println("-------------------------------------\n" + "Liste des Voyageurs\n");
		Menu.displayList(Menu.listVoyageur);
		System.out.println(
				"Saisir une option : \n" + "1 : Ajoutez un voyageur\n" + "2 : Supprimer un voyageur\n" + "3 : Retour");

		switch (Menu.choix(3)) {
			case 1:
				try {
					GestionVoyageur.ajouterVoyageur();
				} catch (Exception e) {
					System.out.println(Menu.RED + "Mauvaise entrée, réessayez" + Menu.RESET);
					Menu.sc.nextLine();
				}
				GestionVoyageur.listerVoyageur();
				break;
			case 2:
				try {
					GestionVoyageur.supprimerVoyageur();
				} catch (Exception e) {
					System.out.println(Menu.RED + "Mauvaise entrée, réessayez" + Menu.RESET);
					Menu.sc.nextLine();
				}
				GestionVoyageur.listerVoyageur();
				break;
			case 3:
				Menu.listerMenu();
				break;
			default:
				break;
		}
	}

	private static void supprimerVoyageur() throws Exception {
		System.out.println("Entre l'indice à supprimer : ");
		int indice = Menu.choix(Menu.listVoyageur.size(), true) - 1;
		Menu.listVoyageur.remove(indice);
		System.out.println("Voyageur définitivement supprimé !");
	}

	private static void ajouterVoyageur() throws Exception {
		System.out.print("Entrez le prénom : ");
		String firstName = Menu.sc.next();
		System.out.print("Entrez le nom : ");
		String lastName = Menu.sc.next();
		System.out.print("Entrez l'âge : ");
		int age = Menu.sc.nextInt();

		Voyageur hote = new Voyageur(firstName, lastName, age);
		Menu.listVoyageur.add(hote);
		System.out.println(Menu.GREEN + "Voyageur ajouté avec succès !" + Menu.RESET);
	}

}
