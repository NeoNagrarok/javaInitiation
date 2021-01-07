package menu;

import java.util.Scanner;

public class Menu {
	
	static Scanner sc;

	public static void main(String[] args) {
		System.out.println("Bienvenu chez AirBnB");
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
				
				break;
			case 3:
				
				break;
			case 4:
				
				break;
			case 5:
				
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
}
