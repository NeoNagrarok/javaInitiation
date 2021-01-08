package menu;

import java.lang.reflect.Constructor;

import logements.Appartement;
import logements.Logement;
import logements.Maison;
import utilisateurs.Hote;

public class GestionLogement {

	public static void listerLogements() {
		System.out.println("-------------------------------------\n" + "Liste des Logements\n");
		Menu.displayList(Menu.listLogement);
		System.out.println(
				"Saisir une option : \n" + "1 : Ajoutez un logement\n" + "2 : Supprimer un logement\n" + "3 : Retour");

		switch (Menu.choix(3)) {
			case 1:
				try {
					GestionLogement.ajouterLogement();
				} catch (Exception e) {
					System.out.println(Menu.RED + "Mauvaise entrée, réessayez" + Menu.RESET);
					e.printStackTrace();
					Menu.sc.nextLine();
				}
				GestionLogement.listerLogements();
				break;
			case 2:
				try {
					GestionLogement.supprimerLogement();
				} catch (Exception e) {
					System.out.println(Menu.RED + "Mauvaise entrée, réessayez" + Menu.RESET);
					Menu.sc.nextLine();
				}
				GestionLogement.listerLogements();
				break;
			case 3:
				Menu.listerMenu();
				break;
			default:
				break;
		}
	}

	private static void supprimerLogement() throws Exception {
		System.out.println("Entre l'indice à supprimer : ");
		int indice = Menu.choix(Menu.listLogement.size(), true) - 1;
		Menu.listLogement.remove(indice);
		System.out.println("Logement définitivement supprimé !");
	}

	private static void ajouterLogement() throws Exception {
		String typesLogement[] = {"Maison", "Appartement"};

		Menu.displayList(Menu.listHote);
		System.out.print("Entrez le numéro d'un hôte : ");
		Hote hote = (Hote)Menu.listHote.get(Menu.choix(Menu.listHote.size(), true) - 1);
		System.out.print("Entrez le numéro correspondant au type de logement : ");
		String type = typesLogement[Menu.choix(typesLogement.length, true) - 1];
		System.out.print("Entrez le tarif par nuit : ");
		int tarifParNuit = Menu.sc.nextInt();
		System.out.print("Entrez l'adresse : ");
		String adresse = Menu.sc.next();
		Menu.sc.nextLine();
		System.out.print("Entrez la superficie : ");
		int superficie = Menu.sc.nextInt();
		System.out.print("Entrez le nombre de voyageurs maximum : ");
		int nbVoyageurs = Menu.sc.nextInt();

		Object maisonSuperficieOrAppartementFloor = null;
		Object maisonHasSwimmingpoolOrAppartementSuperficie = null;

		if (type == "Maison")
		{
			System.out.print("Entrez la superficie du jardin (0 si il n'y a pas de jardin) : ");
			maisonSuperficieOrAppartementFloor = Menu.sc.nextInt();
			System.out.print("Y a-t-il une piscine ? (1: oui, 2: non) : ");
			maisonHasSwimmingpoolOrAppartementSuperficie = Menu.sc.nextInt() == 1 ? true : false;
		}
		else if (type == "Appartement")
		{
			System.out.print("Entrez l'étage : ");
			maisonSuperficieOrAppartementFloor = Menu.sc.nextInt();
			System.out.print("Entrez la superficie du balcon (0 si il n'y a pas de balcon) : ");
			maisonHasSwimmingpoolOrAppartementSuperficie = Menu.sc.nextInt();
		}

		Class<?> c = Class.forName("logements." + type);

		Logement logement = (Logement) c.getConstructors()[0].newInstance(
			hote,
			tarifParNuit,
			adresse,
			superficie,
			nbVoyageurs,
			maisonSuperficieOrAppartementFloor, //superficieJardin,
			maisonHasSwimmingpoolOrAppartementSuperficie //possedePiscine
		);

		Menu.listLogement.add(logement);
		System.out.println(Menu.GREEN + "Logement ajouté avec succès !" + Menu.RESET);
	}

}
