package outils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @author LeFodeurCou
 * @version 1.0
 */
public class MyDate extends Date
{
	Date date;

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	
	public MyDate()
	{
		super();
	}

	/**
	 * Initialize a date with a String
	 * @param date
	 */
	public MyDate(String date)
	{
		this.date = new Date(date);
	}

	/**
	 * Initialize a date with the day, the month and the year
	 * @param day
	 * @param month
	 * @param year
	 */
	public MyDate(int day, int month, int year)
	{
		this.date = new Date(month + "/" + day + "/" + year);
	}

	/**
	 * @return String
	 */
	public String toString()
	{
		return (new SimpleDateFormat("dd/MM/yyyy", Locale.FRENCH)).format(this.date);
	}

}
