package outils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @author LeFodeurCou
 * @version 1.0
 */
public class Utile
{
	/**
	 *
	 * @param date
	 * @return
	 */
	public static Date getDate(String date)
	{
		return new Date(date);
	}

	/**
	 * Craft this f*****g date from three integers ;)
	 * @param day
	 * @param month
	 * @param year
	 * @return
	 */
	public static Date getDate(int day, int month, int year)
	{
		return new Date(month + "/" + day + "/" + year);
	}

	/**
	 * 
	 * @param date
	 * @return
	 */
	public static String dateToString(Date date)
	{
		return (new SimpleDateFormat("dd/MM/yyyy", Locale.FRENCH)).format(date);
	}

	/**
	 * For console purpose only, display a visual separator to improve clarity
	 */
	public static void separator()
	{
		System.out.println("________________________________________________");
	}
}
