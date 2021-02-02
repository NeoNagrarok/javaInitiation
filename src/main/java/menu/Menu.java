package menu;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import logements.Logement;
import logements.Appartement;
import logements.Maison;
import outils.ComparatorInterface;
import outils.Compare;
import outils.IDisplayable;
import utilisateurs.Hote;

public class Menu {

	static Scanner sc;
	static List<IDisplayable> listHote;
	static List<IDisplayable> listLogement;
	static List<IDisplayable> listVoyageur;
	static List<IDisplayable> listReservation;
	public static final String RESET = "\u001B[0m";
	public static final String BLACK = "\u001B[30m";
	public static final String RED = "\u001B[31m";
	public static final String GREEN = "\u001B[32m";
	public static final String YELLOW = "\u001B[33m";
	public static final String BLUE = "\u001B[34m";
	public static final String PURPLE = "\u001B[35m";
	public static final String CYAN = "\u001B[36m";
	public static final String WHITE = "\u001B[37m";
	public static final ArrayList<Logement> logements = new ArrayList<>();
	public static final ArrayList<Hote> hotes = new ArrayList<>();
	public static final HashMap<String, Object> cache = new HashMap<>();

	public static void main(String[] args) {
		System.out.println(Menu.GREEN + "Bienvenu chez AirBnB" + Menu.RESET);

		// System.out.println("Parse XML");
		String xml = null;
		try {
			xml = new String(Files.readAllBytes(Paths.get("logements.xml")), StandardCharsets.UTF_8);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Tokenize xml
		xml = xml.replaceAll("\\n|\\r|\\t|(?:<\\?xml version=\"\\d\\.\\d\"\\?>)?", "");
		Menu.parseXML(xml);

		// Menu.listHote = new ArrayList<>();
		// Menu.listLogement = new ArrayList<>();
		// Menu.listVoyageur = new ArrayList<>();
		// Menu.listReservation = new ArrayList<>();

		// Menu.sc = new Scanner(System.in);

		// Menu.listerMenu();

		// Menu.sc.close();
	}

	static void listerMenu() {
		System.out.println("-------------------------------------\n" + "Saisir une option : \n"
				+ "1 : Liste des hôtes\n" + "2 : Liste des logements\n" + "3 : Liste des voyageurs\n"
				+ "4 : Liste des réservations\n" + "5 : Fermer le programme");

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

	static int choix(int maxValue) {
		int value = 0;

		try {
			value = Menu.sc.nextInt();
		} catch (Exception e) {
			System.err.println(Menu.RED + "Veuillez ne pas rentrer autre chose qu'un nombre, réessayez !" + Menu.RESET);
			Menu.sc.nextLine();
			value = Menu.choix(maxValue);
		}

		if (value < 1 || value > maxValue) {
			System.err.println(Menu.RED + "Ce choix n'est pas disponible, réessayez !" + Menu.RESET);
			value = Menu.choix(maxValue);
		}

		return value;
	}

	static int choix(int maxValue, boolean noException) throws Exception {
		int value = 0;
		value = Menu.sc.nextInt();

		if (value < 1 || value > maxValue) {
			System.err.println(Menu.RED + "Ce choix n'est pas disponible, réessayez !" + Menu.RESET);
			value = Menu.choix(maxValue);
		}

		return value;
	}

	public static void displayList(List<IDisplayable> list) {
		int size = list.size();
		for (int i = 0; i < size; i++) {
			System.out.print((i + 1) + " : ");
			list.get(i).afficher();
			System.out.println();
		}
	}

	private static void parseXML(String xml) {
		String classString = xml.replaceAll("(<([a-zA-Z]+?)>)(.*?)</\\2>", "$2");
		xml = xml.replaceAll("(<([a-zA-Z]+?)>)(.*?)</\\2>", "$3");

		Class<?> c = null;

		HashMap<String, Hote> hoteDupe = new HashMap<>();


		Matcher m = Pattern.compile("(<([a-zA-Z]+?)>)(.*?)</\\2>").matcher(xml);
		int count = 0;
		while (m.find())
		{
			classString = m.group().replaceAll("(<([a-zA-Z]+?)>)(.*?)</\\2>", "$2");
			String xmlLogement = m.group().replaceAll("(<([a-zA-Z]+?)>)(.*?)</\\2>", "$3");
			try {
				c = Class.forName("logements." + classString);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			HashMap<String, Object> LogementMap = new HashMap<>();
			// System.out.println(classString + "\n");
			Matcher n = Pattern.compile("(<([a-zA-Z]+?)>)(.*?)</\\2>").matcher(xmlLogement);
			while (n.find())
			{
				// System.out.println(n.group());
				// System.out.println("---------------------");
				classString = n.group().replaceAll("(<([a-zA-Z]+?)>)(.*?)</\\2>", "$2");
				String value = n.group().replaceAll("(<([a-zA-Z]+?)>)(.*?)</\\2>", "$3");
				if (classString.equals("hote"))
				{
					// System.out.println("Hote");
					Matcher o = Pattern.compile("(<([a-zA-Z]+?)>)(.*?)</\\2>").matcher(value);
					HashMap<String, Object> HoteMap = new HashMap<>();
					while (o.find())
					{
						classString = o.group().replaceAll("(<([a-zA-Z]+?)>)(.*?)</\\2>", "$2");
						value = o.group().replaceAll("(<([a-zA-Z]+?)>)(.*?)</\\2>", "$3");
						// System.out.println("   " + classString + " : " + value);
						HoteMap.put(classString, value);
					}
					if (hoteDupe.get(n.group()) != null)
						LogementMap.put("hote", hoteDupe.get(n.group()));
					else
					{
						Hote hote = new Hote((String)HoteMap.get("prenom"), (String)HoteMap.get("nom"), Integer.parseInt((String)HoteMap.get("age")), Integer.parseInt((String)HoteMap.get("delaiReponse")));
						Menu.hotes.add(hote);
						hoteDupe.put(n.group(), hote);
						LogementMap.put("hote", hote);
					}
				}
				else
				{
					// System.out.println(classString + " : " + value);
					LogementMap.put(classString, value);
				}
			}
			// System.out.println();
			// System.out.println(c + "\n");
			// System.out.println("----------------------------------------");

			Logement logement = null;
			try {
					logement = (Logement) c.getConstructors()[0].newInstance(
						(Hote)LogementMap.get("hote"), // hote,
						Integer.parseInt((String)LogementMap.get("tarifParNuit")), // tarifParNuit,
						(String)LogementMap.get("adresse"), // adresse,
						Integer.parseInt((String)LogementMap.get("superficie")), // superficie,
						Integer.parseInt((String)LogementMap.get("nbVoyageursMax")), // nbVoyageurs,
						Integer.parseInt((String)(LogementMap.get("superficieJardin") != null ? LogementMap.get("superficieJardin") : LogementMap.get("numeroEtage"))),
						(LogementMap.get("possedePiscine") != null ? (boolean)(1 == Integer.parseInt((String)LogementMap.get("possedePiscine"))) : Integer.parseInt((String)(LogementMap.get("numeroEtage"))))
					);
					logement.setName("" + count);
			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException | SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Menu.logements.add(logement);
			++count;
		}

		int size = Menu.logements.size();
		for(int i=0;i<size;i++){
			Logement logement = Menu.logements.get(i);
			logement.afficher();
			System.out.println("Name : " + logement.getName());
			System.out.println();
		}
		System.out.println("--------------------------------");
		size = Menu.hotes.size();
		for(int i=0;i<size;i++){
			Menu.hotes.get(i).afficher();
			System.out.println();
		}
		System.out.println("--------------------------------");
		Appartement resultAppartement = Menu.findAppartementByName("2");
		if (resultAppartement != null)
			resultAppartement.afficher();
		else
			System.out.println("Pas d'appartement correspondant");
		System.out.println("--------------------------------");
		Maison resultMaison = Menu.findMaisonByName("4");
		if (resultMaison != null)
			resultMaison.afficher();
		else
			System.out.println("Pas de maison correspondant");
		System.out.println("--------------------------------");
		Logement resultLogement = Menu.findLogementByName("2");
		if (resultLogement != null)
			resultLogement.afficher();
		else
			System.out.println("Pas de logement correspondant");
		System.out.println("--------------------------------");
		resultLogement = Menu.findLogementByName("4");
		if (resultLogement != null)
			resultLogement.afficher();
		else
			System.out.println("Pas de logement correspondant");
		System.out.println("--------------------------------");
		resultMaison = Menu.findLogementByNameWithGenericity("4");
		if (resultMaison != null)
			resultMaison.afficher();
		else
			System.out.println("Pas de maison correspondant");
		System.out.println("--------------------------------");
		resultLogement = Menu.findLogementByName("1");
		if (resultLogement != null)
			resultLogement.afficher();
		else
			System.out.println("Pas de logement correspondant");
		System.out.println("--------------------------------");
		System.out.println("--------------------------------");
		Compare<Logement> comparer = new Compare<>();
		comparer.add((Logement)resultMaison);
		comparer.add((Logement)resultAppartement);
		comparer.add(resultLogement);

		if (comparer != null)
		{
			comparer.getHigher().afficher();
			System.out.println("--------------------------------");
			comparer.getLower().afficher();
		}
		// System.out.println("End Parse XML");
	}

	public static Appartement findAppartementByName(String needle)
	{
		Object cache = Menu.cache.get(needle);
		if (cache != null && cache.getClass().getName().equals("logements.Appartement"))
			return (Appartement)cache;
		int size = Menu.logements.size();
		for(int i=0;i<size;i++){
			Logement logement = Menu.logements.get(i);
			String name = logement.getName();
			if (name.equals(needle) && logement.getClass().getName().equals("logements.Appartement"))
			{
				Menu.cache.put(name, logement);
				return (Appartement)logement;
			}
		}
		return null;
	}


	public static Maison findMaisonByName(String needle)
	{
		Object cache = Menu.cache.get(needle);
		if (cache != null && cache.getClass().getName().equals("logements.Maison"))
			return (Maison)cache;
		int size = Menu.logements.size();
		for(int i=0;i<size;i++){
			Logement logement = Menu.logements.get(i);
			String name = logement.getName();
			if (name.equals(needle) && logement.getClass().getName().equals("logements.Maison"))
			{
				Menu.cache.put(name, logement);
				return (Maison)logement;
			}
		}
		return null;
	}

	public static Logement findLogementByName(String needle)
	{
		Object cache = Menu.cache.get(needle);
		if (cache != null)
			return (Logement)cache;
		int size = Menu.logements.size();
		for(int i=0;i<size;i++){
			Logement logement = Menu.logements.get(i);
			String name = logement.getName();
			if (name.equals(needle))
			{
				Menu.cache.put(name, logement);
				return logement;
			}
		}
		return null;
	}

	public static <T extends Logement> T findLogementByNameWithGenericity(String needle)
	{
		Object cache = Menu.cache.get(needle);
		try {
			if (cache != null)
			{
				T data = (T) cache;
				return data;
			}
		} catch (Exception e) {
			int size = Menu.logements.size();
			for(int i=0;i<size;i++){
				try
				{
					T logement = (T)Menu.logements.get(i);
					String name = logement.getName();
					if (name.equals(needle))
					{
						Menu.cache.put(name, logement);
						return logement;
					}
				}
				catch (Exception ex){}
			}
		}
		return null;
	}
}