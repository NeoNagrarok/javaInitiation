package outils;

public interface ComparatorInterface {
	public abstract ComparatorInterface getHigher(ComparatorInterface item);
	public abstract ComparatorInterface getLower(ComparatorInterface item);
}
