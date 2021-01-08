package menu;

import logements.Logement;
import outils.MyDate;
import reservations.Reservation;
import reservations.Sejour;
import reservations.SejourCourt;
import reservations.SejourLong;
import utilisateurs.Voyageur;

public class GestionReservation {

	public static void listerReservation() {
		System.out.println("-------------------------------------\n" + "Liste des Réservations\n");
		Menu.displayList(Menu.listReservation);
		System.out.println("Saisir une option : \n" + "1 : Ajoutez une réservation\n"
				+ "2 : Supprimer une réservation\n" + "3 : Retour");

		switch (Menu.choix(3)) {
			case 1:
				try {
					GestionReservation.ajouterReservation();
				} catch (Exception e) {
					System.out.println("Mauvaise entrée, réessayez");
					e.printStackTrace();
					Menu.sc.nextLine();
				}
				GestionReservation.listerReservation();
				break;
			case 2:
				try {
					GestionReservation.supprimerResrvation();
				} catch (Exception e) {
					System.out.println("Mauvaise entrée, réessayez");
					Menu.sc.nextLine();
				}
				GestionReservation.listerReservation();
				break;
			case 3:
				Menu.listerMenu();
				break;
			default:
				break;
		}
	}

	private static void supprimerResrvation() throws Exception {
		System.out.println("Entre l'indice à supprimer : ");
		int indice = Menu.choix(Menu.listReservation.size(), true) - 1;
		Menu.listReservation.remove(indice);
		System.out.println("Réservation définitivement supprimé !");
	}

	private static void ajouterReservation() throws Exception  {
		Menu.displayList(Menu.listVoyageur);
		System.out.println("Entrez le numro d'un voyageur : ");
		int numVoyageur = Menu.choix(Menu.listVoyageur.size(), true);
		Voyageur voyageur = (Voyageur) Menu.listVoyageur.get(numVoyageur - 1);

		Menu.displayList(Menu.listLogement);
		System.out.println("Entrez le numro d'un logement : ");
		int numLogement = Menu.choix(Menu.listLogement.size(), true);
		Logement logement = (Logement) Menu.listLogement.get(numLogement - 1);

		System.out.println("Choisissez une date (format MM/dd/yyyy) : ");
		String dateArrivee = Menu.sc.next();
		System.out.print("Nombre de nuits : ");
		int nbNuits = Menu.sc.nextInt();
		System.out.print("Nombre de voyageurs : ");
		int nbVoyageurs = Menu.sc.nextInt();

		MyDate myDate = new MyDate(dateArrivee);
		Sejour sejour = nbNuits >= 6 ? new SejourLong(myDate, nbNuits, logement, nbVoyageurs)
				: new SejourCourt(new MyDate(dateArrivee), nbNuits, logement, nbVoyageurs);

		Reservation reservation;
		try {
			reservation = new Reservation(voyageur, sejour, true);
			Menu.listReservation.add(reservation);
			String toLog = "Numéro du voyageur : " + numVoyageur	+ "\n" +
				"Numéro du logement : " + numLogement				+ "\n" +
				"Date d'arrivée (DD/MM/YYY) : " + myDate			+ "\n" +
				"Nombre de nuits : " + nbNuits						+ "\n" +
				"Nombre de personnes" + nbVoyageurs					+ "\n" +
				"------------------------------";
			reservation.log(toLog);
			System.out.println("Réservation ajouté avec succès !");
		} catch (Exception e) {
			System.out.println("La réservation n'a pas pu s'effectuer car le séjour n'est pas valable !");
		}
	}

}
