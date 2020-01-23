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
		if (head == head.getNext2()) {
			return true;
		}

		return false;
	}

	public boolean isEmptyMru()
	{
		if (head == head.getNext1()){
			return true;
		}

		return false;
	}

	public OrderedMruListInterface<E> touch(MLNodeInterface<E> target)
	{
		target.remove2();
		target.addAfter2(head);

		return this;
	}
	
	public MLNodeInterface<E> getFirstMru()
	{
		if (this.isEmptyMru()) {
			return null;
		}

		return head.getNext2();
	}
	
	public MLNodeInterface<E> getFirstOrdered()
	{
		if (this.isEmptyOrdered()) {
			return null;
		}

		return head.getNext1();
	}
	
	public MLNodeInterface<E> getNextOrdered(MLNodeInterface<E> current)
	{
		if (current.getNext1() == head) {
			return null;
		}

		return current.getNext1();
	}

	public MLNodeInterface<E> getNextMru(MLNodeInterface<E> current)
	{
		if (current.getNext2() == head) {
			return null;
		}

		return current.getNext2();
	}

	public OrderedMruListInterface<E> remove(MLNodeInterface<E> target)
	{
		target.remove1();
		target.remove2();

		return this;
	}
	
	public OrderedMruListInterface<E> add(E element)
	{
		MLNode temp = new MLNode(element);

		head.addAfter2(temp);

		return this;
	}
}
