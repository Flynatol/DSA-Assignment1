package dsa_assignment1;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class MLNode<E> implements MLNodeInterface<E>
{
	private E			item;
	private MLNodeInterface<E>	next1;
	private MLNodeInterface<E>	prev1;
	private MLNodeInterface<E>	next2;
	private MLNodeInterface<E>	prev2;

	final static Logger logger = Logger.getLogger(MLNode.class);
	
	/**#
	 * For marking purposes
	 * 
	 * @return Your student id
	 */
	public String getStudentID()
	{
		/* WRITE THIS CODE */

		// Change this return value to return your University Student Id number, e.g. 
		// return "1234567";
		logger.log(Level.TRACE, "test2");
		return "2029844";
	}

	/**
	 * For marking purposes
	 * 
	 * @return Your name
	 */
	public String getStudentName()
	{
		/* WRITE THIS CODE */

		// Change this return value to return your name, e.g.
		// return "John Smith";
		return "Flynn McGouran-Collins";
	}

	MLNode(E element)
	{
		this.item = element;
		this.next1 = this.prev1 = this.next2 = this.prev2 = this;
	}

	public MLNodeInterface<E> remove1()
	{
		this.prev1.setNext1(this.next1);
		this.next1.setPrev1(this.prev1);

		this.next1 = this;
		this.prev1 = this;

		return this;
	}

	public MLNodeInterface<E> remove2()
	{
		this.prev2.setNext2(this.next2);
		this.next2.setPrev2(this.prev2);

		this.next2 = this;
		this.prev2 = this;

		return this;
	}

	public MLNodeInterface<E> addAfter1(MLNodeInterface<E> target)
	{
		this.remove1();

		this.setNext1(target.getNext1());
		this.setPrev1(target);

		target.getNext1().setPrev1(this);
		target.setNext1(this);

		return this;
	}

	public MLNodeInterface<E> addAfter2(MLNodeInterface<E> target)
	{
		this.remove2();

		this.setNext2(target.getNext2());
		this.setPrev2(target);

		target.getNext2().setPrev2(this);
		target.setNext2(this);

		return this;
	}

	public MLNodeInterface<E> addBefore1(MLNodeInterface<E> target)
	{
		this.remove1();

		this.setNext1(target);
		this.setPrev1(target.getPrev1());

		target.getPrev1().setNext1(this);
		target.setPrev1(this);

		return this;
	}

	public MLNodeInterface<E> addBefore2(MLNodeInterface<E> target)
	{
		this.remove2();

		this.setNext2(target);
		this.setPrev2(target.getPrev2());

		target.getPrev2().setNext2(this);
		target.setPrev2(this);

		return this;
	}
	
	public E getElement()
	{
		return item;
	}

	public MLNodeInterface<E> getNext1()
	{
		return next1;
	}

	public MLNodeInterface<E> getPrev1()
	{
		return prev1;
	}

	public MLNodeInterface<E> getNext2()
	{
		return next2;
	}

	public MLNodeInterface<E> getPrev2()
	{
		return prev2;
	}

	public void setNext1(MLNodeInterface<E> next1)
	{
		this.next1 = next1;
	}

	public void setPrev1(MLNodeInterface<E> prev1)
	{
		this.prev1 = prev1;
	}

	public void setNext2(MLNodeInterface<E> next2)
	{
		this.next2 = next2;
	}

	public void setPrev2(MLNodeInterface<E> prev2)
	{
		this.prev2 = prev2;
	}
}
