public class CountedElement<E extends Comparable<E>> implements Comparable<CountedElement<E>> {
	private E element;
	private int count;

	public CountedElement(E e, int count){
		//constructor - to complete
		this.element = e;
		this.count = count;
	}
	
	public CountedElement(E e){
		//constructor - to complete
		this.element = e;
	}

	//add getters and setters

	public E getElement() {
		return element;
	}

	public void setElement(E element) {
		this.element = element;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}


	//add toString() method


    @java.lang.Override
    public java.lang.String toString() {
        return "("  + element + ", " + count + ')';
    }

    @Override
    public int compareTo(CountedElement<E> sC1) {
    
		//to complete

		return getElement().compareTo(sC1.getElement());
	}

}
