package dsa_assignment1;

public class OrderedMruList<E extends Comparable<E>> implements OrderedMruListInterface<E>
{
	/**
	 * The head field is an <code>MLNode</code> object, where the
	 * <code>next1</code> and <code>prev1</code> pointers are for the circular Ordered list,
	 * and the <code>next2</code> and <code>prev2</code> are for the circular MRU list.
	 * It always contains the value <code>Null</code>.
	 * These lists are considered empty if there is no
	 * <b>other</b> <code>MLNode</code> object on the lists other
	 * than the <code>head</code> node itself
	 * 
	 */
	MLNodeInterface<E>	head	= new MLNode<E>(null);

	public OrderedMruList()
	{
	}
	
	public boolean isEmptyOrdered()
	{
		/* WRITE THIS CODE */
		return false;
	}

	public boolean isEmptyMru()
	{
		/* WRITE THIS CODE */
		return false;
	}

	public OrderedMruListInterface<E> touch(MLNodeInterface<E> target)
	{
		/* WRITE THIS CODE */
		return null;
	}
	
	public MLNodeInterface<E> getFirstMru()
	{
		/* WRITE THIS CODE */
		return null;
	}
	
	public MLNodeInterface<E> getFirstOrdered()
	{
		/* WRITE THIS CODE */
		return null;
	}
	
	public MLNodeInterface<E> getNextOrdered(MLNodeInterface<E> current)
	{
		/* WRITE THIS CODE */
		return null;
	}

	public MLNodeInterface<E> getNextMru(MLNodeInterface<E> current)
	{
		/* WRITE THIS CODE */
		return null;
	}

	public OrderedMruListInterface<E> remove(MLNodeInterface<E> target)
	{
		/* WRITE THIS CODE */
		return null;
	}
	
	public OrderedMruListInterface<E> add(E element)
	{
		/* WRITE THIS CODE */
		return null;
	}
}
