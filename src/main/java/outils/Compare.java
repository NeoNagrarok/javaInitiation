package outils;

import java.util.ArrayList;

import logements.Logement;

public class Compare<T extends ComparatorInterface> extends ArrayList<T>{
	private static final long serialVersionUID = 1L;
	private T attr1 = null;
	private T attr2 = null;

	public Compare(T attr1, T attr2) {
		this.attr1 = attr1;
		this.attr2 = attr2;
	}

	public Compare()
	{
		super();
	}

	public T getHigher()
	{
		if (attr1 != null && attr2 != null)
			return (T)attr1.getHigher(attr2);
		int size = this.size();
		if (size == 0)
			return null;
		else if (size == 1)
			return (T)this.get(0);
		T result = (T)this.get(0);
		for (int i = 1; i < size; i++)
			if (i + 1 < size)
				result = (T)result.getHigher((T)this.get(i+1));
		return result;
	}

	public T getLower()
	{
		if (attr1 != null && attr2 != null)
			return (T)attr1.getLower(attr2);
		int size = this.size();
		if (size == 0)
			return null;
		else if (size == 1)
			return (T)this.get(0);
		T result = (T)this.get(0);
		for (int i = 1; i < size; i++)
			result = (T)result.getLower((T)this.get(i));
		return result;
	}

}
