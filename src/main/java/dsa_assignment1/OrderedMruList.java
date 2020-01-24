package dsa_assignment1;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

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

	final static Logger logger = Logger.getLogger(MLNode.class);


	public OrderedMruList()
	{
	}
	
	public boolean isEmptyOrdered()
	{
		if (head == head.getNext1()) {
			return true;
		}

		return false;
	}

	public boolean isEmptyMru()
	{
		if (head == head.getNext2()){
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
			logger.log(Level.TRACE, "MRU EMPTY");
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
		MLNodeInterface<E> elementNode = new MLNode<E>(element);

		elementNode.addAfter2(head);

		//logger.trace("test " + elementNode.getPrev2().getElement().toString());

		if (isEmptyOrdered()){
			elementNode.addAfter1(head);
		} else {
			int comparison;
			MLNodeInterface<E> currentElement = head.getNext1();


			while (currentElement != head){
				comparison = elementNode.getElement().compareTo(currentElement.getElement());

				if (comparison < 0) {
					elementNode.addBefore1(currentElement);
					break;
				}

				currentElement = currentElement.getNext1();
			}


		}

		return this;
	}
}
