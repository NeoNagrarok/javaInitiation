package menu;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import outils.IDisplayable;

public class Menu {

	static Scanner sc;
	static List<IDisplayable> listHote;
	static List<IDisplayable> listLogement;
	static List<IDisplayable> listVoyageur;
	static List<IDisplayable> listReservation;

	public static void main(String[] args) {
		System.out.println("Bienvenu chez AirBnB");

		Menu.listHote = new ArrayList<>();
		Menu.listLogement = new ArrayList<>();
		Menu.listVoyageur = new ArrayList<>();
		Menu.listReservation = new ArrayList<>();

		Menu.sc = new Scanner(System.in);

		Menu.listerMenu();

		Menu.sc.close();
	}

	static void listerMenu()
	{
		System.out.println(
			"-------------------------------------\n"	+
			"Saisir une option : \n"					+
			"1 : Liste des hôtes\n"						+
			"2 : Liste des logements\n"					+
			"3 : Liste des voyageurs\n"					+
			"4 : Liste des réservations\n"				+
			"5 : Fermer le programme"
		);

		switch (Menu.choix(5)) {
			case 1:
				GestionHotes.listerHotes();
				break;
			case 2:
				GestionLogement.listerLogements();
				break;
			case 3:
				GestionVoyageur.listerVoyageur();
				break;
			case 4:
				GestionReservation.listerReservation();
				break;
			default:
				break;
		}
	}

	static int choix(int maxValue)
	{
		int value = 0;

		try {
			value = Menu.sc.nextInt();
		} catch (Exception e) {
			System.err.println("Veuillez ne pas rentrer autre chose qu'un nombre, réessayez !");
			Menu.sc.nextLine();
			value = Menu.choix(maxValue);
		}

		if (value < 1 || value > maxValue)
		{
			System.err.println("Ce choix n'est pas disponible, réessayez !");
			value = Menu.choix(maxValue);
		}

		return value;
	}

	static int choix(int maxValue, boolean noException) throws Exception
	{
		int value = 0;
		value = Menu.sc.nextInt();

		if (value < 1 || value > maxValue)
		{
			System.err.println("Ce choix n'est pas disponible, réessayez !");
			value = Menu.choix(maxValue);
		}

		return value;
	}

	public static void displayList(List<IDisplayable> list)
	{
		int size = list.size();
		for (int i = 0; i < size; i++) {
			System.out.print((i + 1) + " : ");
			list.get(i).afficher();
			System.out.println();
		}
	}
}